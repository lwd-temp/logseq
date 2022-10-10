(ns frontend.handler.plugin-config
  "This system component encapsulates the global plugin.edn and depends on the
  global-config component. This component is only enabled? if both the
  global-config and plugin components are enabled"
  (:require [frontend.handler.global-config :as global-config-handler]
            ["path" :as path]
            [promesa.core :as p]
            [borkdude.rewrite-edn :as rewrite]
            [frontend.fs :as fs]
            [frontend.state :as state]
            [frontend.handler.notification :as notification]
            [frontend.handler.common.plugin :as plugin-common-handler]
            [clojure.edn :as edn]
            [clojure.set :as set]
            [clojure.pprint :as pprint]
            [malli.core :as m]
            [malli.error :as me]
            [frontend.schema.handler.plugin-config :as plugin-config-schema]
            [cljs-bean.core :as bean]
            [lambdaisland.glogi :as log]))

(defn plugin-config-path
  []
  (path/join (global-config-handler/global-config-dir) "plugins.edn"))

(def common-plugin-keys
  "Vec of plugin keys to store in plugins.edn and to compare with installed-plugins state"
  (->> plugin-config-schema/Plugin rest (mapv first)))

(defn add-or-update-plugin
  "Adds or updates a plugin from plugin.edn"
  [{:keys [id] :as plugin}]
  (p/let [content (fs/read-file "" (plugin-config-path))
          updated-content (-> content
                              rewrite/parse-string
                              (rewrite/assoc (keyword id) (select-keys plugin common-plugin-keys))
                              str)]
         ;; fs protocols require repo and dir when they aren't necessary. For this component,
         ;; neither is needed so these are nil and blank respectively
         (fs/write-file! nil "" (plugin-config-path) updated-content {:skip-compare? true})))

(defn remove-plugin
  "Removes a plugin from plugin.edn"
  [plugin-id]
  (p/let [content (fs/read-file "" (plugin-config-path))
          updated-content (-> content rewrite/parse-string (rewrite/dissoc (keyword plugin-id)) str)]
         (fs/write-file! nil "" (plugin-config-path) updated-content {:skip-compare? true})))

(defn- create-plugin-config-file-if-not-exists
  []
  (let [content (-> (:plugin/installed-plugins @state/state)
                    (update-vals #(select-keys % common-plugin-keys))
                    pprint/pprint
                    with-out-str)]
    (fs/create-if-not-exists nil @global-config-handler/root-dir (plugin-config-path) content)))

(defn- determine-plugins-to-change
  "Given installed plugins state and plugins from plugins.edn,
returns map of plugins to install and uninstall"
  [installed-plugins edn-plugins]
  ;; :name is removed from comparison because it isn't used for reproducible builds
  ;; and is just for display purposes
  (let [installed-plugins-set (->> installed-plugins
                                   vals
                                   (map #(-> (select-keys % common-plugin-keys)
                                             (assoc :id (keyword (:id %)))
                                             (dissoc :name)))
                                   set)
        edn-plugins-set (->> edn-plugins
                             (map (fn [[k v]] (-> v
                                                  (assoc :id k)
                                                  (dissoc :name))))
                             set)]
    (if (= installed-plugins-set edn-plugins-set)
      {}
      {:install (mapv #(assoc % :plugin-action "install")
                      (set/difference edn-plugins-set installed-plugins-set))
       :uninstall (vec (set/difference installed-plugins-set edn-plugins-set))})))

(defn open-sync-modal
  []
  (state/pub-event! [:go/plugins])
  (p/catch
   (p/let [edn-plugins* (fs/read-file "" (plugin-config-path))
           edn-plugins (edn/read-string edn-plugins*)]
          (if-let [errors (->> edn-plugins (m/explain plugin-config-schema/Plugins-edn) me/humanize)]
            (do
              (notification/show! "Invalid plugins.edn provided. See javascript console for specific errors"
                                  :error)
              (log/error :plugin-edn-errors errors))
            (let [plugins-to-change (determine-plugins-to-change
                                     (:plugin/installed-plugins @state/state)
                                     edn-plugins)]
              (state/pub-event! [:go/plugins-from-file plugins-to-change]))))
   (fn [e]
     (if (= :reader-exception (:type (ex-data e)))
       (notification/show! "Malformed plugins.edn provided. Please check the file has correct edn syntax."
                           :error)
       (log/error :unexpected-error e)))))

(defn replace-plugins
  "Replaces current plugins given plugins to install and uninstall"
  [plugins]
  (log/info :uninstall-plugins (:uninstall plugins))
  (doseq [plugin (:uninstall plugins)]
    (plugin-common-handler/unregister-plugin (name (:id plugin))))
  (log/info :install-plugins (:install plugins))
  (doseq [plugin (:install plugins)]
    (plugin-common-handler/install-marketplace-plugin plugin)))

(defn setup-install-listener!
  "Sets up a listener for the lsp-installed event to update plugins.edn"
  []
  (let [listener (fn listener [_ e]
                   (when-let [{:keys [status payload only-check]} (bean/->clj e)]
                     (when (and (= status "completed") (not only-check))
                       (let [{:keys [name title theme]} payload
                             ;; Same defaults as plugin/setup-install-listener!
                             name (or title name "Untitled")]
                         (add-or-update-plugin
                          (assoc payload
                                 :version (:installed-version payload)
                                 ;; Manual install doesn't have theme field but
                                 ;; plugin.edn requires this field
                                 :theme (if (some? theme) theme false)
                                 :name name))))))]
    (js/window.apis.addListener "lsp-installed" listener)))

(defn start
  "This component has just one reponsibility on start, to create a plugins.edn
  if none exists"
  []
  (create-plugin-config-file-if-not-exists))

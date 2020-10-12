(ns frontend.tools.dicts
  (:require [tongue.core :as tongue]
            [frontend.state :as state]
            [clojure.string :as string]))


;; TODO
;; - [ ] Localizing Number Formats
;; - [ ] Localizing Dates


(def dicts
  {:en {:on-boarding/title "Hi, welcome to Logseq!"
        :on-boarding/sharing "sharing"
        :on-boarding/is-a " is a "
        :on-boarding/local-first "local-first"
        :on-boarding/non-linear "non-linear"
        :on-boarding/outliner "outliner"
        :on-boarding/notebook-for-organizing-and " notebook for organizing and "
        :on-boarding/your-personal-knowledge-base " your personal knowledge base."
        :on-boarding/notice "Notice that this project is in its early days and under quick development, files might be corrupted."
        :on-boarding/features-desc "Use it to organize your todo list, to write your journals, or to record your unique life."
        :on-boarding/privacy "The server will never store or analyze your private notes. Your data are plain text files, we support both Markdown and Emacs Org mode for the time being. Even if the website is down or can't be maintained, your data is always yours."
        :on-boarding/inspired-by " is hugely inspired by "
        :on-boarding/where-are-my-notes-saved "Where are my notes saved?"
        :on-boarding/storage "Your notes will be stored in the local browser storage using "
        :on-boarding/how-do-i-use-it "How do I use it?"
        :on-boarding/use-1 "1. Sync between multiple devices"
        :on-boarding/use-1-desc "Currently, we only support syncing through Github, more options (Self-host git, WebDAV, Google Drive, etc.) will be added soon."
        :on-boarding/use-1-video "Check out this awesome video by "
        :on-boarding/use-2 "2. Use it locally (no need to login)"
        :on-boarding/use-2-desc "It's only for the testing purpose now, please don't write any serious notes without login."
        :on-boarding/features "Features"
        :on-boarding/features-backlinks "Backlinks between [[Page]]s"
        :on-boarding/features-block-embed "Block embed"
        :on-boarding/features-page-embed "Page embed"
        :on-boarding/features-graph-vis "Graph visualization"
        :on-boarding/features-heading-properties "Heading properties"
        :on-boarding/features-datalog "Datalog queries, the notes db is powered by "
        :on-boarding/features-custom-view-component "Custom view component"
        :on-boarding/integration " integration"
        :on-boarding/slide-support " slide support"
        :on-boarding/built-in-supports "Document built-in supports:"
        :on-boarding/supports-code-highlights "Code highlights"
        :on-boarding/supports-katex-latex "Katex latex"
        :on-boarding/raw "Raw "
        :on-boarding/raw-html "Raw html"
        :on-boarding/learn-more "Learn more"
        :on-boarding/discord-desc " where the community ask questions and share tips"
        :on-boarding/github-desc " everyone is encouraged to report issues!"
        :on-boarding/our-blog "Our blog: "
        :on-boarding/credits-to "Credits to"
        :on-boarding/clojure-desc " - A dynamic, functional, general-purpose programming language"
        :on-boarding/datascript-desc " - Immutable database and Datalog query engine for Clojure, ClojureScript and JS"
        :on-boarding/angstrom-desc-1 ", the document "
        :on-boarding/angstrom-desc-2 "parser"
        :on-boarding/angstrom-desc-3 " is built on Angstrom."
        :on-boarding/cuekeeper-desc " - Browser-based GTD (TODO list) system."
        :on-boarding/sci-desc " - Small Clojure Interpreter"
        :on-boarding/isomorphic-git-desc " - A pure JavaScript implementation of git for node and browsers!"
        :help/about "About Logseq"
        :help/bug "Bug report"
        :help/feature "Feature request"
        :help/changelog "Changelog"
        :help/blog "Logseq Blog"
        :help/privacy "Privacy policy"
        :help/terms "Terms"
        :help/community "Discord community"
        :help/shortcuts "Keyboard Shortcuts"
        :help/shortcuts-triggers "Triggers"
        :help/shortcut "Shortcut"
        :help/slash-autocomplete "Slash Autocomplete"
        :help/block-content-autocomplete "Block content (Src, Quote, Query, etc) Autocomplete"
        :help/reference-autocomplete "Page reference Autocomplete"
        :help/block-reference "Block Reference"
        :help/key-commands "Key Commands"
        :help/working-with-lists " (working with lists)"
        :help/indent-block-tab "Indent Block Tab"
        :help/unindent-block "Unindent Block"
        :help/move-block-up "Move Block Up"
        :help/move-block-down "Move Block Down"
        :help/create-new-block "Create New Block"
        :help/new-line-in-block "New Line in Block"
        :undo "Undo"
        :redo "Redo"
        :help/zoom-in "Zoom In"
        :help/zoom-out "Zoom out"
        :help/follow-link-under-cursor "Follow link under cursor"
        :help/open-link-in-sidebar "Open link in Sidebar"
        :expand "Expand"
        :collapse "Collapse"
        :select-block-above "Select Block Above"
        :select-block-below "Select Block Below"
        :select-all-blocks "Select All Blocks"
        :general "General"
        :help/toggle "Toggle help"
        :help/git-commit-message "Git commit message"
        :help/full-text-search "Full Text Search"
        :help/context-menu "Context Menu"
        :help/fold-unfold "Fold/Unfold blocks (when not in edit mode)"
        :help/toggle-doc-mode "Toggle document mode"
        :help/toggle-theme "Toggle between dark/light theme"
        :help/toggle-right-sidebar "Toggle right sidebar"
        :help/toggle-insert-new-block "Toggle Enter/Alt+Enter for inserting new block"
        :help/jump-to-journals "Jump to Journals"
        :formatting "Formatting"
        :help/markdown-syntax "Markdown syntax"
        :help/org-mode-syntax "Org mode syntax"
        :bold "Bold"
        :italics "Italics"
        :html-link "Html Link"
        :highlight "Highlight"
        :strikethrough "Strikethrough"
        :code "Code"
        :right-side-bar/help "Help"
        :right-side-bar/switch-theme "Switch to {1} theme"
        :right-side-bar/theme "{1} theme"
        :right-side-bar/page "Page graph"
        :right-side-bar/recent "Recent"
        :right-side-bar/contents "Contents"
        :right-side-bar/graph-ref "Graph of "
        :right-side-bar/block-ref "Block reference"
        :git/set-access-token "Set Github personal access token"
        :git/token-is-encrypted "The token will be encrypted and stored in the browser local storage"
        :git/token-server "The server will never store it"
        :git/create-personal-access-token "How to create a Github personal access token?"
        :git/push "Push now"
        :git/local-changes-synced "All local changes are synced!"
        :git/pull "Pull now"
        :git/last-pull "Last pulled at"
        :git/version "Version"
        :git/import-notes "Import your notes"
        :git/import-notes-helper "You can import your notes from a repo on Github."
        :git/add-another-repo "Add another repo"
        :git/re-index "Clone again and re-index the db"
        :git/message "Your commit message"
        :git/commit-and-push "Commit and push!"
        :git/use-remote "Use remote"
        :git/keep-local "Keep local"
        :git/edit "Edit"
        :git/title "Diff"
        :git/no-diffs "No diffs"
        :git/commit-message "Commit message (optional)"
        :git/pushing "Pushing"
        :git/force-push "Commit and force pushing"
        :git/a-force-push "A force push"
        :git/add-repo-prompt "Install Logseq on your repo"
        :git/add-repo-prompt-confirm "Add and install"
        :format/preferred-mode "What's your preferred mode?"
        :format/markdown "Markdown"
        :format/org-mode "Org Mode"
        :reference/linked "Linked Reference"
        :reference/unlinked-ref "Unlinked References"
        :project/setup "Setup a public project on Logseq"
        :project/location "All published pages will be located under"
        :project/sync-settings "Sync project settings"
        :page/presentation-mode "Presentation mode (Powered by Reveal.js)"
        :page/delete-success "Page {1} was deleted successfully!"
        :page/delete-confirmation "Are you sure you want to delete this page?"
        :page/rename-to "Rename {1}\" to:\""
        :page/priority "Priority {1}\"\""
        :page/re-index "Re-index this page"
        :page/copy-to-json "Copi the whole page as JSON"
        :page/rename "Rename page"
        :page/delete "Delete page (will delete the file too)"
        :page/publish "Publish this page on Logseq"
        :page/publish-as-slide "Publish this page as a slide on Logseq"
        :page/unpublish "Un-publish this page on Logseq"
        :page/add-to-contents "Add to Contents"
        :page/show-journals "Show Journals"
        :page/show-name "Show page name"
        :page/hide-name "Hide page name"
        :page/name "Page name"
        :page/last-modified "Last modified at"
        :page/new-title "What's your new page title?"
        :journal/multiple-files-with-different-formats "It seems that you have multiple journal files (with different formats) for the same month, please only keep one journal file for each month."
        :journal/go-to "Go to files"
        :file/name "File name"
        :file/file "File: "
        :file/last-modified-at "Last modified at"
        :file/no-data "No data"
        :file/format-not-supported "Format .{1} is not supported."
        :editor/block-search "Search for a block"
        :editor/image-uploading "Uploading"
        :draw/invalid-file "Could not load this invalid excalidraw file"
        :draw/specify-title "Please specify a title first!"
        :draw/rename-success "File was renamed successfully!"
        :draw/rename-failure "Rename file failed, reason: "
        :draw/title-placeholder "Untitled"
        :draw/save "Save"
        :draw/save-changes "Save changes"
        :draw/new-file "New file"
        :draw/list-files "List files"
        :draw/delete "Delete"
        :draw/more-options "More options"
        :draw/back-to-logseq "Back to logseq"
        :content/copy "Copy"
        :content/cut "Cut"
        :content/make-todos "Make {1}s"
        :content/copy-block-ref "Copy block ref"
        :content/focus-on-block "Focus on block"
        :content/open-in-sidebar "Open in sidebar"
        :content/copy-as-json "Copy as JSON"
        :content/click-to-edit "Click to edit"
        :settings-page/edit-config-edn "Edit config.edn (for current repo)"
        :settings-page/preferred-file-format "Preferred file format"
        :settings-page/preferred-workflow "Preferred workflow"
        :settings-page/dont-use-other-peoples-proxy-servers "Don't use other people's proxy servers. It's very dangerous, which could make your token and notes stolen. Logseq will not be responsible for this loss if you use other people's proxy servers. You can deploy it yourself, check "
        :settings-page/custom-cors-proxy-server "Custom CORS proxy server"
        :settings-page/developer-mode "Developer mode"
        :settings-page/enable-developer-mode "Enable developer mode"
        :settings-page/disable-developer-mode "Disable developer mode"
        :settings-page/developer-mode-desc "Developer mode helps contributors and extension developers test their integration with Logseq more efficient."
        :logseq "Logseq"
        :dot-mode "Dot mode"
        :on "ON"
        :more-options "More options"
        :to "to"
        :yes "Yes"
        :submit "Submit"
        :cancel "Cancel"
        :re-index "Re-index"
        :export-json "Export as JSON"
        :unlink "unlink"
        :search "Search or Create Page"
        :new-page "New page"
        :graph "Graph"
        :all-repos "All repos"
        :all-pages "All pages"
        :all-files "All files"
        :all-journals "All journals"
        :settings "Settings"
        :import "Import"
        :join-community "Join the community"
        :discord-title "Our discord group!"
        :sign-out "Sign out"
        :help-shortcut-title "Click to check shortcuts and other tips"
        :loading "Loading"
        :cloning "Cloning"
        :parsing-files "Parsing files"
        :loading-files "Loading files"
        :login-github "Login with Github"
        :excalidraw-title "Draw with Excalidraw"
        :go-to "Go to "
        :or "or"
        :download "Download"
        :language "Language"
        :white "White"
        :dark "Black"
        :remove-background "Remove background"}

   :zh-CN {:on-boarding/title "你好，欢迎使用 Logseq！"
           :on-boarding/sharing "分享"
           :on-boarding/is-a " 是一个 "
           :on-boarding/local-first "本地优先"
           :on-boarding/non-linear "非线性"
           :on-boarding/outliner "大纲"
           :on-boarding/notebook-for-organizing-and " 笔记本， 用来整理和"
           :on-boarding/your-personal-knowledge-base "你的个人知识库。"
           :on-boarding/notice "请注意， 本项目正在快速开发中， 存在文件损坏的风险。"
           :on-boarding/features-desc "使用它来组织您的待办事项列表、 写日志或记录您的独特生活。"
           :on-boarding/privacy "服务器将永远不会存储或分析您的私人笔记。 您的数据是纯文本文件，我们暂时支持 Markdown 和 Emacs Org 模式。 即使网站已经关闭或无法维护，您的数据也永远属于您。"
           :on-boarding/inspired-by " 受到这些产品启发："
           :on-boarding/where-are-my-notes-saved "我的笔记存储在哪里？"
           :on-boarding/storage "你的笔记会被存储在本地浏览器中，使用 "
           :on-boarding/how-do-i-use-it "我该如何使用它？"
           :on-boarding/use-1 "1. 在多设备间同步"
           :on-boarding/use-1-desc "目前，我们只支持通过 Github 进行同步，将很快添加更多选项 (Self-host git、WebDAV、Google Drive等)。"
           :on-boarding/use-1-video "看看这个很棒的视频，创作者 "
           :on-boarding/use-2 "2. 在本地使用 (无需登录)"
           :on-boarding/use-2-desc "暂时这个只为了测试演示，请登录来确保你的数据不会丢失！"
           :on-boarding/features "功能"
           :on-boarding/features-backlinks "[[页面]] 之间的双向链接"
           :on-boarding/features-block-embed "块嵌入"
           :on-boarding/features-page-embed "页面嵌入"
           :on-boarding/features-graph-vis "图表可视化"
           :on-boarding/features-heading-properties "块属性"
           :on-boarding/features-datalog "Datalog 自定义查询——笔记数据库使用 "
           :on-boarding/features-custom-view-component "自定义视图组件"
           :on-boarding/integration " 集成"
           :on-boarding/slide-support " 幻灯片支持"
           :on-boarding/built-in-supports "文档内置支持："
           :on-boarding/supports-code-highlights "代码高亮显示"
           :on-boarding/supports-katex-latex "Katex latex"
           :on-boarding/raw "原始 "
           :on-boarding/raw-html "原始 html"
           :on-boarding/learn-more "了解更多"
           :on-boarding/discord-desc " 社区在此处提问和分享提示"
           :on-boarding/github-desc " 欢迎所有人报告问题！"
           :on-boarding/our-blog "我们的博客："
           :on-boarding/credits-to "鸣谢"
           :on-boarding/clojure-desc " - 一种动态的、函数式、通用的编程语言"
           :on-boarding/datascript-desc " - Clojure, ClojureScript 和 JS 的不可变数据库和 Datalog 查询引擎"
           :on-boarding/angstrom-desc-1 ", 文档"
           :on-boarding/angstrom-desc-2 "解析器"
           :on-boarding/angstrom-desc-3 "建立在 Angstrom 之上。"
           :on-boarding/cuekeeper-desc " - 基于浏览器的 GTD (待办清单) 系统。"
           :on-boarding/sci-desc " - 小型 Clojure 解析器"
           :on-boarding/isomorphic-git-desc " - 用于 Node 和浏览器的纯 JavaScript Git 实现！"
           :help/about "关于 Logseq"
           :help/bug "Bug 反馈"
           :help/feature "功能建议"
           :help/changelog "更新日志"
           :help/blog "Logseq 博客"
           :help/privacy "隐私声明"
           :help/terms "服务条款"
           :help/community "Discord 社区"
           :help/shortcuts "快捷键"
           :help/shortcuts-triggers "触发"
           :help/shortcut "快捷键"
           :help/slash-autocomplete "Slash 自动提示"
           :help/block-content-autocomplete "块内容 (Src, Quote, Query 等) 自动完成"
           :help/reference-autocomplete "页面引用自动补全"
           :help/block-reference "块引用"
           :help/key-commands "关键命令"
           :help/working-with-lists " (与列表相关)"
           :help/indent-block-tab "缩进块标签"
           :help/unindent-block "取消缩进块"
           :help/move-block-up "向上移动块"
           :help/move-block-down "向下移动块"
           :help/create-new-block "创建块"
           :help/new-line-in-block "块中新建行"
           :undo "撤销"
           :redo "重做"
           :help/zoom-in "聚焦"
           :help/zoom-out "推出聚焦"
           :help/follow-link-under-cursor "跟随光标下的链接"
           :help/open-link-in-sidebar "在侧边栏打开"
           :expand "展开"
           :collapse "折叠"
           :select-block-above "选择上方的块"
           :select-block-below "选择下方的块"
           :select-all-blocks "选择所有块"
           :general "常规​​​​​"
           :help/toggle "显示/关闭帮助"
           :help/git-commit-message "提交消息"
           :help/full-text-search "全文搜索"
           :help/context-menu "右键菜单"
           :help/fold-unfold "折叠/展开方块(不在编辑模式中)"
           :help/toggle-doc-mode "切换文档模式"
           :help/toggle-theme "“在暗色/亮色主题之间切换”"
           :help/toggle-right-sidebar "启用/关闭右侧栏"
           :help/toggle-insert-new-block "切换 Enter/Alt+Enter 以插入新块"
           :help/jump-to-journals "跳转到日记"
           :formatting "格式化"
           :help/markdown-syntax "Markdown 语法"
           :help/org-mode-syntax "Org Mode 语法"
           :bold "粗体"
           :italics "斜体"
           :html-link "Html 链接"
           :highlight "高亮"
           :strikethrough "删除线"
           :code "代码"
           :right-side-bar/help "帮助"
           :right-side-bar/switch-theme "切换到 {1} 主题"
           :right-side-bar/theme "{1}主题"
           :right-side-bar/page "页面图谱"
           :right-side-bar/recent "最近"
           :right-side-bar/contents "目录"
           :right-side-bar/graph-ref "图谱："
           :right-side-bar/block-ref "块引用"
           :git/set-access-token "设定 Github 个人访问令牌"
           :git/token-is-encrypted "令牌将被加密并存储在浏览器本地存储"
           :git/token-server "服务器将永远不会存储它"
           :git/create-personal-access-token "如何创建 Github 个人访问令牌？"
           :git/push "现在 push"
           :git/local-changes-synced "所有本地更改已同步！"
           :git/pull "现在 pull"
           :git/last-pull "最后 pull 时间 "
           :git/version "版本"
           :git/import-notes "导入笔记"
           :git/import-notes-helper "你可以从 Github 的库中导入笔记"
           :git/add-another-repo "添加一个库"
           :git/re-index "重新 clone 然后重新建立索引"
           :git/message "你的 commit 信息"
           :git/commit-and-push "commit 并 push"
           :git/use-remote "使用云端版本"
           :git/keep-local "使用本地版本"
           :git/edit "编辑"
           :git/title "文件冲突"
           :git/no-diffs "没有文件冲突"
           :git/commit-message "commit 消息（可选）"
           :git/pushing "Pushing"
           :git/force-push "Commit 并强制 push"
           :git/a-force-push "强制 push"
           :git/add-repo-prompt "在你的库上安装 Logseq"
           :git/add-repo-prompt-confirm "添加并安装"
           :format/preferred-mode "请选择偏好格式"
           :format/markdown "Markdown"
           :format/org-mode "Org Mode"
           :reference/linked "已链接的引用"
           :reference/unlinked-ref "未链接的引用"
           :project/setup "在 Logseq 上发布新的项目"
           :project/location "一切发布的页面将会被放到 "
           :project/sync-settings "同步项目设置"
           :page/presentation-mode "演讲模式 (由 Reveal.js 驱动)"
           :page/delete-success "页面 {1} 删除成功！"
           :page/delete-confirmation "您确定要删除此页面吗？"
           :page/rename-to "重命名{1}\" 至：\""
           :page/priority "优先级 {1}\""
           :page/re-index "对此页面重新建立索引"
           :page/copy-to-json "将整页以 JSON 格式复制"
           :page/rename "重命名本页"
           :page/delete "删除本页（并删除文件）"
           :page/publish "将本页发布至 Logseq"
           :page/publish-as-slide "将本页作为幻灯片发布至 Logseq"
           :page/unpublish "取消将本页发布至 Logseq"
           :page/add-to-contents "将本页添加到目录"
           :page/show-journals "显示日志"
           :page/show-name "显示页面名"
           :page/hide-name "隐藏页面名"
           :page/name "页面名称："
           :page/last-modified "最后更改于"
           :page/new-title "请输入新页面的名字:"
           :journal/multiple-files-with-different-formats "你似乎在同一个月有多个日记文件(格式不同)，请每个月只保留一个日记文件。"
           :journal/go-to "前往所有文件"
           :file/name "文件名"
           :file/file "文件："
           :file/last-modified-at "最后更改于"
           :file/no-data "没有数据"
           :file/format-not-supported "格式 .{1} 目前不支持."
           :editor/block-search "搜索块"
           :editor/image-uploading "上传中"
           :draw/invalid-file "无法加载此无效的 excalidraw 文件"
           :draw/specify-title "请先指定标题!"
           :draw/rename-success "文件重命名成功!"
           :draw/rename-failure "文件重命名失败，原因是："
           :draw/title-placeholder "未命名"
           :draw/save "保存"
           :draw/save-changes "保存更改"
           :draw/new-file "新文件"
           :draw/list-files "所有文件"
           :draw/delete "删除"
           :draw/more-options "更多选项"
           :draw/back-to-logseq "返回 logseq"
           :content/copy "复制"
           :content/cut "剪切"
           :content/make-todos "格式化为 {1}"
           :content/copy-block-ref "复制块引用"
           :content/focus-on-block "聚焦在此块"
           :content/open-in-sidebar "在侧边栏打开"
           :content/copy-as-json "复制为 JSON"
           :content/click-to-edit "点击以编辑"
           :settings-page/edit-config-edn "编辑 config.edn (当前库)"
           :settings-page/preferred-file-format "首选文件格式"
           :settings-page/preferred-workflow "首选工作流"
           :settings-page/dont-use-other-peoples-proxy-servers "不要使用其他人的代理服务器。这非常危险，可能会使您的令牌和笔记被盗。 如果您使用其他人的代理服务器，Logseq 将不会对此损失负责。您可以自己部署它，请查阅 "
           :settings-page/custom-cors-proxy-server "自定义 CORS 代理服务器"
           :settings-page/developer-mode "开发者模式"
           :settings-page/enable-developer-mode "启用开发者模式"
           :settings-page/disable-developer-mode "禁用开发者模式"
           :settings-page/developer-mode-desc "开发者模式帮助贡献者和扩展开发者更有效地测试他们与 Logseq 的集成。"
           :logseq "Logseq"
           :dot-mode "点模式"
           :on "已打开"
           :more-options "更多选项"
           :to "至"
           :yes "是"
           :submit "提交"
           :cancel "取消"
           :re-index "重新建立索引"
           :export-json "以 JSON 格式导出"
           :unlink "解除绑定"
           :search "搜索或者创建新页面"
           :new-page "新页面"
           :graph "图谱"
           :all-repos "所有库"
           :all-pages "所有页面"
           :all-files "所有文件"
           :settings "设置"
           :import "导入"
           :join-community "加入社区"
           :discord-title "我们的 Discord 社群!"
           :sign-out "登出"
           :help-shortcut-title "点此查看快捷方式和更多游泳帮助"
           :loading "加载中"
           :cloning "Clone 中"
           :parsing-files "正在解析文件"
           :loading-files "正在加载文件"
           :login-github "用 Github 登录"
           :excalidraw-title "用 Excalidraw 画图"
           :go-to "转到"
           :or "或"
           :download "下载"
           :language "语言"
           :white "亮色"
           :dark "暗黑"
           :remove-background "去除背景"}

   :af {:on-boarding/title "Hi, welcome to Logseq!"
        :on-boarding/sharing "meedeling"
        :on-boarding/is-a " is 'n "
        :on-boarding/local-first "plaaslike-eerste"
        :on-boarding/non-linear "nie-lineêre"
        :on-boarding/outliner "buitelyn"
        :on-boarding/notebook-for-organizing-and " notaboek vir organisasie en "
        :on-boarding/your-personal-knowledge-base "  jou persoonlike kennis basis."
        :on-boarding/notice "Wees asseblief bewus daarvan dat die projek nog in die begin fase is, en jou leers kan korrupteer word."
        :on-boarding/features-desc "Gebruik dit om jou lyste vir aksie te organiseer, joernale te skryf, en jou unieke lewe op te neem."
        :on-boarding/privacy "The server will never store or analyze your private notes. Your data are plain text files, we support both Markdown and Emacs Org mode for the time being. Even if the website is down or can't be maintained, your data is always yours."
        :on-boarding/inspired-by " is geweldig geïnspireer deur "
        :on-boarding/where-are-my-notes-saved "Waar word my notas gestoor?"
        :on-boarding/storage "Jou notas word in the plaaslike webblaaier stoorkamer gestoor deur "
        :on-boarding/how-do-i-use-it "Hoe gebruik ek dit?"
        :on-boarding/use-1 "1. Sinkroniseer tussen onderskeie toestelle"
        :on-boarding/use-1-desc "Tans, ondersteun ons sinkronisering met Github, meer opsies (eie bediener git, WebDAV, Google Drive ensovoorts) sal binnekort bygevoeg word. "
        :on-boarding/use-1-video "Gaan loer gerus na hierdie lekker video by "
        :on-boarding/use-2 "2. Gebruik dit plaaslik (geen aantekening benodig)"
        :on-boarding/use-2-desc "Onthou om jou persoonlike notas nou en dan te rugsteun!"
        :on-boarding/features "Kenmerke"
        :on-boarding/features-backlinks "Terugskakels tussen [[Blaaie]]"
        :on-boarding/features-block-embed "Blok insluiting"
        :on-boarding/features-page-embed "Blad insluiting"
        :on-boarding/features-graph-vis "Grafiese visualisering"
        :on-boarding/features-heading-properties "Opskrif eienskappe"
        :on-boarding/features-datalog "Datalog navrae, die notas db word aangedryf deur "
        :on-boarding/features-custom-view-component "Persoonlike aansig komponent"
        :on-boarding/integration " integrasie"
        :on-boarding/slide-support " skyfie ondersteuning"
        :on-boarding/built-in-supports "Ingeboude dokument ondersteuning:"
        :on-boarding/supports-code-highlights "Kode hoogtepunte"
        :on-boarding/supports-katex-latex "Katex latex"
        :on-boarding/raw "Rou "
        :on-boarding/raw-html "Rou html"
        :on-boarding/learn-more "Kom meer te wete"
        :on-boarding/discord-desc " waar die gemeenskap vrae vra en wenke deel"
        :on-boarding/github-desc " almal word angemoedig om kwessies aan te meld!"
        :on-boarding/our-blog "Ons blog: "
        :on-boarding/credits-to "Erkennings"
        :on-boarding/clojure-desc " - 'n Dinamiese, funksionele, algemene alle gebruiks programmertaal"
        :on-boarding/datascript-desc "Onveranderlike databasis en Datalog-navraag enjin vir Clojure, ClojureScript en JS"
        :on-boarding/angstrom-desc-1 ", die dokument "
        :on-boarding/angstrom-desc-2 "ontleder"
        :on-boarding/angstrom-desc-3 " is gebou op Angstrom."
        :on-boarding/cuekeeper-desc " - Webblaaier gebaseerde GTD (TODO lys) stelsel."
        :on-boarding/sci-desc " - 'n Klein Clojure interpreteerder"
        :on-boarding/isomorphic-git-desc "- 'n Suiwer JavaScript implementasie van git vir node en webblaaiers!"
        :help/about "Oor Logseq"
        :help/bug "Fout verslag"
        :help/feature "Funksie versoek"
        :help/changelog "Verandering-dagboek"
        :help/blog "Logseq blog"
        :help/privacy "Privaatheidsbeleid"
        :help/terms "Terme"
        :help/community "Discord gemeenskap"
        :help/shortcuts "Sleutelbord kortpaaie"
        :help/shortcuts-triggers "Snellers"
        :help/shortcut "Kortpad"
        :help/slash-autocomplete "Slash outovoltooi"
        :help/block-content-autocomplete "Blokkeer inhoud (Oorsprong, kwotasie, navrae ens.) Voltooi outomaties"
        :help/reference-autocomplete "Blad verwysing Outovoltooi"
        :help/block-reference "Blok verwysing"
        :help/key-commands "Sleutel instruksies"
        :help/working-with-lists " (werk met lyste)"
        :help/indent-block-tab "Ingekeepte blok oortjie"
        :help/unindent-block "Oningekeepte blok"
        :help/move-block-up "Skuif Blok Boontoe"
        :help/move-block-down "Skuif Blok Ondertoe"
        :help/create-new-block "Skep 'n nuwe blok"
        :help/new-line-in-block "Nuwe lyn in blok"
        :undo "Ontdoen"
        :redo "Herdoen"
        :help/zoom-in "Zoem in"
        :help/zoom-out "Zoem uit"
        :help/follow-link-under-cursor "Volg die skakel onder die wyser"
        :help/open-link-in-sidebar "Maak skakel in kantlys oop"
        :expand "Brei uit"
        :collapse "Vou in"
        :select-block-above "Kies blok bo"
        :select-block-below "Kies blok onder"
        :select-all-blocks "Kies alle blokke"
        :general "Algemeen"
        :help/toggle "Wissel help"
        :help/git-commit-message "Jou git stoor boodskap"
        :help/full-text-search "Volteks soek"
        :help/context-menu "Konteks kaart"
        :help/fold-unfold "Vou/ontvou blokke (wanneer nie in wysigings modus)"
        :help/toggle-doc-mode "Wissel dokument modus"
        :help/toggle-theme "Wissel tussen donker/lig temas"
        :help/toggle-right-sidebar "Wissel regter sybalk"
        :help/toggle-insert-new-block "Wissel Enter/Alt+enter vir die byvoeging van nuwe blokke"
        :help/jump-to-journals "Spring na joernale"
        :formatting "Formatering"
        :help/markdown-syntax "Markdown sintaksis"
        :help/org-mode-syntax "Org mode sintaksis"
        :bold "Vetdruk"
        :italics "Skuinsdruk"
        :html-link "Html Skakel"
        :highlight "Beklemtoon"
        :strikethrough "Deurstreep"
        :code "Kode"
        :right-side-bar/help "Hulp"
        :right-side-bar/switch-theme "Skakel oor na die {1} tema"
        :right-side-bar/theme "{1} tema"
        :right-side-bar/page "Grafiek bladsy"
        :right-side-bar/recent "Onlangs"
        :right-side-bar/contents "Inhoud"
        :right-side-bar/graph-ref "Grafiek van "
        :right-side-bar/block-ref "Blok verwysing"
        :git/set-access-token "Set Github personal access token"
        :git/token-is-encrypted "The token will be encrypted and stored in the browser local storage"
        :git/token-server "The server will never store it"
        :git/create-personal-access-token "How to create a Github personal access token?"
        :git/push "Stoor nou"
        :git/local-changes-synced "Alle veranderinge is gesinkroniseer!"
        :git/pull "Laai af"
        :git/last-pull "Laas afgelaai op"
        :git/version "Weergawe"
        :git/import-notes "Voer jou notas in"
        :git/import-notes-helper "Jy kan jou notas van 'n Github stoorplek laai."
        :git/add-another-repo "Voeg nog 'n stoorplek by"
        :git/re-index "Clone again and re-index the db"
        :git/message "Jou stoor boodskap"
        :git/commit-and-push "Stoor en sinkroniseer!"
        :git/use-remote "Gebruik afgeleë stoor"
        :git/keep-local "Hou plaaslik"
        :git/edit "Wysig"
        :git/title "Vergelyk"
        :git/no-diffs "Geen verskille"
        :git/commit-message "Veranderings nota (opsioneel)"
        :git/pushing "Stoor"
        :git/force-push "Stoor en laai op"
        :git/a-force-push "'n Gevorseerde stoor"
        :git/add-repo-prompt "Installeer Logseq op jou stoorplek"
        :git/add-repo-prompt-confirm "Voeg by en installeer"
        :format/preferred-mode "Wat is jou voorkeur model?"
        :format/markdown "Markdown"
        :format/org-mode "Org Mode"
        :reference/linked "Gekoppelde Verwysing"
        :reference/unlinked-ref "Ongekoppelde Verwysing"
        :project/setup "Stel 'n publieke projek op by Logseq"
        :project/location "Alle gepubliseerde blaai sal voorkom onder"
        :project/sync-settings "Sinkroniseer projek instellings"
        :page/presentation-mode "Aanbiedings modus (gedryf deur Reveal.js)"
        :page/delete-success "Bladsy {1} is suksesvol uitgevee!"
        :page/delete-confirmation "Is jy seker jy wil die bladsy uitvee?"
        :page/rename-to "Hernoem {1} na: \"\""
        :page/priority "Prioriteit {1}\""
        :page/re-index "Re-index this page"
        :page/copy-to-json "Kopieer die hele bladsy as JSON"
        :page/rename "Hernoem die bladsy"
        :page/delete "Delete page (will delete the file too)"
        :page/publish "Publiseer hierdie blad op Logseq"
        :page/publish-as-slide "Publiseer hierdie blad as 'n skyfie op Logseq"
        :page/unpublish "Verwyder blad publikasie op Logseq"
        :page/add-to-contents "Voeg by inhoud"
        :page/show-journals "Wys joernale"
        :page/show-name "Wys blad naam"
        :page/hide-name "Steek bladnaam weg"
        :page/name "Page name"
        :page/last-modified "Laaste verander op"
        :page/new-title "Wat is die nuwe blad se titel?"
        :journal/multiple-files-with-different-formats "Dit wil voorkom asof jy verskeie journaal (met verskeie formate) vir dieselfde maand het, onderhou asb need een journaal lêer vir elke maand."
        :journal/go-to "Go to files"
        :file/name "Lêer naam"
        :file/file "Lêer: "
        :file/last-modified-at "Laas verander op"
        :file/no-data "Geen data"
        :file/format-not-supported "Formaat .{1} word nie ondersteun nie."
        :editor/block-search "Soek vir 'n blok"
        :editor/image-uploading "Laai tans op"
        :draw/invalid-file "Kon nie die ongeldige excalidraw lêer laai nie"
        :draw/specify-title "Spesifiseer asseblief eers a titel!"
        :draw/rename-success "Lêer is suksesvol verwyder!"
        :draw/rename-failure "Die lêer kon nie hernoem word nie, rede: "
        :draw/title-placeholder "Naamloos"
        :draw/save "Stoor"
        :draw/save-changes "Bewaar veranderinge"
        :draw/new-file "Nuwe lêer"
        :draw/list-files "Lys lêers"
        :draw/delete "Vee uit"
        :draw/more-options "Meer opsies"
        :draw/back-to-logseq "Terug na logseq"
        :content/copy "Kopieer"
        :content/cut "Sny"
        :content/make-todos "Maak {1}"
        :content/copy-block-ref "Kopieer blok verwysing"
        :content/focus-on-block "Fokus op blok"
        :content/open-in-sidebar "Maak in kantlys oop"
        :content/copy-as-json "Kopieer na JSON"
        :content/click-to-edit "Kliek om te wysig"
        :settings-page/edit-config-edn "Wysig config.edn (vir huidige stoor)"
        :settings-page/preferred-file-format "Voorkeur lêer formaat"
        :settings-page/preferred-workflow "Voorkeur werkstroom"
        :settings-page/dont-use-other-peoples-proxy-servers "Moenie ander mense se instaanbedieners gebruik nie. Dis gevaarlik, en kan veroorsaak dat jou toegang teken en notas gesteel word. Logseq sal nie verantwoording neem vir verlies indien jy ander se instaanbedieners gebruik nie. Jy kan self self een ontplooi "
        :settings-page/custom-cors-proxy-server "Persoonlike CORS instaanbediener"
        :settings-page/developer-mode "Ontwikkelaar modus"
        :settings-page/enable-developer-mode "Skakel ontwikkelaar modus aan"
        :settings-page/disable-developer-mode "Skakel ontwikkelaars modus af"
        :settings-page/developer-mode-desc "Ontwikkelaarmodus help bydraers en ontwikkelaars van uitbreidings om hul integrasie met Logseq doeltreffender te toets."
        :logseq "Logseq"
        :dot-mode "Punt modus"
        :on "AAN"
        :more-options "More options"
        :to "na"
        :yes "Ja"
        :submit "Stuur"
        :cancel "Kanselleer"
        :re-index "Herindekseer"
        :export-json "Uitvoer as JSON"
        :unlink "ontkoppel"
        :search "Soek"
        :new-page "Nuwe bladsy"
        :graph "Grafiek"
        :all-repos "Alle stoorplekke"
        :all-pages "Alle blaaie"
        :all-files "Alle lêers"
        :settings "Verstellings"
        :import "Invoer"
        :join-community "Sluit by die gemeenskap aan"
        :discord-title "Ons discord groep!"
        :sign-out "Teken af"
        :help-shortcut-title "Kliek op die kortpad en ander wenke"
        :loading "Laai tans"
        :cloning "Kloning"
        :parsing-files "Lêer ontleding"
        :loading-files "Laai lêers"
        :login-github "Aantekening deur Github"
        :excalidraw-title "Teken met Excalidraw"
        :go-to "Gaan na "
        :or "of"
        :download "Laai af"
        :language "Taal"
        :white "Wit"
        :dark "Swart"}

   :tongue/fallback :en})

(def languages [{:label "English" :value :en}
                {:label "简体中文" :value :zh-CN}
                {:label "Afrikaans" :value :af}])

(def translate
  (tongue/build-translate dicts))

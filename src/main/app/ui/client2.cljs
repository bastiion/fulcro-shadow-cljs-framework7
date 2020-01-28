(ns app.ui.client2
  (:require
    [taoensso.timbre :as log]
    [com.fulcrologic.framework7.factory-helpers :as h]
    ["framework7/js/framework7" :as Framework7]
    ["framework7-react/framework7-react.bundle" :as Framework7React]
    [com.fulcrologic.framework7.components :refer
     [f7-app f7-panel f7-view f7-page f7-navbar f7-nav-left f7-nav-right f7-link f7-button f7-block f7-block-title f7-list f7-list-item f7-row f7-toolbar]]
    [com.fulcrologic.fulcro.application :as app]
    [com.fulcrologic.fulcro.components :as comp :refer [defsc]]
    [com.fulcrologic.fulcro.dom :as dom]))

(defonce app (app/fulcro-app))


(defn f7-init []
  (prn "before init")
  (.use Framework7 Framework7React)
  (prn "after init")
  )


(defsc Root [this props]
  (f7-app
     {:params {
                 :id         "io.github.fulcro-f7"
                 :name       "workspaces"
                 :theme      "auto"
                 :router     false
                 :pushState  true
                 :ajaxLinks  "a.ajax"
                 :fastClicks false
                 }}
     (f7-panel
       {:left true :cover true}
       (f7-view
         nil
         (f7-page
           nil
           (f7-navbar
             {:title "left Panel"}
             (f7-block
               nil
               "Left Panel content"
               )
             ))
         )
       )
     (f7-view
       {:className "safe-areas" :main true :url "/"}
      (f7-page
        nil
        (f7-toolbar
          nil
          (f7-link nil "Left link")
          (f7-link nil "right link"))
        (f7-block-title nil "Navigation")
        (f7-list
          nil
          (f7-list-item
            {:link "/about/", :title "About"})
          (f7-list-item
            {:link "/form/", :title "Form"}))
        (f7-block-title nil "Modals")
        (f7-block
          {:strong true}
          (f7-row
            nil
            (f7-button
              {:fill true :raised true :popupopen "#my-popup"}
              "Popup")
            (f7-button
              {:fill true :raised true :popupopen "#my-popup"}
              "Blubb")
            (f7-button
              {:fill true :raised true :loginscreenopen "#my-login-screen"}
              "Login Screen")))
        ))

    (dom/h1 "Yeaaaaa")
    ))

(defn ^:export init
  "Shadow-cljs sets this up to be our entry-point function. See shadow-cljs.edn `:init-fn` in the modules of the main build."
  []
  (f7-init)
  #_(prn (.getOwnPropertyNames js/Object js/window.f7.components))
  (app/mount! app Root "app2")
  (js/console.log "Loaded"))


(defn ^:export refresh
  "During development, shadow-cljs will call this on every hot reload of source. See shadow-cljs.edn"
  []
  ;; re-mounting will cause forced UI refresh, update internals, etc.
  (app/mount! app Root "app2")
  (js/console.log "Hot reload"))

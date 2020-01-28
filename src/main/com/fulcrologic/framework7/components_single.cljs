(ns com.fulcrologic.framework7.components-single
  (:require
    [com.fulcrologic.framework7.factory-helpers :as h]
    ["framework7-react/framework7-react.bundle" :refer [App]]
    ))


(def f7-app (h/factory-apply App))

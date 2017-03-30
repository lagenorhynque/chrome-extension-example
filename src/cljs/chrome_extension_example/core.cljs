(ns chrome-extension-example.core
  (:require [jayq.core :refer [$ ajax]]))

(defn handler []
  (.getSelected (.-tabs js/chrome)
                nil
                (fn [tab]
                  (.text ($ "#title")
                         (.-title tab))
                  (.text ($ "#url")
                         (.-url tab))))
  ;; FIXME
  (ajax "https://lgtm.in/g"
        {:dataType "json"
         :success (fn [data]
                    (.text ($ "#markdown")
                           (.-markdown data)))}))

(let [b ($ "#button")]
  (.on b "click" handler))

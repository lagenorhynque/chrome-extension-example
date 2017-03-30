(ns chrome-extension-example.core
  (:require [jayq.core :refer [$ html]]))

(defn handler []
  (.getSelected (.-tabs js/chrome) nil (fn [tab]
                                         (.text ($ "#title")
                                                (.-title tab))
                                         (.text ($ "#url")
                                                (.-url tab)))))

(let [b ($ "#button")]
  (.on b "click" handler))

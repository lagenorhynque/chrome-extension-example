(ns chrome-extension-example.core)
  ; (:require [jayq.core :refer [$ html]]))

(defn handler []
  (.getSelected (.-tabs js/chrome) nil (fn [tab]
                                         (set! (.-innerHTML (.getElementById js/document "title"))
                                               (.-title tab))
                                         (set! (.-innerHTML (.getElementById js/document "url"))
                                               (.-url tab)))))

(let [b (.getElementById js/document "button")]
  (.addEventListener b "click" handler false))

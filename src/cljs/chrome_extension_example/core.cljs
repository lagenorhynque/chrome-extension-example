(ns chrome-extension-example.core)

(defn ^:export hello []
  (js/alert "Hello, world!"))

(set! (.-onload js/window) hello)

(defproject chrome-extension-example "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.494"]]
  :plugins [[lein-cljsbuild "1.1.5"]
            [lein-resource "16.9.1"]]
  :resource {:resource-paths ["resources"]
             :target-path "target/chrome-extension-example"
             :skip-stencil [ #"resources/img/.*"]}

  :cljsbuild {:builds
              {:main {:source-paths ["src/cljs"]
                      :compiler
                      {:main chrome-extension-example.core
                       :output-to "target/chrome-extension-example/js/main.js"
                       :optimizations :advanced}}}})

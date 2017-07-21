(defproject mahjong "0.1.0-SNAPSHOT"
  :description "Riichi Mahjong simulator"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot mahjong.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

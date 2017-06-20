(ns mahjong.core
  (:gen-class))

(defn honor?
  "Is the given tile an honor?"
  [tile]
  (not (contains? tile :suit)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(ns mahjong.core
  (:gen-class))

(defn honor?
  "Is the given tile an honor?"
  [tile]
  (not (contains? tile :suit)))

(defn suit?
  "Is the given tile a suit tile?"
  [tile]
  (not (honor? tile)))

(defn terminal?
  [tile]
  (and (suit? tile) (or (= (:number tile) 1) (= (:number tile) 9))))

(defn pons
  [hand]
  [])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(ns riichi.wall
  (:require [riichi.tile :as tile]))

(defn generate-tileset
  []
  (shuffle tile/complete-set))

(defn pick
  [v keys]
  (vals (select-keys v keys)))

(defn create-wall
  []
  (let [wall (vec (generate-tileset))
        dead-start (- 136 14)]
    {:wall           (seq (subvec wall 0 dead-start))
     :dora           (subvec wall dead-start (+ dead-start 5))
     :ura-dora       (subvec wall (+ dead-start 5) (+ dead-start 10))
     :kan-bonus-tile (seq (subvec wall (+ dead-start 10) (+ dead-start 14)))}))
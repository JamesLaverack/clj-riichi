(ns riichi.wall
  (:require [riichi.tile :as tile]))

(defn generate-tileset
  []
  (shuffle tile/complete-set))

(defn create-wall
  []
  (let [wall (vec (generate-tileset))
        dead-start (- 136 14)]
    {:wall           (subvec wall 0 dead-start)
     :dora           (subvec wall dead-start (+ dead-start 5))
     :ura-dora       (subvec wall (+ dead-start 5) (+ dead-start 10))
     :kan-bonus-tile (subvec wall (+ dead-start 10) (+ dead-start 14))}))
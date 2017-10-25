(ns riichi.game
  (:require [riichi.hand :as hand]))

(defn current-player
  [game]
  (nth (first (filter #(= 14 (hand/effective-size (:hand (nth % 1)))) (seq (:players game)))) 0))
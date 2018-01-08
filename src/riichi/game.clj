(ns riichi.game
  (:require [riichi.hand :as hand])
  (:require [riichi.wall :as wall]))

(defn current-player
  [game]
  (nth (first (filter #(= 14 (hand/effective-size (:hand (nth % 1)))) (seq (:players game)))) 0))

(defn deal
  [game player]
  (let
    [f (assoc-in game [:players player :hand :hidden] (conj (:hidden (:hand (get (:players game) player))) (peek (:wall game))))]
    (assoc-in f [:wall] (pop (:wall f)))))
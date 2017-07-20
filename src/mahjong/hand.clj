(ns mahjong.hand
  (:require [mahjong.meld]))

(defn valid?
  [hand]
  (and
    (= 14 (count hand))
    (mahjong.meld/pair? (nth (mahjong.meld/pons hand) 1))))

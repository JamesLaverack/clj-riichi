(ns mahjong.hand
  (:require [mahjong.meld]))

(defn unmatched-tiles
  [grouped-hand]
  (nth grouped-hand 1))

(defn valid?
  [hand]
  (and
    (= 14 (count hand))
    (mahjong.meld/pair? (unmatched-tiles (mahjong.meld/chis (unmatched-tiles (mahjong.meld/pons hand)))))))

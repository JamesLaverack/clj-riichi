(ns mahjong.hand
  (:require [mahjong.meld]))

(defn unmatched-tiles
  [grouped-hand]
  (nth grouped-hand 1))

(defn seven-sisters?
  [hand]
  (let [freqs (frequencies hand)]
    (and
     (= 7 (count (keys freqs)))
     (every? #{2} (vals freqs)))))

(defn standard-hand?
  [hand]
  (and
   (= 14 (count hand))
   (mahjong.meld/pair? (unmatched-tiles (mahjong.meld/chis (unmatched-tiles (mahjong.meld/pons hand)))))))

(defn valid?
  [hand]
  (or
   (standard-hand? hand)
   (seven-sisters? hand)))

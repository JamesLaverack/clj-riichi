(ns mahjong.hand
  (:require [mahjong.tile]))

(defn pair?
  [hand]
  (and
    (= 2 (count hand))
    (= (nth hand 0) (nth hand 1))))

(defn pons
  "Detect pons (melds of three like tiles) in a hand. This returns a vector of vectors of the pons, plus a vector of
  everything it couldn't match."
  ([hand]
   (pons (first hand) (rest hand) [] []))
  ([tile hand found-melds unmatched-tiles]
    ; This is awful debugging
    ;(println "~~~")
    ;(println (str tile))
    ;(println (str hand))
    ;(println (str found-melds))
    ;(println (str unmatched-tiles))
   (if (empty? tile)
     (list found-melds unmatched-tiles)
     (if (= (get (frequencies unmatched-tiles) tile) 2)
       ; Found a pon, remove the matching tiles from the unmatched tiles, and add the pon set to the found melds
       (pons (first hand) (rest hand) (conj found-melds (vec (repeat 3 tile))) (vec (remove #(= tile %) unmatched-tiles)))
       ; Didn't find a pon, add this tile to the unmatched tiles
       (pons (first hand) (rest hand) found-melds (conj unmatched-tiles tile))
       )
     )
    )
  )

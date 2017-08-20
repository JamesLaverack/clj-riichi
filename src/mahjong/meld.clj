(ns mahjong.meld
  (:require [mahjong.tile]))

(defn pair?
  "Is this hand now just a single pair. We do it as a boolean '?' method rather than pair extraction because, for
  example, three pairs does not make a valid hand."
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
       (recur (first hand) (rest hand) (conj found-melds (vec (repeat 3 tile))) (vec (remove #(= tile %) unmatched-tiles)))
       ; Didn't find a pon, add this tile to the unmatched tiles
       (recur (first hand) (rest hand) found-melds (conj unmatched-tiles tile))))))


(defn find-run
  [tile hand]
  (if
    (and (mahjong.tile/suit? tile)
         (> 8 (:number tile))
         (some #{(mahjong.tile/next-tile tile)} hand)
         (some #{(mahjong.tile/next-tile (mahjong.tile/next-tile tile))} hand))
    (list tile
          (mahjong.tile/next-tile tile)
          (mahjong.tile/next-tile (mahjong.tile/next-tile tile)))
    []))

(defn find-runs
  [tiles]
  (loop [tile (first tiles) tiles (rest tiles) pons []]
    (if (<= 3 (count tiles))
      (recur (first tiles) (rest tiles) (conj pons (vec (find-run tile tiles))))
      pons)
    ))

(defn chis
  "Detect chis (melds of three tiles in sequence) in a hand. This returns a vector of vectors of the chis, plus a vector
  of everything it couldn't match."
  [hand]
  (let [pons (reduce concat (map find-runs (map #(sort-by :number %) (vec (vals (group-by :suit (filter mahjong.tile/suit? hand)))))))]
    (println "~~~~~~~~~~~~~~")
    (println (str (vec pons)))
    (println (str (vec hand)))
    (println "~~~~~~~~~~~~~~")
    (list (vec pons) hand)
    ))
;
;(defn remove-all
;  [removals sequence]
;
;  )
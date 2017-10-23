(ns mahjong.meld
  (:require [mahjong.tile :as tile]))

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
   (if (empty? tile)
     {:melds found-melds :unmatched unmatched-tiles}
     (if (= (get (frequencies unmatched-tiles) tile) 2)
       ; Found a pon, remove the matching tiles from the unmatched tiles, and add the pon set to the found melds
       (recur (first hand) (rest hand) (conj found-melds (vec (repeat 3 tile))) (vec (remove #(= tile %) unmatched-tiles)))
       ; Didn't find a pon, add this tile to the unmatched tiles
       (recur (first hand) (rest hand) found-melds (conj unmatched-tiles tile))))))

(defn remove-first
  [to-remove collection]
  (loop
    [prev []
     element (first collection)
     remaining (rest collection)]
    (if (nil? element)
      ;; Failure to find, just return 'prev' which is the seq as we found it
      prev
      ;; Inspect element, yes we use equality here and not a predicate
      (if (= element to-remove)
        ;; This removal is 'burnt', just return
        (concat prev remaining)
        ;; Keep searching
        (recur (conj prev element) (first remaining) (rest remaining))))))

(defn remove-all
  [removals collection]
  (loop
    [to-remove (first removals)
     remaining-removals (rest removals)
     collection collection]
    (if (nil? to-remove)
      collection
      (recur (first remaining-removals) (rest remaining-removals) (remove-first to-remove collection)))))

(defn find-run
  [tile hand]
  (if
    (and (tile/suit? tile)
         (> 8 (:number tile))
         (some #{(tile/next-tile tile)} hand)
         (some #{(tile/next-tile (tile/next-tile tile))} hand))
    (list tile
          (tile/next-tile tile)
          (tile/next-tile (tile/next-tile tile)))
    nil))

(defn chis
  ([hand]
   (chis hand 0 []))
  ([hand idx chis]
   (if (>= idx (count hand))
     ;; We've run out of tiles - return the chis we've found
     {:melds chis :unmatched hand}
     ;; continue with another tile
     (let [tile (nth hand idx)
           run (find-run tile hand)]
       (if (nil? run)
         ;; Failed to find anything
         (recur hand (+ 1 idx) chis)
         ;; Found a new chi, start from the beginning of the new seq
         (recur (remove-all run hand) 0 (conj chis run)))))))

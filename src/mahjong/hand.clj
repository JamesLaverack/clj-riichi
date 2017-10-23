(ns mahjong.hand
  (:require [mahjong.meld :as meld])
  (:require [mahjong.tile :as tile]))

(defn seven-sisters?
  [hand]
  (let [freqs (frequencies hand)]
    (and
      (= 7 (count (keys freqs)))
      (every? #{2} (vals freqs)))))

(defn contains-pair?
  "Does the given hand contain at least one pair?"
  [hand]
  (some #(= 2 %) (vals (frequencies hand))))

(defn contains-all?
  [to-search to-find]
  (let [search-freq (frequencies to-search)
        find-freq (frequencies to-find)]
    (loop [pivot (first (keys find-freq))
           remainder (rest (keys find-freq))]
      (if (nil? pivot)
        ;; Checked everything, success
        true
        ;; Check the pivot key
        (if (<=
              (get find-freq pivot 0)
              (get search-freq pivot 0))
          ;; Found enough of this key, continue to search
          (recur (first remainder) (rest remainder))
          ;; Didn't find enough of this key, fail out
          false)))))

(defn thirteen-orphans?
  [hand]
  (and
    (= 14 (count hand))
    (contains-all? hand tile/honors)
    (contains-all? hand tile/terminals)
    (contains-pair? hand)))

(defn standard-hand?
  [hand]
  (and
    (= 14 (count hand))
    (meld/pair? (:unmatched (meld/chis (:unmatched (meld/pons (:hidden hand))))))))

(defn valid?
  [hand]
  (or
    (standard-hand? hand)
    (seven-sisters? (:hidden hand))
    (thirteen-orphans? (:hidden hand))))
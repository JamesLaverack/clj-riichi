(ns riichi.wall-test
  (:require [clojure.test :refer :all])
  (:require [riichi.wall :refer [create-wall]]
            [riichi.tile :as tile]))

(deftest create-wall-test
  (let [wall (create-wall)]
    (testing "The wall is 122 tiles long"
      (is (= (- 136 14) (count (:wall wall)))))
    (testing "There are five dora"
      (is (= 5 (count (:dora wall)))))
    (testing "There are five ura-dora"
      (is (= 5 (count (:ura-dora wall)))))
    (testing "There are four kan bonus tiles"
      (is (= 4 (count (:kan-bonus-tile wall)))))
    (let [combined-wall (reduce concat (vals wall))]
      (testing "There are 136 tiles in total"
        (is (= 136 (count combined-wall))))
      (let [freqs (frequencies combined-wall)]
        (testing "All tile types are present"
          (is (= (count tile/all) (count (keys freqs)))))
        (testing "There are four of each tile"
          (is (every? #(= % 4) (vals freqs))))))))

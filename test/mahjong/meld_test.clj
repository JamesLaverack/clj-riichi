(ns mahjong.meld-test
  (:require [clojure.test :refer :all])
  (:require [mahjong.tile :refer :all])
  (:require [mahjong.meld :refer :all]))

(deftest pon-test
  (testing "That a pon is detected"
    (let [pon-hand [🀃 🀀 🀀 🀂 🀂 🀂 🀋 🀋 🀋 🀄 🀆 🀐 🀑 🀒]]
      (is (= (pons pon-hand) [[[🀂 🀂 🀂] [🀋 🀋 🀋]] [🀃 🀀 🀀 🀄 🀆 🀐 🀑 🀒]])))))

(deftest pair-test
  (testing "That a pair is detected"
    (let [pair-hand [🀄 🀄]]
      (is (pair? pair-hand)))
    (let [pair-hand [🀄 🀜]]
      (is (not (pair? pair-hand))))))
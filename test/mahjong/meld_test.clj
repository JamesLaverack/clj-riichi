(ns mahjong.meld-test
  (:require [clojure.test :refer :all])
  (:require [mahjong.tile :refer :all])
  (:require [mahjong.meld :refer :all]))

(deftest pon-test
  (testing "That a pon is detected"
    (let [pon-hand [🀃 🀀 🀀 🀂 🀂 🀂 🀋 🀋 🀋 🀄 🀆 🀐 🀑 🀒]]
      (is (= (pons pon-hand) {:melds     [[🀂 🀂 🀂] [🀋 🀋 🀋]]
                              :unmatched [🀃 🀀 🀀 🀄 🀆 🀐 🀑 🀒]})))))

(deftest chi-test
  (testing "That a chi is detected"
    (let [chi-hand [🀃 🀀 🀑 🀂 🀂 🀂 🀊 🀋 🀌 🀍 🀠 🀑 🀐 🀒]]
      (is (= (chis chi-hand) {:melds     [[🀊 🀋 🀌] [🀐 🀑 🀒]]
                              :unmatched [🀃 🀀 🀂 🀂 🀂 🀍 🀠 🀑]}))))
  (testing "That a chi is detected by itself"
    (let [chi-hand [🀐 🀑 🀒]]
      (is (= (chis chi-hand) {:melds     [[🀐 🀑 🀒]]
                              :unmatched []}))))
  (testing "That winds cannot form a chi"
    (let [chi-hand [🀀 🀁 🀂]]
      (is (= (chis chi-hand) {:melds     []
                              :unmatched [🀀 🀁 🀂]}))))
  (testing "That dragons cannot form a chi"
    (let [chi-hand [🀄 🀅 🀆]]
      (is (= (chis chi-hand) {:melds     []
                              :unmatched [🀄 🀅 🀆]}))))
  (testing "That chis cannot 'wrap' around"
    (let [chi-hand [🀏 🀇 🀈]]
      (is (= (chis chi-hand) {:melds     []
                              :unmatched [🀏 🀇 🀈]}))))
  (testing "That a chi is detected with a duplicated first tile"
    (let [chi-hand [🀐 🀐 🀐 🀑 🀒]]
      (is (= (chis chi-hand) {:melds     [[🀐 🀑 🀒]]
                              :unmatched [🀐 🀐]}))))
  (testing "That a triple duplicated chi is detected"
    (let [chi-hand [🀊 🀋 🀌 🀊 🀋 🀌 🀊 🀋 🀌]]
      (is (= (chis chi-hand) {:melds     [[🀊 🀋 🀌] [🀊 🀋 🀌] [🀊 🀋 🀌]]
                              :unmatched []}))))
  (testing "That a chi is detected with duplicates of the middle tile"
    (let [chi-hand [🀉 🀊 🀊 🀋]]
      (is (= (chis chi-hand) {:melds     [[🀉 🀊 🀋]]
                              :unmatched [🀊]})))))

(deftest pair-test
  (testing "That a pair is detected"
    (let [pair-hand [🀄 🀄]]
      (is (pair? pair-hand)))
    (let [pair-hand [🀄 🀜]]
      (is (not (pair? pair-hand))))))

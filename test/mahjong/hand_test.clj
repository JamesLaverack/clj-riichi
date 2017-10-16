(ns mahjong.hand-test
  (:require [clojure.test :refer :all])
  (:require [mahjong.tile :refer :all])
  (:require [mahjong.hand :refer :all]))

(deftest valid-test
  (testing "That an invalid hand is detected"
    (let [hand [red-dragon red-dragon four-of-coins three-of-bamboo west-wind east-wind green-dragon one-of-bamboo seven-of-characters eight-of-characters eight-of-characters three-of-characters four-of-characters five-of-characters]]
      (is (not (valid? hand)))))
  (testing "Boring hand"
    ;; This hand doesn't actually have any Yaku by itself. But it's still valid
    (let [hand [🀅 🀅 🀉 🀊 🀋 🀖 🀖 🀖 🀂 🀂 🀂 🀙 🀚 🀛]]
      (is (valid? hand))))
  (testing "Seven Sisters"
    ;; This is a 'non-standard' hand that doesn't confirm to the usual 'four melds and a pair' rule
    (let [hand [🀅 🀅 🀙 🀙 🀜 🀜 🀗 🀗 🀊 🀊 🀆 🀆 🀌 🀌]]
      (is (valid? hand))))
  (testing "Thirteen Oprhans"
    ;; This is a 'non-standard' hand that doesn't confirm to the usual 'four melds and a pair' rule
    (let [hand [🀀 🀁 🀂 🀃 🀄 🀅 🀆 🀇 🀏 🀐 🀘 🀙 🀡 🀡]]
      (is (valid? hand))))
  (testing "toitoi (four pons and a pair)"
    (let [hand [red-dragon red-dragon red-dragon three-of-characters three-of-characters three-of-characters seven-of-bamboo seven-of-bamboo seven-of-bamboo west-wind west-wind west-wind two-of-bamboo two-of-bamboo]]
      (is (valid? hand)))))

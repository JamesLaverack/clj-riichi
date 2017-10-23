(ns mahjong.hand-test
  (:require [clojure.test :refer :all])
  (:require [mahjong.tile :refer :all])
  (:require [mahjong.hand :refer :all]))

(deftest fully-closed
  (testing "That an invalid hand is detected"
    (let [hand {:hidden [🀄 🀄 🀜 🀒 🀂 🀀 🀅 🀐 🀍 🀎 🀎 🀉 🀊 🀋]}]
      (is (not (valid? hand)))))
  (testing "Boring hand"
    ;; This hand doesn't actually have any Yaku by itself. But it's still valid
    (let [hand {:hidden [🀅 🀅 🀉 🀊 🀋 🀖 🀖 🀖 🀂 🀂 🀂 🀙 🀚 🀛]}]
      (is (valid? hand))))
  (testing "Seven Sisters"
    ;; This is a 'non-standard' hand that doesn't confirm to the usual 'four melds and a pair' rule
    (let [hand {:hidden [🀅 🀅 🀙 🀙 🀜 🀜 🀗 🀗 🀊 🀊 🀆 🀆 🀌 🀌]}]
      (is (valid? hand))))
  (testing "Thirteen Orphans"
    ;; This is a 'non-standard' hand that doesn't confirm to the usual 'four melds and a pair' rule
    (let [hand {:hidden [🀀 🀁 🀂 🀃 🀄 🀅 🀆 🀇 🀏 🀐 🀘 🀙 🀡 🀡]}]
      (is (valid? hand))))
  (testing "toitoi (four pons and a pair)"
    (let [hand {:hidden [🀄 🀄 🀄 🀉 🀉 🀉 🀖 🀖 🀖 🀂 🀂 🀂 🀑 🀑]}]
      (is (valid? hand)))))

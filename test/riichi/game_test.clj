(ns riichi.game-test
  (:require [clojure.test :refer :all])
  (:require [riichi.tile :refer :all])
  (:require [riichi.game :refer [current-player deal]]))

(deftest current-player-test
  (testing "Hand with a declared pon"
    ;; This hand doesn't actually have any Yaku by itself. But it's still valid
    (let [game {:players {:east  {:hand {:declared [{:taken 🀖 :from :west :provided [🀖 🀖]}]
                                         :hidden   [🀅 🀅 🀉 🀊 🀅 🀋 🀂 🀙 🀚 🀛]}}
                          :south {:hand {:hidden [🀆 🀆 🀉 🀊 🀋 🀂 🀙 🀚 🀛 🀈 🀔 🀊 🀐 🀌]}}
                          :west  {:hand {:hidden [🀓 🀓 🀉 🀊 🀋 🀂 🀙 🀚 🀛 🀈 🀔 🀊 🀐]}}
                          :north {:hand {:hidden [🀓 🀓 🀉 🀊 🀋 🀂 🀚 🀛 🀈 🀔 🀊 🀐 🀌]}}}}]
      (is (= (current-player game) :south))))
  )

(deftest deal-test
  (testing "the next tile is dealt"
    (let [game {:wall    [🀆 🀙 🀉]
                :players {:east  {:hand {:declared [{:taken 🀖 :from :west :provided [🀖 🀖]}]
                                         :hidden   [🀅]}}
                          :south {:hand {:hidden [🀉]} :pond []}
                          :west  {:hand {:hidden [🀓]}}
                          :north {:hand {:hidden [🀂]}}}}]
      (let [next-game (deal game :west)]
        (is (= [🀆 🀙] (:wall next-game)))
        (is (= [🀓 🀉] (:hidden (:hand (:west (:players next-game))))))))))

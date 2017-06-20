(ns mahjong.core-test
  (:require [clojure.test :refer :all]
            [mahjong.core :refer :all]))

(def seven-of-bamboo #{:suit :bamboo :number 7})
(def green-dragon #{:dragon :green})
(def north-wind #{:wind :north})


(deftest a-test
  (testing "That 7 Bamboo is not an honor"
    (is (not (honor? seven-of-bamboo))))
  (testing "That the Green Dragon is an honor"
    (is (honor? green-dragon)))
  (testing "That the North Wind is an honor"
    (is (honor? north-wind)))
  )

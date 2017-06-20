(ns mahjong.core-test
  (:require [clojure.test :refer :all]
            [mahjong.core :refer :all]))

(def seven-of-bamboo {:suit :bamboo :number 7})
(def nine-of-characters {:suit :characters :number 9})
(def one-of-coins {:suit :coins :number 1})
(def green-dragon {:dragon :green})
(def north-wind {:wind :north})


(deftest honor-test
  (testing "That 7 Bamboo is not an honor"
    (is (not (honor? seven-of-bamboo))))
  (testing "That the Green Dragon is an honor"
    (is (honor? green-dragon)))
  (testing "That the North Wind is an honor"
    (is (honor? north-wind)))
  )

(deftest terminal-test
  (testing "That 7 Bamboo is not a terminal"
    (is (not (terminal? seven-of-bamboo))))
  (testing "That the Green Dragon is not a terminal"
    (is (not (terminal? green-dragon))))
  (testing "That the North Wind is not a terminal"
    (is (not (terminal? north-wind))))
  (testing "That 9 Characters is a terminal"
    (is (terminal? nine-of-characters)))
  (testing "That 1 Coins is a terminal"
    (is (terminal? one-of-coins)))
  )

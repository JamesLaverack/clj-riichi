(ns mahjong.core-test
  (:require [clojure.test :refer :all]
            [mahjong.core :refer :all]))


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

;(deftest pon-test
;  (testing "That a pon is detected"
;    (let [pon-hand [north-wind east-wind east-wind west-wind west-wind west-wind five-of-characters five-of-characters five-of-characters red-dragon white-dragon one-of-bamboo two-of-bamboo three-of-bamboo]]
;      (is (= (pons pon-hand) [[[west-wind west-wind west-wind] [five-of-characters five-of-characters five-of-characters]] [north-wind east-wind east-wind red-dragon white-dragon one-of-bamboo two-of-bamboo three-of-bamboo]])))))

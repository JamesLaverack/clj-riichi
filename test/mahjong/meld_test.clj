(ns mahjong.meld-test
  (:require [clojure.test :refer :all])
  (:require [mahjong.tile :refer :all])
  (:require [mahjong.meld :refer :all]))

(deftest pon-test
  (testing "That a pon is detected"
    (let [pon-hand [north-wind east-wind east-wind west-wind west-wind west-wind five-of-characters five-of-characters five-of-characters red-dragon white-dragon one-of-bamboo two-of-bamboo three-of-bamboo]]
      (is (= (pons pon-hand) [[[west-wind west-wind west-wind] [five-of-characters five-of-characters five-of-characters]] [north-wind east-wind east-wind red-dragon white-dragon one-of-bamboo two-of-bamboo three-of-bamboo]])))))

(deftest pair-test
  (testing "That a pair is detected"
    (let [pair-hand [red-dragon red-dragon]]
      (is (pair? pair-hand)))
    (let [pair-hand [red-dragon four-of-coins]]
      (is (not (pair? pair-hand))))))
(ns mahjong.tile-test
  (:require [clojure.test :refer :all]
            [mahjong.tile :refer :all]))

(deftest honor-test
  (testing "That 7 Bamboo is not an honor"
    (is (not (honor? 🀖))))
  (testing "That the Green Dragon is an honor"
    (is (honor? 🀅)))
  (testing "That the North Wind is an honor"
    (is (honor? 🀃))))


(deftest terminal-test
  (testing "That 7 Bamboo is not a terminal"
    (is (not (terminal? 🀖))))
  (testing "That the Green Dragon is not a terminal"
    (is (not (terminal? 🀅))))
  (testing "That the North Wind is not a terminal"
    (is (not (terminal? 🀃))))
  (testing "That 9 Characters is a terminal"
    (is (terminal? 🀏)))
  (testing "That 1 Coins is a terminal"
    (is (terminal? 🀙))))

(deftest next-from-vector-test
  (testing "That the next element is returned"
    (is (= 🀖 (next-from-vector 🀕 bamboo))))
  (testing "That the vector wraps around"
    (is (= 🀇 (next-from-vector 🀏 characters))))
  (testing "That nil is returned if it can't be found"
    (is (nil? (next-from-vector 🀏 bamboo))))
  (testing "That nil is returned if the vector is empty"
    (is (nil? (next-from-vector 🀏 []))))
  )
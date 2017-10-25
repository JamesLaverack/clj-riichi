(ns riichi.tile-test
  (:require [clojure.test :refer :all]
            [riichi.tile :refer :all]))

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
    (is (nil? (next-from-vector 🀏 [])))))


(deftest bamboo-test
  (testing "That 7 Bamboo is bamboo"
    (is (bamboo? 🀖)))
  (testing "That 6 Characters is not bamboo"
    (is (not (bamboo? 🀌))))
  (testing "That the Green Dragon is not bamboo"
    (is (not (bamboo? 🀅)))))

(deftest coin-test
  (testing "That 3 Coin is a coin"
    (is (coin? 🀛)))
  (testing "That 6 Characters is not a coin"
    (is (not (coin? 🀌))))
  (testing "That the Green Dragon is not a coin"
    (is (not (coin? 🀅)))))

(deftest character-test
  (testing "That 9 Characters is a character"
    (is (character? 🀏)))
  (testing "That 3 coin is not a character"
    (is (not (character? 🀛))))
  (testing "That the Green Dragon is not a character"
    (is (not (character? 🀅)))))

(deftest dragon-test
  (testing "That 9 Characters is not a dragon"
    (is (not (dragon? 🀏))))
  (testing "That the West Wind is not a dragon"
    (is (not (dragon? 🀂))))
  (testing "That the Green Dragon is a dragon"
    (is (dragon? 🀅))))

(deftest wind-test
  (testing "That 9 Characters is not a wind"
    (is (not (wind? 🀏))))
  (testing "That the West Wind is a wind"
    (is (wind? 🀂)))
  (testing "That the Green Dragon is not a wind"
    (is (not (wind? 🀅)))))

(deftest next-test
  (testing "That the next tile is given for a suit tile"
    (is (= (next-tile 🀝) 🀞)))
  (testing "That the next tile is given for a suit tile wrapping around"
    (is (= (next-tile 🀘) 🀐))))

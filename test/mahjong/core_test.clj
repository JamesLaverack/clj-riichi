(ns mahjong.core-test
  (:require [clojure.test :refer :all]
            [mahjong.core :refer :all]))

(def one-of-characters {:suit :characters :number 1})
(def two-of-characters {:suit :characters :number 2})
(def three-of-characters {:suit :characters :number 3})
(def four-of-characters {:suit :characters :number 4})
(def five-of-characters {:suit :characters :number 5})
(def six-of-characters {:suit :characters :number 6})
(def seven-of-characters {:suit :characters :number 7})
(def eight-of-characters {:suit :characters :number 8})
(def nine-of-characters {:suit :characters :number 9})

(def one-of-bamboo {:suit :bamboo :number 1})
(def two-of-bamboo {:suit :bamboo :number 2})
(def three-of-bamboo {:suit :bamboo :number 3})
(def four-of-bamboo {:suit :bamboo :number 4})
(def five-of-bamboo {:suit :bamboo :number 5})
(def six-of-bamboo {:suit :bamboo :number 6})
(def seven-of-bamboo {:suit :bamboo :number 7})
(def eight-of-bamboo {:suit :bamboo :number 8})
(def nine-of-bamboo {:suit :bamboo :number 9})

(def one-of-coins {:suit :coins :number 1})
(def two-of-coins {:suit :coins :number 2})
(def three-of-coins {:suit :coins :number 3})
(def four-of-coins {:suit :coins :number 4})
(def five-of-coins {:suit :coins :number 5})
(def six-of-coins {:suit :coins :number 6})
(def seven-of-coins {:suit :coins :number 7})
(def eight-of-coins {:suit :coins :number 8})
(def nine-of-coins {:suit :coins :number 9})

(def green-dragon {:dragon :green})
(def white-dragon {:dragon :white})
(def red-dragon {:dragon :red})

(def north-wind {:wind :north})
(def east-wind {:wind :east})
(def south-wind {:wind :south})
(def west-wind {:wind :west})


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

(deftest pon-test
  (testing "That a pon is detected"
    (let [pon-hand [north-wind east-wind east-wind west-wind west-wind west-wind five-of-characters five-of-characters five-of-characters red-dragon white-dragon one-of-bamboo two-of-bamboo three-of-bamboo]]
      (is (= (pons pon-hand) [[[west-wind west-wind west-wind] [five-of-characters five-of-characters five-of-characters]] [north-wind east-wind east-wind red-dragon white-dragon one-of-bamboo two-of-bamboo three-of-bamboo]])))))

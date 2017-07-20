(ns mahjong.tile)

(defn suit?
  "Is the given tile a suit tile?"
  [tile]
  (contains? tile :suit))

(defn honor?
  "Is the given tile an honor?"
  [tile]
  (not (suit? tile)))

(defn terminal?
  "Is the given tile a terminal, that is, a 1 or a 9 suit tile."
  [tile]
  (and (suit? tile) (or (= (:number tile) 1) (= (:number tile) 9))))

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

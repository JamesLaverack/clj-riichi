(ns mahjong.tile)

(defn suit?
  "Is the given tile a suit tile?"
  [tile]
  (contains? tile :suit))

(defn bamboo?
  [tile]
  (= (:suit tile) :bamboo))

(defn coin?
  [tile]
  (= (:suit tile) :coins))

(defn character?
  [tile]
  (= (:suit tile) :characters))

(defn honor?
  "Is the given tile an honor?"
  [tile]
  (not (suit? tile)))

(defn dragon?
  [tile]
  (contains? tile :dragon))

(defn wind?
  [tile]
  (contains? tile :wind))

(defn terminal?
  "Is the given tile a terminal, that is, a 1 or a 9 suit tile."
  [tile]
  (and (suit? tile) (or (= (:number tile) 1) (= (:number tile) 9))))

;; Define all the tiles in english

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

;; Define them with unicode too
(def 🀀 east-wind)
(def 🀁 south-wind)
(def 🀂 west-wind)
(def 🀃 north-wind)
(def winds [🀀 🀁 🀂 🀃])

(def 🀄 red-dragon)
(def 🀅 green-dragon)
(def 🀆 white-dragon)
(def dragons [🀄 🀅 🀆])

(def 🀇 one-of-characters)
(def 🀈 two-of-characters)
(def 🀉 three-of-characters)
(def 🀊 four-of-characters)
(def 🀋 five-of-characters)
(def 🀌 six-of-characters)
(def 🀍 seven-of-characters)
(def 🀎 eight-of-characters)
(def 🀏 nine-of-characters)
(def characters [🀇 🀈 🀉 🀊 🀋 🀌 🀍 🀎 🀏])

(def 🀐 one-of-bamboo)
(def 🀑 two-of-bamboo)
(def 🀒 three-of-bamboo)
(def 🀓 four-of-bamboo)
(def 🀔 five-of-bamboo)
(def 🀕 six-of-bamboo)
(def 🀖 seven-of-bamboo)
(def 🀗 eight-of-bamboo)
(def 🀘 nine-of-bamboo)
(def bamboo [🀐 🀑 🀒 🀓 🀔 🀕 🀖 🀗 🀘])

(def 🀙 one-of-coins)
(def 🀚 two-of-coins)
(def 🀛 three-of-coins)
(def 🀜 four-of-coins)
(def 🀝 five-of-coins)
(def 🀞 six-of-coins)
(def 🀟 seven-of-coins)
(def 🀠 eight-of-coins)
(def 🀡 nine-of-coins)
(def coins [🀙 🀚 🀛 🀜 🀝 🀞 🀟 🀠 🀡])

(defn next-from-vector
  [element vector]
  (loop [first-element (first vector)
         element element
         test-element (first vector)
         vector (rest vector)]
    (if (nil? test-element)
      nil
      (if (= test-element element)
        (if (empty? vector)
          first-element
          (first vector))
        (recur first-element element (first vector) (rest vector))))))


(defn next-tile
  [tile]
  (next-from-vector tile (cond
                           (dragon? tile) dragons
                           (wind? tile) winds
                           (bamboo? tile) bamboo
                           (coin? tile) coins
                           (character? tile) characters
                           :else [])))


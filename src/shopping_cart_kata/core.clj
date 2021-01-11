(ns shopping-cart-kata.core
  (:require
    [clojure.string :as string]))

(defn sort-basket
  [basket]
  (string/join (sort (to-array basket))))

(defn price
  [item]
  (cond
    (= "A" item) 50
    (= "B" item) 30
    (= "C" item) 20
    (= "D" item) 10
    (= "X" item) 130
    (= "Y" item) 37))

(defn offers
  [basket]
  (-> (sort-basket basket)
      (string/replace #"AAA" "X")
      (string/replace #"BB" "Y")))

(defn calculate
  [input]
  (as-> (offers input) basket
        (string/split basket #"")
        (map price basket)
        (reduce + basket)))

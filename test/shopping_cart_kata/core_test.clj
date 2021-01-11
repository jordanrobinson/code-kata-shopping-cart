(ns shopping-cart-kata.core-test
  (:require
    [clojure.test :refer :all]
    [shopping-cart-kata.core :refer :all]))

(deftest happy-path
  (testing "acts as expected when given items"
    (let [expected 140
          input "DABA"]
      (is (= (calculate input) expected)))))

(deftest pricing
  (testing "pricing and offers of A are correct"
    (is (= (calculate "A") 50))
    (is (= (calculate "AA") 100))
    (is (= (calculate "AAA") 130))
    (is (= (calculate "AAAA") 180)))
  (testing "pricing and offers of B are correct"
    (is (= (calculate "B") 30))
    (is (= (calculate "BB") 37))
    (is (= (calculate "BBB") 67))
    (is (= (calculate "BBBB") 74)))
  (testing "pricing and offers of C are correct"
    (is (= (calculate "C") 20))
    (is (= (calculate "CC") 40))
    (is (= (calculate "CCC") 60))
    (is (= (calculate "CCCC") 80)))
  (testing "pricing and offers of C are correct"
    (is (= (calculate "D") 10))
    (is (= (calculate "DD") 20))
    (is (= (calculate "DDD") 30))
    (is (= (calculate "DDDD") 40))))

(deftest offers-recognition
  (testing "offers are recognised within a basket"
    (is (= (offers "AAA") "X"))
    (is (= (offers "BB") "Y"))
    (is (= (offers "BBBB") "YY"))))

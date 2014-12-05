(ns org.noisesmith.hint-hint-test
  (:require [clojure.test :refer [testing is deftest]]
            [org.noisesmith.hint-hint.capture-warnings :as capture]))

;; the pattern here will be to introduce a situtation where a type hint is
;; useful, and to show how to correctly provide the needed hinting.
(deftest basic-reflection
  (testing "warning is present without a hint"
    (is (.startsWith
         (let [^String result (with-out-str
                                (binding [*err* *out*]
                                  (eval '(fn [a] (.toString a)))))]
           result)
         "Reflection warning")))
  (testing "warning is absent when a hint is provided"
    (is (=
         (with-out-str
           (binding [*err* *out*]
             (eval '(fn [^Number a] (.toString a)))))
         ""))))

(deftest basic-reflection-redux
  (testing "same as the previous, but with a helper macro"
    (is (.startsWith (capture/warn-str
                      (fn [a] (.toString a)))
                     "Reflection warning")))
  (testing "ibid"
    (is (= (capture/warn-str
            (fn [^Number a] (.toString a)))
           ""))))


(deftest basic-numeric-boxing
  (testing "we get boxed math warnings if we don't hint the args"
    (is (.startsWith (capture/warn-str
                      (fn [a b] (+ a b)))
                     "Boxed math warning")))
  (testing "the boxed math warnings go away if we hint the args"
    (is (= (capture/warn-str
            (fn [^long a ^long b] (+ a b)))
           ""))))

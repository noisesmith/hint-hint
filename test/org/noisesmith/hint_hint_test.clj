(ns org.noisesmith.hint-hint-test
  (:require [clojure.test :refer [testing is deftest]]
            [org.noisesmith.hint-hint.capture-warnings :as capture]))

(deftest basic-reflection
  (testing "warning is present without a hint"
    (is (.startsWith
         (with-out-str
           (binding [*err* *out*]
             (eval '(fn [a] (.toString a)))))
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

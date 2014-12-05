(ns org.noisesmith.hint-hint
  (:require org.noisesmith.hint-hint-test
            [clojure.test :as test]))

(defn -main
  "runs the tests to verify claims made in the comments"
  [& args]
  (test/run-tests 'org.noisesmith.hint-hint-test))

(defproject org.noisesmith/hint-hint "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :global-vars {*warn-on-reflection* true
                *unchecked-math* :warn-on-reflection}
  :url "https://github.com/noisesmith/hint-hint"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-alpha4"]]
  :main ^:skip-aot org.noisesmith.hint-hint
  :source-paths ["src/" "test/"]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

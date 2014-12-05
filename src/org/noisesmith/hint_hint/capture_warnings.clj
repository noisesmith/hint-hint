(ns org.noisesmith.hint-hint.capture-warnings)

(defmacro warn-str
  [& body]
  `(let [^String result#
         (with-out-str
           (binding [*err* *out*]
             (doseq [form# '~body]
               (eval form#))))]
    result#))

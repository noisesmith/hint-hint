(ns org.noisesmith.hint-hint.capture-warnings)

(defmacro warn-str
  [& body]
  `(with-out-str
     (binding [*err* *out*]
       (doseq [form# '~body]
         (eval form#)))))

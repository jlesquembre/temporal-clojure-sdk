(ns build
  (:require [clojure.tools.build.api :as b]))

(def class-dir "target/classes")
(def basis (delay (b/create-basis {:project "deps.edn"})))
(def javac-options ["-target" "11" "-source" "11"])

(defn prep [_]
  (b/javac {:src-dirs ["src"]
            :class-dir class-dir
            :basis @basis
            :javac-opts javac-options}))

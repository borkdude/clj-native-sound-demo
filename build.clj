(ns build
  (:require [clojure.tools.build.api :as b]
            [clojure.edn :as edn]))

(def project (-> (edn/read-string (slurp "deps.edn"))
                 :aliases :neil :project))
(def lib (or (:name project) 'clj-native-sound-demo))

;; use neil project set version 1.2.0 to update the version in deps.edn

(def version (or (:version project)
                 "0.0.1"))
(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn" :aliases [:native]}))
(def uber-file (format "target/%s.jar" (name lib)))

(defn clean [_]
  (b/delete {:path "target"}))

(defn uber [_]
  (clean nil)
  (b/copy-dir {:src-dirs ["src" "resources"]
               :target-dir class-dir})
  (b/compile-clj {:basis basis
                  :src-dirs ["src"]
                  :class-dir class-dir})
  (println "Creating" uber-file)
  (b/uber {:class-dir class-dir
           :uber-file uber-file
           :basis basis
           :main 'borkdude.clj-native-sound-demo}))


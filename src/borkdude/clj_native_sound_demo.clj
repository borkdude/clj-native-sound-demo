(ns borkdude.clj-native-sound-demo
  (:require [clojure.java.io :as io])
  (:gen-class))

(import '[javax.sound.midi MidiSystem])

(set! *warn-on-reflection* true)

(defn -main [& args]
  (let [sequencer (MidiSystem/getSequencer)]
    (.open sequencer)
    (.setSequence sequencer (io/input-stream (io/file (first args))))
    (.start sequencer)))


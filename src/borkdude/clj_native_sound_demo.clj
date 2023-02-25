(ns borkdude.clj-native-sound-demo
  (:gen-class)
  (:import
   (javax.sound.midi MidiSystem)))

(set! *warn-on-reflection* true)

(defn -main [& _args]
  (let [midi-synth (MidiSystem/getSynthesizer)
        _ (.open midi-synth)
        instruments (.getInstruments (.getDefaultSoundbank midi-synth))
        midi-channels (.getChannels midi-synth)]
    (.loadInstrument midi-synth ^javax.sound.midi.Instrument (first instruments))
    (.noteOn ^javax.sound.midi.MidiChannel (first midi-channels) 60 100)
    (Thread/sleep 1000)
    (.noteOff ^javax.sound.midi.MidiChannel (first midi-channels) 60)))

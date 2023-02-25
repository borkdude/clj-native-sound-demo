# clj-native-sound-demo

> WARNING: this is still under construction.

## Build

Requires [babashka](https://github.com/babashka/babashka#installation).
Set `GRAALVM_HOME` or add `native-image` to your `PATH`.
Finally, run `bb native` to build the native image.

## Issues

### Can't find java.home

Upon executing `./clj-native-sound-demo` you'll see:

```
Exception in thread "main" java.lang.Error: Can't find java.home ??
    at java.desktop@11.0.18/com.sun.media.sound.JSSecurityManager.lambda$loadProperties$1(JSSecurityManager.java:89)
    at java.base@11.0.18/java.security.AccessController.executePrivileged(AccessController.java:168)
    at java.base@11.0.18/java.security.AccessController.doPrivileged(AccessController.java:82)
    at java.desktop@11.0.18/com.sun.media.sound.JSSecurityManager.loadProperties(JSSecurityManager.java:86)
    at java.desktop@11.0.18/com.sun.media.sound.JDK13Services.getProperties(JDK13Services.java:191)
    at java.desktop@11.0.18/com.sun.media.sound.JDK13Services.getDefaultProvider(JDK13Services.java:176)
    at java.desktop@11.0.18/com.sun.media.sound.JDK13Services.getDefaultProviderClassName(JDK13Services.java:118)
    at java.desktop@11.0.18/javax.sound.midi.MidiSystem.getDefaultDevice(MidiSystem.java:1100)
    at java.desktop@11.0.18/javax.sound.midi.MidiSystem.getDefaultDeviceWrapper(MidiSystem.java:1082)
    at java.desktop@11.0.18/javax.sound.midi.MidiSystem.getSynthesizer(MidiSystem.java:307)
    at borkdude.clj_native_sound_demo$_main.invokeStatic(clj_native_sound_demo.clj:8)
    at borkdude.clj_native_sound_demo$_main.doInvoke(clj_native_sound_demo.clj:8)
    at clojure.lang.RestFn.invoke(RestFn.java:397)
    at clojure.lang.AFn.applyToHelper(AFn.java:152)
    at clojure.lang.RestFn.applyTo(RestFn.java:132)
    at borkdude.clj_native_sound_demo.main(Unknown Source)
```

### JVM_ArrayCopy called:  Unimplemented

When executing with `./clj-native-sound-demo -Djava.home=$GRAALVM_HOME` you'll see:

```
Fatal error reported via JNI: JVM_ArrayCopy called:  Unimplemented
```

followed by a long scary output.

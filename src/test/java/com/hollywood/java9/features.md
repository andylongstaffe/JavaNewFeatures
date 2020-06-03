## Java 9

* Released Sept 2017
* Modules is the headline feature (JPMS)
* Improvements to Process API
* JShell (interactive command line tool)
* Private methods in interfaces
* Improved logging in JDK ad JVM via logging framework of choice (intended for use by JDK only)
* API additions to Streams, Collections
* Multi-release JARs
* @Deprecated now includes since and forRemoval
* StackWalker for stack navigation (ie call stack)
* Compact Strings, now internally stored as byte[] rather than char[] which takes 50% less space, wow!

### Modules

In java modular programming-

* A module is typically just a jar file that has a module-info.class file at the root.
* To use a module, include the jar file into modulepath instead of the classpath. A 
modular jar file added to classpath is normal jar file and module-info.class file will 
be ignored.

Typical module-info.java classes looks like this:

```
module helloworld {
    exports com.howtodoinjava.demo;
}
  
module test {
    requires helloworld;
}
```

### Process API

Easier to get info on java processes (ProcessHandle)

Java 5 added ProcessBuilder for spawning new processes.

### Collection API updates

Factory methods for immutable collections such as list, set and map. 
* List.of, Set.of, Map.ofEntries
* Map.entry

### Multi release JARS

Allow JAR with different versions of a class to be included to target different JDKs

manifest.mf: Multi-Release: true

### Other changes

* Allow private methods in interfaces (useful for default methods introduced in Java 8)
* New HTTP client which also supports HTTP/2, uses a nice flowing api.
* Try-with-resources can be useful with effectively final resources
* Optional additions: stream, ifPresentOrElse, or

## Docs

https://dzone.com/articles/java-9-its-heeeere


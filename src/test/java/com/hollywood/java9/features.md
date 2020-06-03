## Java 9

* Released Sept 2017
* Modules is the headline feature (JPMS)
* Improvements to Process API
* JShell
* Private methods in interfaces

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



### Other changes

* Allow private methods in interfaces (useful for default methods introduced in Java 8)
* New HTTP client which also supports HTTP/2, uses a nice flowing api.

## Docs

https://dzone.com/articles/java-9-its-heeeere


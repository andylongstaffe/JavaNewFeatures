* Every module depends on java.base
* From Java 9 onwards, public means public only to all other packages inside that module. Only when the package containing the public type is exported, can it be used by other modules.

```
module helloworld {
    exports com.howtodoinjava.demo;
}
 
module test {
    require s helloworld;
}
```

Can use as normal until app uses a module path (-p) rather than class path (-c)

## Advantages  

1. Avoid small devices running whole JDK
2. Space is important even on larger devices
3. Improve capsulation, public is no longer visible unless it is explicitly exported (applies to reflection too)
4. Prevent use of internal api's and only expose through interfaces
5. Improve performance

## Modules types

1. App modules (the ones we write)
2. Automated modules (JARs on module path with module descriptor - legacy usage)
3. Unnamed modules - from the class path
4. Platform modules - from JDK eg java.se (everything), java.xml.ws

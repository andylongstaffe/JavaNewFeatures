* Every module depends on java.base
* From Java 9 onwards, public means public only to all other packages inside that module. Only when the package containing the public type is exported, can it be used by other modules.

```
module helloworld {
    exports com.howtodoinjava.demo;
}
 
module test {
    requires helloworld;
}
```

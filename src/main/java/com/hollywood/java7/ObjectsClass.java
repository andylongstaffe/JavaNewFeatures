package com.hollywood.java7;

import com.hollywood.fixtures.Foo;

import java.util.Objects;

/**
 * Created by andylongstaffe on 31/01/2017.
 */
public class ObjectsClass {

    private String bar;
    private String baz;
    private Foo foo = null;

    public String apiCall(String bar, String baz) {
        this.bar = Objects.requireNonNull(bar, "bar must not be null");
        this.baz = Objects.requireNonNull(baz, "baz must not be null");
        return bar + ' ' + baz;
    }

    public String toString() {
        return "bar=" + bar + " baz=" + baz + " foo=" + Objects.toString(foo);
    }

}

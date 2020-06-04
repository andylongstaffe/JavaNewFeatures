package com.hollywood.java10;

import org.junit.Test;

import java.util.List;

public class Var {

    // var cannot go here

    @Test
    public void varOnlyAppliesToLocalVariables() {
        var people = List.of("hiya");
    }
}

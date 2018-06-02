package com.hollywood.java7;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by andylongstaffe on 31/01/2017.
 */
public class ObjectsClassTest {

    @Test
    public void test() {
        new ObjectsClass().apiCall("hey", "there");
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowAnException() {
        new ObjectsClass().apiCall("hey", null);
    }

    @Test
    public void toStringIsNullSafe() {
        ObjectsClass test = new ObjectsClass();
        test.apiCall("hey", "there");
        Assert.assertEquals("bar=hey baz=there foo=null", test.toString());
    }

}

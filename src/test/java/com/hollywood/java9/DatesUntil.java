package com.hollywood.java9;

import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class DatesUntil {

    @Test
    public void datesUntil() {
        LocalDate now = LocalDate.now();
        System.out.println(now.datesUntil(LocalDate.now().plusDays(10)).collect(Collectors.toList()));
    }

    @Test
    public void datesUntilWithStep() {
        LocalDate now = LocalDate.now();
        System.out.println(now.datesUntil(LocalDate.now().plusDays(10)).collect(Collectors.toList()));
    }
}

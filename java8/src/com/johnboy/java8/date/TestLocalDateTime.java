package com.johnboy.java8.date;

import org.junit.Test;

import java.time.LocalDateTime;

public class TestLocalDateTime {

    @Test
    public void test1(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime2 = LocalDateTime.of(2015,11,10,22,33,33);
        System.out.println(localDateTime2);
    }
}

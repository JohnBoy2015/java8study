package com.johnboy.java8;

import org.junit.Test;

import java.util.function.Consumer;

public class TestLambda2 {

    @Test
    public void test1() {
        Runnable runnable = () -> {
            System.out.println("hello");
        };
        runnable.run();
    }

    @Test
    public void test2() {
        Consumer<String> str = (s1) -> {
            System.out.println(s1);
        };
        str.accept("hello");
    }

    @Test
    public void test3() {
        Integer result = operation(100, x -> x * x);
        System.out.println(result.intValue());
    }

    public Integer operation(Integer num, MyFunction<Integer> mf) {
        return mf.getValue(num);
    }
}

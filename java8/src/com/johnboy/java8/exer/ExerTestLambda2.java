package com.johnboy.java8.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Consumer<T>:消费 无返回值
 * void accept(T t)</>
 * Supplier<T> :供给型接口
 * T get();
 * Function<T,R>:函数形接口
 * R apply(T t);
 * Predicate<T>: 断言型接口
 * boolean test(T t);
 */
public class ExerTestLambda2 {

    @Test
    public void test1() {
        happy(11.22, e1 -> System.out.println(e1));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test2() {
        List<Integer> lit = getIntegers(10, () -> (int)(Math.random()*100));
        for (Integer i :
                lit) {
            System.out.println(i);
        }
    }

    public List<Integer> getIntegers(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    public String strHandler(String str, Function<String,String> function){
        return function.apply(str);
    }
}

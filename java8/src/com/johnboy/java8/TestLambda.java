package com.johnboy.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class TestLambda {
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet treeSet = new TreeSet(com);
        treeSet.add(new Integer(11));
    }

    @Test
    public void test2() {
        Comparator<Integer> com = (x1, x2) -> Integer.compare(x1, x2);
        TreeSet treeSet = new TreeSet(com);
        treeSet.add(new Integer(11));
    }

    @Test
    public void test3(){

    }
}

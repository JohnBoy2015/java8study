package com.johnboy.java8;

import org.junit.Test;

public class TestDefaultInterface {

    @Test
    public void test1(){
        SubClass subClass = new SubClass();
        System.out.println(subClass.getName());
        MyFun.show();
    }
}

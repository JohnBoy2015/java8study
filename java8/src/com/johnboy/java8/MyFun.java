package com.johnboy.java8;

public interface MyFun {
    default String getName(){
        return "hahaha";
    }

    static void show(){
        System.out.println("show");
    }
}

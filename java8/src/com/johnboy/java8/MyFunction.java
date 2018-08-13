package com.johnboy.java8;

@FunctionalInterface
public interface MyFunction<T> {
    T getValue(T t);
}

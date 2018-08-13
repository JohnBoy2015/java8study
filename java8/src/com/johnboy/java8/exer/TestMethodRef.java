package com.johnboy.java8.exer;

import com.johnboy.java8.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用  如果Lambda 体中的内容有方法已经实现了，
 *
 * 对象::实例方法名
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 * @Lambda 表达式
 *
 */
public class TestMethodRef {

    @Test
    public void test1(){
        Consumer<String> con =(x)-> System.out.println(x);
        PrintStream ps = System.out;

        Consumer<String> consumerFunction =ps::println;

        Consumer<String> con1 = System.out::println;
    }

    @Test
    public void test2(){
        Employee employee = new Employee();

        Supplier<Employee> sup =Employee::new;
    }

    //类::实力方法名
    @Test
    public void test3(){
        BiPredicate<String,String> biPredicate = String::equals;
    }
}

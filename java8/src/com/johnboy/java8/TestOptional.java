package com.johnboy.java8;

import org.junit.Test;

import java.util.EnumMap;
import java.util.Optional;

public class TestOptional {

    @Test
    public void test1() {
        Optional<Employee> op = Optional.of(new Employee());
        Employee employee = op.get();
        System.out.println(employee);
    }

    @Test
    public void test2() {
        //构建一个空的Optional实例
        Optional<Employee> op = Optional.empty();
        Employee employee = op.get();
        System.out.println(employee);
    }

    @Test
    public void test3() {
        Optional<Employee> op = Optional.ofNullable(null);
        if (op.isPresent()) {
            System.out.println(op.get());
        }
        Employee employee = op.orElse(new Employee("张三", 11, 222));
        System.out.println(employee);
        Employee employee1 =  op.orElseGet(Employee::new);
        System.out.println(employee1);
    }

    @Test
    public void test4(){
        Optional<Employee> op = Optional.ofNullable(new Employee());
        Optional<String> str = op.map(Employee::getName);
        System.out.println(str.get());

    }


}

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
        Employee employee1 = op.orElseGet(Employee::new);
        System.out.println(employee1);
    }

    @Test
    public void test4() {
        Optional<Employee> op = Optional.ofNullable(new Employee("aaa", 11, 11));
        Optional<String> str = op.map(Employee::getName);
        System.out.println(str.get());

        Optional<String> str2 = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(str2.get());
    }

    @Test
    public void test5() {
        String str = genGodnessName2(Optional.ofNullable(null));
        System.out.println(str);
    }

    public String genGodnessName2(Optional<NewMan> man) {
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("苍老师"))
                .getName();
    }


}

package com.johnboy.java8.exer;

import com.johnboy.java8.Employee;
import com.johnboy.java8.MyFunction2;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExerTestlambda {
    public List<Employee> emsp = Arrays.asList(new Employee("zhangsan1", 11, 11.00),
            new Employee("zhangsan2", 12, 5551.00),
            new Employee("zhangsan3", 22, 444.00),
            new Employee("zhangsan4", 11, 141.00),
            new Employee("zhangsan5", 33, 1331.00),
            new Employee("zhangsan6", 22, 15531.00));

    @Test
    public void test1() {
        Collections.sort(emsp, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee e : emsp) {
            System.out.println(e);
        }
    }

    @Test
    public void test2() {
        op(22l, 33l, (e1, e2) -> e1 * e2);
    }

    public void op(Long l1, Long l2, MyFunction2<Long, Long> myFunction2) {
        System.out.println(myFunction2.getValue(l1, l2));
    }
}

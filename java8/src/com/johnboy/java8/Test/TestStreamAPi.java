package com.johnboy.java8.Test;

import com.johnboy.java8.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStreamAPi {
    /**
     * 1,2,3,4,5 返回平方值
     */
    @Test
    public void test1(){
        Arrays.asList(1,2,3,4,5)
                .stream()
                .map(e->e*e).
                collect(Collectors.toList()).forEach(System.out::println);
    }
    @Test
    public void test2(){
        Optional<Integer> longValue = emsp.stream().map(e->1).reduce(Integer::sum);
        System.out.println(longValue.get());
    }



    public List<Employee> emsp = Arrays.asList(new Employee("zhangsan1", 11, 11.00),
            new Employee("zhangsan2", 12, 5551.00),
            new Employee("zhangsan3", 22, 444.00),
            new Employee("zhangsan4", 11, 141.00),
            new Employee("zhangsan5", 33, 1331.00),
            new Employee("zhangsan6", 22, 15531.00));

}

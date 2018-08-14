package com.johnboy.java8.Test;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestTransaction {
    List<Transaction> transactions = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    //1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）
    @Test
    public void test1() {
        transactions.stream().
                filter(e -> e.getYear() == 2011).
                sorted((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue())).
                collect(Collectors.toList()).forEach(System.out::println);
    }

    //2. 交易员都在哪些不同的城市工作过？
    @Test
    public void test2() {
        transactions.stream().
                map(e -> e.getTrader().getCity()).
                distinct().
                forEach(System.out::println);
    }

    ////3. 查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test3() {
        transactions.stream()
                .filter(e -> e.getTrader().getCity().equals("Cambridge"))
                .sorted((e1, e2) -> e1.getTrader().getName().compareTo(e2.getTrader().getName()))
                .map(Transaction::getTrader)
                .distinct()
                .forEach(System.out::println);
    }

    //4. 返回所有交易员的姓名字符串，按字母顺序排序
    @Test
    public void test4() {
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .map(Trader::getName)
                .sorted(String::compareTo)
                .forEach(System.out::println);
        Optional<String> str = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .map(Trader::getName)
                .sorted(String::compareTo)
                .reduce(String::concat);
        System.out.println(str.get());

        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .map(Trader::getName)
                .sorted(String::compareTo)
                .flatMap(e1 -> {
                    List<String> list = new ArrayList<>();
                    for (Character character : e1.toCharArray()) {
                        list.add(character.toString());
                    }
                    return list.stream();
                })
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::print);
    }

    @Test
    public void test5() {
        boolean flag = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(e -> e.getCity().equals("Milan"));
        System.out.println(flag);
    }

    @Test
    public void test6() {
        Optional<Integer> sum = transactions.stream()
                .filter(e -> e.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce((e1, e2) -> e1 + e2);
        System.out.println(sum.get());
    }

    @Test
    public void test7(){
       Optional<Transaction> transaction = transactions.stream()
                .max((Comparator.comparingInt(Transaction::getValue)));
        System.out.println(transaction.get().getValue());
    }

    @Test
    public void test8(){
        Optional<Transaction> transaction = transactions.stream()
                .min((t1,t2)->Integer.compare(t1.getValue(),t2.getValue()));
        System.out.println(transaction.get().getValue());
    }
}

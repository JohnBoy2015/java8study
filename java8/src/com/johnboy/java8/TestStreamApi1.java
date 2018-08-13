package com.johnboy.java8;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1.创建Stream
 * 2.中间操作
 * 3.终止操作
 *
 */
public class TestStreamApi1 {

    /**
     * stream() 串形流
     * parallelStream()  并行流
     */
    @Test
    public  void test1(){
//        List<String> list  = new ArrayList<>();
//        Stream<String> stringStream =  list.stream();
//
//         Employee[] employees = new Employee[10];
//         Arrays.stream(employees);
//
//         Stream.of("aa","bb","cc","dd");
         //创建无限流
        //迭代 
        Stream<Integer> stream4 =  Stream.iterate(0,x->x+2);
        stream4.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    public List<Employee> emsp = Arrays.asList(new Employee("zhangsan1", 11, 11.00),
            new Employee("zhangsan2", 12, 5551.00),
            new Employee("zhangsan3", 22, 444.00),
            new Employee("zhangsan4", 11, 141.00),
            new Employee("zhangsan5", 33, 1331.00),
            new Employee("zhangsan6", 22, 15531.00));

    @Test
    public void test2(){
       Stream<Employee> s = emsp.stream().filter(e->{
           System.out.println("api center"); return  e.getAge()>20;});
       s.forEach(System.out::println);
    }

    @Test
    public void test3(){
        emsp.stream()
                .filter(e->{
                    System.out.println("ddd");
                    return e.getSalary()>500;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test4(){
       Stream<String> stringStream =  Stream.of("aaa","bb","cc");

//        stringStream.map(String::toUpperCase)
//                .forEach(System.out::println);
//
//        emsp.stream()
//                .map(Employee::getName)
//                .forEach(System.out::println);

//        Stream<Stream<Character>> streamStream =  stringStream
//                .map(TestStreamApi1::filterCharacter);
//
//        streamStream.forEach(sm->sm.forEach(System.out::println));
        //吧所有的 流组 转换成一个流  flatMap
//        stringStream.flatMap(TestStreamApi1::filterCharacter).forEach(System.out::println);
        stringStream.map(e->e.toCharArray()[0]).forEach(System.out::println);
    }

    @Test
    public void test5(){
        Stream<String> stringStream = Stream.of("aa","bb","dd","ee","ff");
        stringStream
                .sorted(String::compareTo)
                .forEach(System.out::println);

        emsp.stream()
                .sorted((e1,e2)->{
                    if(e1.getAge()==e2.getAge()){
                        return e1.getName().compareTo(e2.getName());
                    }else{
                      return e1.getAge()-e2.getAge();
                    }
                })
                .forEach(System.out::println);
    }


    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for(Character ch : str.toCharArray()){
            list.add(ch);
        }
        return list.stream();
    }

    @Test
    public void  test6(){
        boolean result = emsp.stream().allMatch(e->e.getAge()==20);
        System.out.println(result);

       boolean b2 =  emsp.stream().anyMatch(e->e.getAge()==11);
        System.out.println(b2);
    }
    @Test
    public void test7(){
       Integer sum =  Arrays.asList(1,2,3,4,5,6,7,5,8).stream().reduce(0,(x,y)->x+y);
        System.out.println(sum);

       Optional<Double> d  = emsp.stream().map(Employee::getSalary).reduce(Double::sum);
    }

    /**
     * collect 收集  将流转换为其他形式
     */
    @Test
    public void test8(){
      List<String> list = emsp.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

      emsp.stream().map(Employee::getName).collect(Collectors.toSet()).forEach(System.out::println);

    emsp.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new)).forEach(System.out::println);
    }

    @Test
    public void test9(){
        Long count = emsp.stream().collect(Collectors.counting());
        System.out.println(count);

        double avarg = emsp.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avarg);

        Double sum=  emsp.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        Optional<Employee> max =  emsp.stream().collect(Collectors.maxBy((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary())));
        System.out.println(max.get().getSalary());
    }

    /**
     * 分组
     */
    @Test
    public void test10(){
        Map<Integer,List<Employee>> map =   emsp.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(map);
    }

    /**
     * 多级分组
     */
    @Test
    public void test11(){
     Map<String, Map<Object, List<Employee>>> map =  emsp.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.groupingBy(e->{
          if( ((Employee)e).getAge()<20){
              return "青年";
          }else if(((Employee) e).getAge()<50){
              return "中年";
          }else {
              return "老年";
          }
     })));

        System.out.println(map);
    }

    /**
     * 分区  (满足条件 一个区  不满足 )
     */
    @Test
    public void test12(){
      Map<Boolean,List<Employee>> booleanListMap =   emsp.stream().collect(Collectors.partitioningBy(e->e.getSalary()>2000));
        System.out.println(booleanListMap);
    }

    /**
     * 数据分析
     */
    @Test
    public void test13(){
      DoubleSummaryStatistics dss =  emsp.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
    }

    /**
     * 链接
     */
    @Test
    public void test14(){
     String str =   emsp.stream().map(Employee::getName).collect(Collectors.joining("，"));
        System.out.println(str);
    }

}

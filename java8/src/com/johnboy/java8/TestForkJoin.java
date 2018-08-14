package com.johnboy.java8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoin {

    @Test
    public void test1() {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 10000000000l);
        long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());//84
    }

    @Test
    public void test2(){
        Instant start = Instant.now();
        long sum=0L;
        for(long i =0;i<10000000000l;i++){
            sum+=i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());//22
    }

    @Test
    public void test3(){
        Instant start = Instant.now();
        long sum =  LongStream.rangeClosed(0,10000000000l)
                .parallel()
                .reduce(0,Long::sum);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());//22

    }
}

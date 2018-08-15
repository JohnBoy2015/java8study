package com.johnboy.java8.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDateFormat {

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");

        Callable<Date> all = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return sdf.parse("20161218");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for(int i=0;i<10;i++){
           results.add(pool.submit(all));
        }

        for(Future<Date> future:results){
            System.out.println(future.get());
        }

    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> all = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20161218",dtf);
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> results = new ArrayList<>();
        for(int i=0;i<10;i++){
            results.add(pool.submit(all));
        }

        for(Future<LocalDate> future:results){
            System.out.println(future.get());
        }

    }
}

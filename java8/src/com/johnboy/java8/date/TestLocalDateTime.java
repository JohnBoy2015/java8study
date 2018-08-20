package com.johnboy.java8.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestLocalDateTime {

    @Test
    public void test1() {
        //LocalDate  LocalTime  LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime2 = LocalDateTime.of(2015, 11, 10, 22, 33, 33);
        System.out.println(localDateTime2);

        System.out.println(localDateTime.plusYears(-1));
        System.out.println(localDateTime.plusYears(-1));
        System.out.println(localDateTime.plusYears(-1));
        System.out.println(localDateTime.getMonthValue());
        System.out.println("----------------");
        System.out.println(localDateTime.getSecond());
    }

    @Test
    public void test2() {
        //Instant 时间戳
        Instant instant = Instant.now(); //默认获取 UTC时区为基础的
        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        System.out.println(offsetDateTime.toEpochSecond());

        System.out.println(Instant.ofEpochSecond(60));
    }

    //Duration 计算2个时间之间的间隔
    @Test
    public void test3() {
        Instant instant = Instant.now();

        Instant instant1 = Instant.now();
        Duration duration = Duration.between(instant, instant1);
        System.out.println(duration.getNano());
        System.out.println(duration.toMillis());

        LocalTime localTime = LocalTime.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime localTime1 = LocalTime.now();

        System.out.println(Duration.between(localTime, localTime1).toMillis());
    }

    //计算2个日期之间的间隔
    @Test
    public void test4() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2014, 1, 1);
        Period period = Period.between(localDate, localDate1);
        System.out.println(period);
    }

    //TemporalAdjuster 时间矫正器
    @Test
    public void test5() {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);

        LocalDateTime localDateTime2 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(localDateTime2);

        localDateTime.with((e) -> {
            LocalDateTime localDateTime3 = (LocalDateTime) e;
            DayOfWeek dayOfWeek = localDateTime3.getDayOfWeek();
            switch (dayOfWeek) {
                case FRIDAY:
                    return localDateTime3.plusDays(1);
                case SUNDAY:
                    return localDateTime3;
                default:
                    return localDateTime3;
            }
        });
    }

    //DateTimeFormatter  格式化时间
    @Test
    public void test6() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.now();
        String strDate = dateTimeFormatter.format(ldt);
        System.out.println(strDate);
//        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ISO_DATE;
        System.out.println(DateTimeFormatter.ISO_DATE.format(ldt));
        System.out.println(DateTimeFormatter.ofPattern("yyyy年MM月dd日").format(ldt));
    }

    //时区处理ZoneTime  ZoneDate ZoneDateTime
    @Test
    public void test7() {
        //获取所有时区
        Set<String> strings = ZoneId.getAvailableZoneIds();
        strings.stream().forEach(System.out::println);
    }

    @Test
    public void test8() {
        //获取所有时区
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Harbin"));
        LocalDateTime ldt1 = LocalDateTime.now();
        ZonedDateTime dateTime =ldt1.atZone(ZoneId.of("Asia/Harbin"));
        System.out.println(dateTime);
    }
}

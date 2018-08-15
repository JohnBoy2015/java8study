package com.johnboy.java8.date;

import java.text.DateFormat;

public class DateFormatThreadLocal {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return super.initialValue();
        }
    };

}

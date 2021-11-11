package com.zgs.test.maindemo.service.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author 张贵松
 * @version 1.0.0
 * @ClassName DateTest.java
 * @Description
 * @createTime 2021年09月16日 14:57:00
 */
public class DateTest {
    public static void main(String[] args) {
        LocalDateTime localDateTime=LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone( ZoneId.systemDefault()).toInstant());
        System.out.println(date);
    }
}

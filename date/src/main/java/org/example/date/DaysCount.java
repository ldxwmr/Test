package org.example.date;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DaysCount {
    public static void main(String[] args) {
//        LocalDate now = LocalDate.now();
        LocalDate now = LocalDate.of(2023, 2, 1);
        // 获取当前月份天数
        System.out.println(now.getDayOfMonth());
        // 获得当月总天数
        System.out.println(now.lengthOfMonth());

        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println(dayOfWeek);
        System.out.println(firstLetterName(dayOfWeek.name()));
        System.out.println(firstLetterName(dayOfWeek.name().substring(0,3)));
        LocalDate date = LocalDate.of(2014, 2, 18);
        System.out.println(date.lengthOfMonth());

    }

    //首字母大写
    public static String firstLetterName(String name) {

        char[] cs=name.toLowerCase().toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }
}

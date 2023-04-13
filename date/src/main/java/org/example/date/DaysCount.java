package org.example.date;

import java.time.LocalDate;

public class DaysCount {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        // 获取当前月份天数
        System.out.println(now.getDayOfMonth());
        // 获得当月总天数
        System.out.println(now.lengthOfMonth());

        LocalDate date = LocalDate.of(2014, 2, 18);
        System.out.println(date.lengthOfMonth());

    }
}

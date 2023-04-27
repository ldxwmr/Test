package org.example.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class LatestMonth {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//定义日期显示格式
        LocalDate now1 = LocalDate.now();
        LocalDate date = LocalDate.of(2023, 04, 01);
        System.out.println(date.toString().substring(0,7));
        LocalDate localDate = now1.minusMonths(1);
        System.out.println(now1.toString().substring(0,7));
        System.out.println(now1.getYear()+"-"+now1.getMonthValue());
        System.out.println(localDate.getYear()+"-"+localDate.getMonthValue());

        Calendar c = Calendar.getInstance();

        c.add(Calendar.MONTH, -1);
//        上个月时间
        String before = sdf.format(c.getTime());
//        现在的时间
        String now = sdf.format(new Date());

        System.out.println("before: "+before+",now: "+now);
    }
}

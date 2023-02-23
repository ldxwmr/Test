package org.example.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatEnDate {
    public static void main(String[] args) throws ParseException {

        String date = "January-2023";
        System.out.println(format(date));
    }

    /**
     * 英文日期格式化
     *
     * @param date
     * @return
     * @throws ParseException
     */
    private static String format(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy", Locale.ENGLISH);
        Date date1 = sdf.parse(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(date1);
    }

}

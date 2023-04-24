package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws ParseException {
        for (int i = 0; i < 12; i++) {
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM");
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
            Date parse = dateFormat1.parse(i + 1 +"");
            String format = dateFormat.format(parse);
        }

        System.out.println("");
    }
}
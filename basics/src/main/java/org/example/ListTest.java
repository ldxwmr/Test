package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ListTest {
    public static void main(String[] args) throws ParseException {
        List<String> listT = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM");
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
            Date parse = dateFormat1.parse(i + 1 +"");
            String format = dateFormat.format(parse);
            listT.add(format);
        }
        listT.forEach(System.out::println);
        System.out.println("============");
//        List<String> list = new ArrayList<>();
//        list.add("Apr");
//        list.add("Apr");
//        list.forEach(System.out::println);
        Set<String> set = new LinkedHashSet<>();
        set.add("Jan-23");
        set.add("Feb-23");
        set.add("Mar-23");
        set.add("Apr-23");
        set.add("Apr-23");
        set.add("May-23");
        set.add("Jun-23");
        set.add("Jun-23");
        set.add("Jul-23");
        set.add("Aug-23");
        set.add("Sep-23");
        set.add("Oct-23");
        set.add("Nov-23");
        set.add("Dec-23");
        set.stream().sorted();
        set.forEach(System.out::println);
    }
}

package org.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
//    public static final String REGEX = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
    public static final String REGEX = "(.*\\.(jpg|png|gif|bmp)$)";

    public static void main(String[] args) {
        getPictureBySuffix("adsb.jpg");
        getPictureBySuffix("Acknowledgement For.pdf.m.jpg.a");
        getPictureBySuffix(" adsb.jpg");
        getPictureBySuffix(".jpg");
        getPictureBySuffix("a.sb.jpg");
        getPictureBySuffix("ad++sb.jpg");
    }

    public static void getPictureBySuffix(String s){
        Pattern compile = Pattern.compile(REGEX);
        Matcher matcher = compile.matcher(s);
        boolean matches = matcher.matches();
        System.out.println(matches);
    }
}

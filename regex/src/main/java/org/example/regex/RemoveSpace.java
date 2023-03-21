package org.example.regex;

public class RemoveSpace {
    public static void main(String[] args) {
        String s = " Tower  31 ";
        String trim = s.trim();
        System.out.println(trim);
        String s1 = trim.replaceAll("\\s{2,}", " ");
        System.out.println(s1);
    }

}

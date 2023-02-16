package org.example.array;

public class Util {

    public static void printArray(int[][] arr) {
        for (int[] interval : arr) {
            String s = "[";
            for (int i : interval) {
                s += i+", ";
            }
            System.out.println(s.substring(0,s.length()-2)+"]");
        }
    }
}

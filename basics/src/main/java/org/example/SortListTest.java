package org.example;

import java.util.*;

public class SortListTest {

    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> mapH = new LinkedHashMap<>();

        mapH.put("title", "");
        mapH.put("04 / C2-#1", "04 / C2-#1");
        mapH.put("04 / C2-#2", "04 / C2-#2");
        mapH.put("04 / C2-#3", "04 / C2-#3");
        mapH.put("04 / C2-#4", "04 / C2-#4");
        mapH.put("04 / C2-#5", "04 / C2-#5");
        mapH.put("04 / C2-#6", "04 / C2-#6");
        mapH.put("04 / C2-#7", "04 / C2-#7");
        mapH.put("04 / C2-#8", "04 / C2-#8");



        Map<String, Object> mapC = new LinkedHashMap<>();
        mapC.put("title", "04");

        Map<String, Object> mapB = new HashMap<>();
        mapB.put("a", "WIP");
        mapB.put("b", "#33bbaa");
        mapC.put("04 / C2-#1", mapB);
        mapC.put("04 / C2-#2", mapB);
        mapC.put("04 / C2-#3", mapB);
        mapC.put("04 / C2-#4", mapB);
        mapC.put("04 / C2-#5", mapB);
        mapC.put("04 / C2-#6", mapB);
        mapC.put("04 / C2-#7", mapB);
        mapC.put("04 / C2-#8", mapB);


        list.add(mapC);
        list.add(mapH);

        for (Map<String, Object> stringObjectMap : list) {
            System.out.println("{");
            stringObjectMap.forEach((k,v)->{
                System.out.println(k+":"+v);
            });
            System.out.println("}");
        }


    }
}

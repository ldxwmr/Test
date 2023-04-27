package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        map.put("a", list);
        map.put("b", null);
        map.forEach((k,v)->{
            System.out.println(k+","+v);
        });
        List<String> list1 = new ArrayList<>();
        list1.add("2");
        Map<String, List<String>> map1 = new HashMap<>();
        map1.put("b",list1);
        map1.putAll(map);
        Map<String, List<String>> map2 = map;
        map.clear();
        map = null;
        System.out.println(map);

    }
}

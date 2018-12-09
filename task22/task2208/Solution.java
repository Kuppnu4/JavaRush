package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", null);//"Ivanov");
        map.put("country", null);// "Ukraine");
        map.put("city", null);// "Kiev");
        map.put("age", null);
        getQuery(map);

    }
    public static String getQuery(Map<String, String> params) {

        if (params == null) return "";

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> m : params.entrySet()){
            if (m.getValue() == null) continue;
            sb.append(String.format("%s = '%s' and ", m.getKey(), m.getValue()));
        }

        if (sb.toString().isEmpty()) return "";

        String s = sb.substring(0, sb.lastIndexOf(" and"));
        //System.out.println(s);
        return s;
    }
}

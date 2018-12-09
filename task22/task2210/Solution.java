package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter)
    {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }
        String[] arr = new String[list.size()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }

        return arr;
    }
}

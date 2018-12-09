package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.String.valueOf;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        String s;
        try(BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br2 = new BufferedReader(new FileReader(br1.readLine()))) {
            s = br2.readLine().trim();
        }
        String[] slova = s.split(" ");
        StringBuilder result = getLine(slova);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) { //C:\Users\Aleksandr\Desktop\javaFile.txt
        //Нью-Йорк Амстердам Вена Мельбурн Киев

        if(words == null || words.length == 0) return new StringBuilder();

        StringBuilder sb = new StringBuilder();

        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);
        String stroka1 =  words[0].substring(1,2).toLowerCase();

        String stroka2 = words[0]. substring(words[0].length() - 1).toLowerCase();
        String slovo1; String slovo2;

        for (int i = 0; i < words.length; i++){

            for (int j = 0; j < words.length; j++){
                if (list.contains(words[j])) continue;

                slovo1 = words[j].substring(0, 1).toLowerCase();
                slovo2 = words[j].substring(words[j].length() - 1).toLowerCase();


                if (stroka1.equals(slovo2)) {
                    list.add(0, words[j]);
                    stroka1 = slovo1;
                    continue;
                }

                if (stroka2.equals(slovo1)){
                    list.add(list.size(), words[j]);
                    stroka2 = slovo2;
                    continue;
                }
            }
        }

        for (int i = 0; i < words.length; i++){
            if (list.contains(words[i])) continue;
            list.add(list.size(), words[i]);
        }

        for (String l : list){
            sb.append(l + " ");
        }

        return sb;
    }
}


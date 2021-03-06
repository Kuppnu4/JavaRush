package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br2 = new BufferedReader(new FileReader(br.readLine()))){ //C:\Users\Aleksandr\Desktop\javaFile.txt
            StringBuilder strB = new StringBuilder();
            while (br2.ready())
                strB.append(br2.readLine() + " ");

            String[] strArr = strB.toString().split(" ");

            String forCheck;
            for (int i = 0; i < strArr.length; i++){
                if (strArr[i] == "") continue;
                for (int j = i+1; j < strArr.length; j++){
                    if (strArr[j] == "") continue;
                    forCheck = new StringBuilder(strArr[j]).reverse().toString();
                    if (forCheck.equals(strArr[i])) {
                        Pair pair = new Pair();
                        pair.first = strArr[i]; strArr[i] = "";
                        pair.second = strArr[j]; strArr[j] = "";
                        result.add(pair);
                        break;
                    }

                }
            }
            for (Pair p : result){
                System.out.println(p.toString());
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

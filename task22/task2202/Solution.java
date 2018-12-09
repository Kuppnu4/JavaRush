package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        String str = "";
        String[] strSplit = string.split(" ");
        try {
            str =  strSplit[1] + " " + strSplit[2] + " " + strSplit[3] + " " + strSplit[4];
        }catch (RuntimeException e){
            if (strSplit.length < 6)throw new TooShortStringException();
        }
        return str;
    }

    public static class TooShortStringException extends RuntimeException{
        TooShortStringException (){
            super();
        }
    }
}

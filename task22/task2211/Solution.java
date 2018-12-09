package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream(args[0]);
             FileOutputStream out = new FileOutputStream(args [1])){

            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            String s = new String(buffer, "Windows-1251");

            buffer = s.getBytes("UTF-8");
            out.write(buffer);
        }
    }
}

package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution a = new Solution(); a.innerClasses[0] = new InnerClass(); a.innerClasses[1] = new InnerClass();
        Solution b = new Solution(); b.innerClasses[0] = new InnerClass(); b.innerClasses[1] = new InnerClass();
        Solution[] arr = {a, b};

        return arr;
    }

    public static void main(String[] args) {

    }
}

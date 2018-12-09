package com.javarush.task.task21.task2109;

import java.util.Objects;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        /*protected A clone() throws CloneNotSupportedException {
            return (A)super.clone();
        }*/

        public int hashCode(){
            return Objects.hash(i, j);
        }

        public boolean equals(Object o){
            if (o == this) return true;
            if (o == null) return false;
            if (!(o instanceof A)) return false;

            A a = (A) o;
            return Objects.equals(i, a.i)&&Objects.equals(j, a.j);
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B implements Cloneable{
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        protected C clone() throws CloneNotSupportedException {
            C c = new  C(getI(), getJ(), getName());
            return c;
        }
    }

    public static void main(String[] args) {

    }
}

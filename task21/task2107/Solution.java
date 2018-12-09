package com.javarush.task.task21.task2107;

import javax.jws.soap.SOAPBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }

    }

    protected Solution clone() throws CloneNotSupportedException {
        Solution s = new Solution();
        users.forEach((k, v) -> {s.users.put(k, v);});
        return s;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        protected User clone() throws CloneNotSupportedException {
            return (User)super.clone();
        }

        public int hashCode(){
            return Objects.hash(age, name);
        }

        public boolean equals(Object o){
            if (o == this) return true;
            if (o == null) return false;
            if (!(o instanceof User)) return false;

            User u = (User) o;
            return Objects.equals(age, u.age) && Objects.equals(name, u.name);
        }
    }
}

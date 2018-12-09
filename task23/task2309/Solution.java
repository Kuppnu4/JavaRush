package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
*/
public class Solution {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public List<User> getUsers() throws IllegalAccessException, InstantiationException {
        AbstractDbSelectExecutor abs = new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }
        };
        return abs.execute();
    }

    public List<Location> getLocations() throws IllegalAccessException, InstantiationException {
        AbstractDbSelectExecutor abs = new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        };
        return abs.execute();
    }

    public List<Subject> getSubjects(){
        AbstractDbSelectExecutor abs = new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }
        };
        return abs.execute();
    }

    public List<Server> getServers(){
        AbstractDbSelectExecutor abs = new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }
        };
        return abs.execute();
    }

    public List<Subscription> getSubscriptions(){
        AbstractDbSelectExecutor abs = new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }
        };
        return abs.execute();
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}

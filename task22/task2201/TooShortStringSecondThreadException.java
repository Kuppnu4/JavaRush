package com.javarush.task.task22.task2201;

public class TooShortStringSecondThreadException extends RuntimeException {
    TooShortStringSecondThreadException(StringIndexOutOfBoundsException e){
        super(e);
    }
}

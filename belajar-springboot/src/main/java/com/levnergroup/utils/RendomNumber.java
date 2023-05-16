package com.levnergroup.utils;

public class RendomNumber {
    public static long getRandom(long min, long max){
        long number = min + (long) (Math.random()* (max-min));
        return number;
    }
    
}

package com.design.singleton;

/**
 * @author Prasenjit Kumar Das
 */
//Eager Initialization
public class SingletonEager {
    private static SingletonEager instance = new SingletonEager();

    private SingletonEager(){}

    public static SingletonEager getInstance(){
        return instance;
    }
}

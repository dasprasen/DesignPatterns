package com.design.singleton;

import java.io.Serializable;

/**
 * @author Prasenjit Kumar Das
 */
//Lazy Initialization
public class SingletonLazy implements Serializable {
    private static SingletonLazy instance;

    private SingletonLazy(){}

    public static SingletonLazy getInstance(){
        if(instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }
}

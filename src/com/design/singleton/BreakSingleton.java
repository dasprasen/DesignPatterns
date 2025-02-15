package com.design.singleton;

import java.lang.reflect.Constructor;

/**
 * @author Prasenjit Kumar Das
 */
public class BreakSingleton {
    public static void main(String[] args) {
        SingletonLazy instance1 = SingletonLazy.getInstance();
        SingletonLazy instance2 = null;

        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum1 = null;

        try {
            Constructor[] constructors = SingletonEnum.class.getDeclaredConstructors();
            for(Constructor constructor : constructors) {
                constructor.setAccessible(true);
                singletonEnum1 = (SingletonEnum) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(singletonEnum.hashCode());
        System.out.println(singletonEnum1.hashCode());

    }
}

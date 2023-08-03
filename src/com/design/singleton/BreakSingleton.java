package com.design.singleton;

import java.lang.reflect.Constructor;

/**
 * @author Prasenjit Kumar Das
 */
public class BreakSingleton {
    public static void main(String[] args) {
        SingletonLazy instance1 = SingletonLazy.getInstance();
        SingletonLazy instance2 = null;

        try {
            Constructor[] constructors = SingletonLazy.class.getDeclaredConstructors();
            for(Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instance2 = (SingletonLazy) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

    }
}

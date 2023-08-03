package com.design.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonMain {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, CloneNotSupportedException {
	// write your code here
//        SingletonLazy instance = SingletonLazy.getInstance();
//        System.out.println(instance);
//
//        SingletonLazy instance1 = SingletonLazy.getInstance();
//        System.out.println(instance1);
//
//        SingletonEager instance2 = SingletonEager.getInstance();
//        System.out.println(instance2);
//
//        SingletonEager instance3 = SingletonEager.getInstance();
//        System.out.println(instance3);
//
//        SingletonSynchronizedMethod instance4 = SingletonSynchronizedMethod.getInstance();
//        System.out.println(instance4);
//
//        SingletonSynchronizedMethod instance5 = SingletonSynchronizedMethod.getInstance();
//        System.out.println(instance5);
//
//        SingletonSynchronizedBlock instance6 = SingletonSynchronizedBlock.getInstance();
//        System.out.println(instance6);
//
//        SingletonSynchronizedBlock instance7 = SingletonSynchronizedBlock.getInstance();
//        System.out.println(instance7);

        SingletonSynchronizedBlock sb = SingletonSynchronizedBlock.getInstance();
//        SingletonSynchronizedBlock sb1 = null;
//        Constructor [] constructors = SingletonSynchronizedBlock.class.getDeclaredConstructors();
//        for(Constructor constructor : constructors) {
//            constructor.setAccessible(true);
//            sb1 = (SingletonSynchronizedBlock) constructor.newInstance();
//            break;
//        }
        SingletonSynchronizedBlock sb1 = (SingletonSynchronizedBlock) sb.clone();

        System.out.println("instance1.hashCode():- " + sb.hashCode());
        System.out.println("instance2.hashCode():- " + sb1.hashCode());
    }
}

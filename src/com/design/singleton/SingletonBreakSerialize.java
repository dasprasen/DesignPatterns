package com.design.singleton;

import java.io.*;

/**
 * @author Prasenjit Kumar Das
 */
public class SingletonBreakSerialize {
    public static void main(String[] args) {
        try {
            SingletonLazy instance1 = SingletonLazy.getInstance();
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
            out.writeObject(instance1);
            out.close();

            ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
            SingletonLazy instance2 = (SingletonLazy) in.readObject();
            in.close();

            System.out.println(instance1.hashCode());
            System.out.println(instance2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

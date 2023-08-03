package com.design.singleton;

/**
 * @author Prasenjit Kumar Das
 */

class SuperClass implements Cloneable
{
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

public class SingletonSynchronizedBlock extends SuperClass {
    private static SingletonSynchronizedBlock instance;

    private SingletonSynchronizedBlock(){}

    public static SingletonSynchronizedBlock getInstance(){
        if(instance == null){
            synchronized (SingletonSynchronizedBlock.class) {
                if (instance == null) {
                    instance = new SingletonSynchronizedBlock();
                }
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }
}

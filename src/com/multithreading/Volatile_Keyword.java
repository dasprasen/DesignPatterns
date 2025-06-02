package com.multithreading;

class SharedResource {
    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

// we can use flag field as volatile or we can make getter/setter method as synchronized
public class Volatile_Keyword {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        new Thread(() ->{
            System.out.println("Thread 1 started");
            try {
                System.out.println("Thread 1 logic started");
                Thread.sleep(1000);
                System.out.println("Thread 1 completed");
                sharedResource.setFlag(true);
                System.out.println("Flag set by thread 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println("Thread 2 started");
            while (!sharedResource.isFlag()) {
                // it will run until flag is true
            }
            System.out.println("thread 2 completed");
        }).start();

    }
}

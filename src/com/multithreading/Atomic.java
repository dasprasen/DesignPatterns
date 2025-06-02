package com.multithreading;

import java.util.concurrent.atomic.AtomicInteger;


// Atomic class approach will be faster than synchronized approach since synchronized is based on locking approach but
// atomic classes are not based on that, it is leveraging hardware support to perform the operation.
class SharedCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public int getCount() {
        return count.get();
    }

    public void increment() {
        count.incrementAndGet();
    }
}

public class Atomic {
    public static void main(String[] args) {
        SharedCounter counter  = new SharedCounter();

        new Thread(() -> {
            System.out.println("thread 1 started");
            for (int i=0;i<50000;i++) {
                counter.increment();
            }
            System.out.println("thread 1 completed");
        }).start();

        new Thread(() -> {
            System.out.println("thread 2 started");
            for (int i=0;i<50000;i++) {
                counter.increment();
            }
            System.out.println("thread 2 completed");
        }).start();

        try {
            Thread.sleep(4000);
            System.out.println("final count: " + counter.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

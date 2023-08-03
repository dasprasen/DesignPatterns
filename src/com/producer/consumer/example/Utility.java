package com.producer.consumer.example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Prasenjit Kumar Das
 */
public class Utility {

    Queue<Integer> queue = new LinkedList<>();
    int maxSize = 4;
    public synchronized void set(Integer i) throws InterruptedException {
        if (queue.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(i);
        notifyAll();
        Thread.sleep(1000);
    }

    public synchronized int get() throws InterruptedException {
        if(queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int val = queue.remove();
        notifyAll();
        Thread.sleep(1000);
        return val;
    }
}

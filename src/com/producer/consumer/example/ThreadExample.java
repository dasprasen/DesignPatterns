package com.producer.consumer.example;

// Java program to implement solution of producer
// consumer problem.

import java.util.LinkedList;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {

        final ProducerConsumer producerConsumer = new ProducerConsumer();

        // Create producer thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    producerConsumer.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    producerConsumer.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();
    }
}


package com.producer.consumer.example;

/**
 * @author Prasenjit Kumar Das
 */
public class Main {
    public static void main(String[] args){
        Utility utility = new Utility();
        Producer producer = new Producer(utility);
        Consumer consumer = new Consumer(utility);

        producer.run();
        consumer.run();
    }
}

package com.producer.consumer.example;

/**
 * @author Prasenjit Kumar Das
 */
public class Producer implements Runnable {

    private Utility utility;

    Producer(Utility utility){
        this.utility = utility;
        Thread producer = new Thread(this, "Producer");
        producer.start();
    }

    @Override
    public void run() {
        int i=0;
        while(true) {
            System.out.println("Produced: "+i);
            try {
                utility.set(i++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

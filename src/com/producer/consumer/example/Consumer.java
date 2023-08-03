package com.producer.consumer.example;

/**
 * @author Prasenjit Kumar Das
 */
public class Consumer implements Runnable {

    private Utility utility;

    Consumer(Utility utility){
        this.utility = utility;
        Thread consumer = new Thread(this, "Consumer");
        consumer.start();
    }

    @Override
    public void run() {
        while(true) {
            int res = 0;
            try {
                res = utility.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumed: "+res);
        }
    }
}

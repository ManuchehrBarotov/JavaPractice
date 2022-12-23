package com.PatternsAndMultithreding.InterruptPackage;

import java.util.Random;

public class Interrupt {

    public static void main(String[] args) {
        Random random = new Random();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<1_000_000_000;i++){

                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Thread was is interrupted in counter is :"+i);
                        break;
                    }
                    double rand = random.nextDouble(1000);
                   System.out.println("sin : "+(int)rand+" is "+  Math.sin(rand));
                }
            }
        });


        thread.start();
        try {
            Thread.sleep(200);
            thread.interrupt();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}

package com.PatternsAndMultithreding.CountDownLatchMulti;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        ProducerConsumer consumer = new ProducerConsumer(countDownLatch);
        List<Thread> threadList = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0; i<5;i++){
            executorService.submit(consumer);

        }

        executorService.shutdown();
        countDownLatch.await();
        System.out.println("All Threads has been finished!!!");

        System.out.println("Array is : "+consumer.getQueueSize());


    }
}

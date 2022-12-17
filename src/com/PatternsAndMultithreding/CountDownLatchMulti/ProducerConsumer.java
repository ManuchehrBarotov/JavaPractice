package com.PatternsAndMultithreding.CountDownLatchMulti;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer implements Runnable {

    private volatile Queue<Integer> queue = new ConcurrentLinkedQueue<>();

    private CountDownLatch countDownLatch;

    public ProducerConsumer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start working...");
        try {
//            Thread.sleep(2000);
            AtomicInteger atomicInteger = new AtomicInteger();
            for (int i = 0; i < 1000; i++) {
                queue.add(atomicInteger.incrementAndGet());
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.countDownLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Array size: " + queue.size());
        System.out.println(Thread.currentThread().getName() + " finished working...\n");
    }

    public int getQueueSize() {
        return this.queue.size();
    }
}

package com.PatternsAndMultithreding.ReentrantLock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task {

    Lock reentrantLock = new ReentrantLock();

    private volatile AtomicInteger counter = new AtomicInteger();

    public void incrementInFirstThread() {
        this.reentrantLock.lock();
        increment();
        this.reentrantLock.unlock();

    }

    public void incrementInSecondThread() {
        this.reentrantLock.lock();
        increment();
        this.reentrantLock.unlock();
    }

    public void incrementInThirdThread() {
        this.reentrantLock.lock();
        increment();
        this.reentrantLock.unlock();
    }


    private void increment() {
        for (int i = 0; i < 10000; i++) {
            counter.incrementAndGet();
        }
    }

    public void showCounter() {
        System.out.println("Counter is : " + this.counter);
    }
}

package com.PatternsAndMultithreding.DeadLockPackage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockRunner {


    public static void main(String[] args) {
        Account accountFirst = new Account();
        Account accountSecond = new Account();
        DeadLock deadLock = new DeadLock(accountFirst, accountSecond);
        Thread threadFirst = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.firstThread();
            }
        });

        Thread secondThread= new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.secondThread();
            }
        });


        threadFirst.start();
        secondThread.start();

        try {
            threadFirst.join();
            secondThread.join();
            deadLock.finished();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }


}

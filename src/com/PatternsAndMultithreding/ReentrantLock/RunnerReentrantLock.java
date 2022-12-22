package com.PatternsAndMultithreding.ReentrantLock;

public class RunnerReentrantLock {
    public static void main(String[] args) throws InterruptedException {

        Task task = new Task();

        Thread threadFirst =  new Thread(()->{
            task.incrementInFirstThread();
        });

        Thread threadSecond =  new Thread(()->{
            task.incrementInSecondThread();
        });

        Thread threadThird = new Thread(()->{
            task.incrementInThirdThread();
        });

        threadFirst.start();
        threadThird.start();
        threadSecond.start();


        threadFirst.join();
        threadThird.join();
        threadThird.join();

        task.showCounter();

    }
}

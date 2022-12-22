package com.PatternsAndMultithreding.semaphoreLesson;

import java.util.concurrent.Semaphore;

public class SemaphoreLes  implements Runnable{
    Semaphore semaphore;
    private int i;

    public SemaphoreLes(Semaphore semaphore) {
        this.semaphore = semaphore;
    }


    private void doWork() {
        synchronized (this) {
            i++;
            System.out.println( Thread.currentThread().getName()+"  incremented counter is: " +i);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            i--;
            System.out.println( Thread.currentThread().getName()+"  decremented counter is: " +i);
        }
    }


    public void work(){
        try {
            this.semaphore.acquire();
            doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            this.semaphore.release();
        }


    }

    @Override
    public void run() {
        work();
    }
}

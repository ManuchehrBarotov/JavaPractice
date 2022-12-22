package com.PatternsAndMultithreding.semaphoreLesson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreRunner {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        SemaphoreLes semaphoreLes = new SemaphoreLes(semaphore);

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for(int i=0;i<100;i++){
            executorService.submit(semaphoreLes);
        }
        executorService.shutdown();

    }
}

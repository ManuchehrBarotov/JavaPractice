package com.PatternsAndMultithreding.ProducerConsumerMultiThread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    private Queue<Integer> arrayCapacity;
    private final Object monitor;

    private final int SIZE = 10;

    public ProducerConsumer() {
        this.monitor = new Object();
        this.arrayCapacity = new LinkedList<>();
    }


    public void consumer() {
        while (true) {
            synchronized (monitor) {
                while (arrayCapacity.size() == 0) {
                    try {
                        this.monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int size = arrayCapacity.poll();
                System.out.println("deleted : " + size);
                this.monitor.notifyAll();
            }
        }
    }


    public void producer() {
        int counter = 0;
        while (true) {
            synchronized (monitor) {
                while (arrayCapacity.size() == SIZE) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                arrayCapacity.offer(counter++);
                System.out.println("added : "+counter);
                this.monitor.notifyAll();
            }
        }
    }

}

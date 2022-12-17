package com.PatternsAndMultithreding.ProducerConsumerMultiThread;

public class RunnerProducerConsumer{
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread threadProducer = new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.producer();
            }
        });
        Thread threadConsumer = new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.consumer();
            }
        });

        threadProducer.start();
        threadConsumer.start();


        try {
            threadConsumer.join();
            threadProducer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

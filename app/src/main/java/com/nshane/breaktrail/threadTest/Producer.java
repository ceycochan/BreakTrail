package com.nshane.breaktrail.threadTest;

import java.util.Queue;
import java.util.Random;

/**
 * Created by bryan on 2018-8-22.
 */

public class Producer implements Runnable {

    Queue buffer;
    int maxSize;

    public Producer(Queue buffer, int maxSize) {
        this.buffer = buffer;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while(true){
            synchronized (buffer){
                while (buffer.size()==maxSize){
                    System.out.println("队列已满，生产者线程暂停"+buffer.size());

                    try {
                        buffer.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Random random  = new Random();
                int i = random.nextInt();

                System.out.println("生产价值："+i+"-----size"+buffer.size());

                buffer.add(i);
                buffer.notifyAll();


            }
        }

    }
}

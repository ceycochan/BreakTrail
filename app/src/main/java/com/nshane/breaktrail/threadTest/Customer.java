package com.nshane.breaktrail.threadTest;

import java.util.Queue;

/**
 * Created by bryan on 2018-8-22.
 */

public class Customer implements Runnable {
    Queue buffer;
    int maxSize;

    public Customer(Queue buffer, int maxSize) {
        this.buffer = buffer;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    System.out.println("队列已空,消费者线程暂停." + buffer.size());
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println("消费价值 : " + buffer.remove() + "-------size" + buffer.size());
                buffer.notifyAll();
            }
        }
    }

}

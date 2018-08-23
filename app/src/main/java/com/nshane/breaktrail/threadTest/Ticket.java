package com.nshane.breaktrail.threadTest;

/**
 * Created by bryan on 2018-8-22.
 */

public class Ticket implements Runnable {

    String name;

    private int ticket = 100;

    Object object = new Object();


    public Ticket(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(true){

            //同步代码块
            synchronized (object){
                   if (ticket>0){
                       try {
                           Thread.sleep(20);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }

                       System.out.println(Thread.currentThread().getName()+"......"+ticket--+"......");

//                       LogUtil.d("cg",Thread.currentThread().getName()+"......"+ticket--+"......");
                   }
            }
            //同步代码块

        }
    }
}

package com.nshane.breaktrail.threadTest;

/**
 * Created by bryan on 2018-8-23.
 */

public class StopThread extends Thread {

    public static boolean isDestroy = false;

    private String avatar;

    public StopThread(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public void run() {
        int i = 0;
        while (!isDestroy) {
            i++;
            System.out.println("停止线程：" + i);
        }
    }
}

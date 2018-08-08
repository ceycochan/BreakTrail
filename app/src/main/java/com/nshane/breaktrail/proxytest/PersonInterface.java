package com.nshane.breaktrail.proxytest;

/**
 * Created by bryan on 2018-8-8.
 */


// 顶层接口
//目标对象实现的接口
public interface PersonInterface {
    void execute();

    void sayHello(String content, int age);

    void sayGoodbye(boolean seeAgain, double time);
}

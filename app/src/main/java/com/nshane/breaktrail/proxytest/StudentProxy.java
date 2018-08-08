package com.nshane.breaktrail.proxytest;

import com.nshane.breaktrail.config.Constants;
import com.nshane.breaktrail.utils.LogUtil;

/**
 * Created by bryan on 2018-8-8.
 */


/**
 * 静态代理类:
 *
 * 实现与目标对象相同的接口, 并维护一个代理对象,
 */

public class StudentProxy implements PersonInterface {

    private PersonInterface personInterface;

    public StudentProxy(PersonInterface businessInterface) {
        this.personInterface = businessInterface;
    }

    @Override
    public void execute() {
        LogUtil.d(Constants.GENERAL,"业务执行前...");
        personInterface.execute();
        LogUtil.d(Constants.GENERAL,"业务执行后...");

    }

    @Override
    public void sayHello(String content, int age) {
        LogUtil.d(Constants.GENERAL,"StudentProxy sayHello begin");
        personInterface.sayHello(content,age);
        LogUtil.d(Constants.GENERAL,"StudentProxy sayHello end");
    }

    @Override
    public void sayGoodbye(boolean seeAgain, double time) {
        LogUtil.d(Constants.GENERAL,"StudentProxy sayGoodbye begin");
        personInterface.sayGoodbye(seeAgain,time);
        LogUtil.d(Constants.GENERAL,"StudentProxy sayGoodbye end");
    }
}

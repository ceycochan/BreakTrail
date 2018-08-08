package com.nshane.breaktrail.proxytest;

import com.nshane.breaktrail.config.Constants;
import com.nshane.breaktrail.utils.LogUtil;

/**
 * Created by bryan on 2018-8-8.
 */


// 目标对象实现类


// 即是目标对象,即被代理的类。
public class Student implements PersonInterface {
    @Override
    public void execute() {
        LogUtil.d(Constants.GENERAL, "执行业务逻辑");
    }

    @Override
    public void sayHello(String content, int age) {
        LogUtil.d(Constants.GENERAL, "say hello:" + content + age);
    }

    @Override
    public void sayGoodbye(boolean seeAgain, double time) {
        LogUtil.d(Constants.GENERAL, "say hello:" + time + seeAgain);
    }


}


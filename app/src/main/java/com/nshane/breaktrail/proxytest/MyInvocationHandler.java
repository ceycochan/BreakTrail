package com.nshane.breaktrail.proxytest;

import com.nshane.breaktrail.config.Constants;
import com.nshane.breaktrail.utils.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by bryan on 2018-8-8.
 */

public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }




    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        LogUtil.d(Constants.GENERAL,"MyInvocationHandler invoke begin");
        LogUtil.d(Constants.GENERAL,"proxy:"+proxy.getClass().getName());
        LogUtil.d(Constants.GENERAL,"method:"+method.getName());


        for (Object o:args){
            LogUtil.d(Constants.GENERAL,"arg:"+o);
        }

        // 使用反射调用  被代理的方法

        method.invoke(object,args);
        LogUtil.d(Constants.GENERAL,"MyInvocationHandler invoke end");
        return null;
    }
}

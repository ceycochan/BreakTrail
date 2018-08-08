package com.nshane.breaktrail.proxytest;

/**
 * Created by bryan on 2018-8-8.
 */


import com.nshane.breaktrail.config.Constants;
import com.nshane.breaktrail.utils.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理对象，无需实现任何接口
 */

public class ProxyFactory {

    private Object targetObject;


    public ProxyFactory(Object targetObject) {
        this.targetObject = targetObject;
    }


    public Object getProxyInstance() {
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                LogUtil.d(Constants.GENERAL, "前拦截 @ 动态代理");
                Object result = method.invoke(proxy, args);
                LogUtil.d(Constants.GENERAL, "后拦截 @ 动态代理");

                return result;
            }
        });
    }
}

package com.nshane.breaktrail.javatest;

/**
 * Created by bryan on 2018-7-30.
 */

public class B extends A {
    public static String staticStr = "B改写后的静态属性";
    public String nonStaticStr = "B改写后的非静态属性";
    public static void staticMethod(){
        System.out.println("B改写后的静态方法");
    }

    public void nonStaticMethod(){
        System.out.println("B改写后的非静态方法");
    }
}

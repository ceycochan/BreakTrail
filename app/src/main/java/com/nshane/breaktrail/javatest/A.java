package com.nshane.breaktrail.javatest;

/**
 * Created by bryan on 2018-7-30.
 */

public class A {

    public static String staticStr = "A静态属性";
    public String nonStaticStr = "A非静态属性";

    public static void staticMethod() {
        System.out.println("A静态方法");
    }

    public void nonStaticMethod() {
        System.out.println("A非静态方法");
    }

}

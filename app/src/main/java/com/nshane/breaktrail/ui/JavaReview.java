package com.nshane.breaktrail.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nshane.breaktrail.BaseActivity;
import com.nshane.breaktrail.R;
import com.nshane.breaktrail.config.Constants;
import com.nshane.breaktrail.javatest.A;
import com.nshane.breaktrail.javatest.B;
import com.nshane.breaktrail.javatest.C;
import com.nshane.breaktrail.objectequlastest.Car;
import com.nshane.breaktrail.proxytest.MyInvocationHandler;
import com.nshane.breaktrail.proxytest.PersonInterface;
import com.nshane.breaktrail.proxytest.Student;
import com.nshane.breaktrail.proxytest.StudentProxy;
import com.nshane.breaktrail.threadTest.Customer;
import com.nshane.breaktrail.threadTest.Producer;
import com.nshane.breaktrail.threadTest.Ticket;
import com.nshane.breaktrail.utils.LogUtil;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by bryan on 2018-6-25.
 */

public class JavaReview extends BaseActivity {


    public static String TAG = Constants.TAG1;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, JavaReview.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);

//        javaTest();

//        genericsTest();

//        staticExtendsTrail();

//        proxyTestStatic();

//        proxyTest();

//        objectConcerns();


        threadTriple();

    }


    private void javaTest() {
        com.nshane.breaktrail.bean.Person p1 = new com.nshane.breaktrail.bean.Person(20);
        com.nshane.breaktrail.bean.Person p2 = new com.nshane.breaktrail.bean.Person(16);

        LogUtil.d(TAG, "equals对比" + p1.equals(p2));
        LogUtil.d(TAG, "hashcode对比" + p1.hashCode() + "----" + p2.hashCode());


        String a = new String("fuck");
        String b = new String("fuck");

        LogUtil.d(TAG, "equals对比" + a.equals(b));
        LogUtil.d(TAG, "hashcode对比" + a.hashCode() + "----" + b.hashCode());


        int n1 = 6;
        int n2 = 100;


        try {
            LogUtil.d(TAG, "中".getBytes("UTF-8").length + "中-8");
            LogUtil.d(TAG, "中中".getBytes("UTF-8").length + "中中-8");

            LogUtil.d(TAG, "中".getBytes("GBK").length + "中gbk");
            LogUtil.d(TAG, "中中".getBytes("GBK").length + "中中gbk");

            LogUtil.d(TAG, "中".getBytes("Unicode").length + "中Unicode");
            LogUtil.d(TAG, "中中".getBytes("Unicode").length + "中中Unicode");


            LogUtil.d(TAG, "中".getBytes("UTF-8").length + "中-8");
            LogUtil.d(TAG, "中中".getBytes("UTF-8").length + "中中-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    private void genericsTest() {
        List<com.nshane.breaktrail.bean.Person> al = new ArrayList<>();

        al.add(new com.nshane.breaktrail.bean.Person("abc1"));
        al.add(new com.nshane.breaktrail.bean.Person("abc2"));
        al.add(new com.nshane.breaktrail.bean.Person("abc3"));

        List<com.nshane.breaktrail.bean.Student> al1 = new ArrayList<>();
        al1.add(new com.nshane.breaktrail.bean.Student("abc---1"));
        al1.add(new com.nshane.breaktrail.bean.Student("abc---2"));
        al1.add(new com.nshane.breaktrail.bean.Student("abc---3"));


        Iterator<? extends com.nshane.breaktrail.bean.Person> it = al.iterator();

        while (it.hasNext()) {
            LogUtil.d(TAG, it.next().getName());
        }


        List<? extends com.nshane.breaktrail.bean.Student> genList = new ArrayList<>();

//        genList.add(new Student("student1"));

    }


    // 静态变量extends测试
    private void staticExtendsTrail() {

        C c = new C();
        LogUtil.d(TAG, c.nonStaticStr + "FROM C");
        LogUtil.d(TAG, c.staticStr + "FROM C");
        c.nonStaticMethod();
        c.staticMethod();

        A a = new C();
        LogUtil.d(TAG, a.nonStaticStr);
        LogUtil.d(TAG, a.staticStr);
        a.nonStaticMethod();
        a.staticMethod();

        A b1 = new B();
        LogUtil.d(TAG, b1.nonStaticStr);
        LogUtil.d(TAG, b1.staticStr);
        b1.nonStaticMethod();
        b1.staticMethod();

    }


    private void proxyTestStatic() {
        // s为被代理的对象,即已有代码在不被更改的情况下，使用代理间接访问
        Student s = new Student();
        //创建代理对象
        StudentProxy proxy = new StudentProxy(s);
        //调用代理类对象的方法
        proxy.sayHello("fuck java", 20);
        System.out.println("**********");
        proxy.sayGoodbye(true, 100);

        Student s2 = new Student();


    }

    //https://blog.csdn.net/u011784767/article/details/78281384 静动态代理讲解

    private void proxyTest() {
        // 创建需要被代理的类
        Student s = new Student();
        // 生成代理类class文件，
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
        //获得加载被代理类的 类加载器
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        //指明被代理类实现的接口
        Class<?>[] interfaces = s.getClass().getInterfaces();
        //创建被代理类的委托类，之后想要调用被代理类的方法时，都会委托给这个类的invoke(Object proxy, Method method, Object[] args)方法

        //InvocationHandler是一个方法

        MyInvocationHandler h = new MyInvocationHandler(s);
        //生成代理类
        PersonInterface proxy = (PersonInterface) Proxy.newProxyInstance(loader, interfaces, h);
        //通过代理类调用  被代理的方法
        proxy.sayHello("fuck java", 20);
        proxy.sayGoodbye(true, 100);
        LogUtil.d(Constants.GENERAL, "end");
    }


    private void objectConcerns() {
        Car car1 = new Car(1);
        Car car2 = new Car(1);
        System.out.println(car1.equals(car2));
        System.out.println(car1 == car2);
    }


    //多线程测试1
    private void threadTest() {

        Ticket t = new Ticket("AV");

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        Thread t5 = new Thread(t);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    //多线程测试2 测试wait 和 notify
    private void threadTestSub() {

        //  图片下载
        final Object object = new Object();
        Thread download = new Thread() {
            @Override
            public void run() {
                System.out.println("开始下载图片");
                for (int i = 0; i < 101; i += 10) {
                    System.out.println("down" + i + "%");

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                System.out.println("图片下载成功");

                synchronized (object) {
                    object.notify(); // 唤起

                }

                System.out.println("开始下载附件");

                for (int i = 0; i < 101; i += 10) {
                    System.out.println("features down" + i + "%");

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("附件下载成功");
            }
        };


        //图片展示
        Thread show = new Thread() {
            @Override
            public void run() {
                synchronized (object) {


                    try {
                        object.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println("show：展示图片");
                    System.out.println("图片展示完毕");
                }
            }
        };


        download.start();
        show.start();

    }

    //muly
    private void threadTriple() {
        Queue buffer = new LinkedList<>();

        int maxSize = 10;

        Thread t1 = new Thread(new Producer(buffer, maxSize));

        Thread t2 = new Thread(new Customer(buffer, maxSize));

        t1.start();

        t2.start();

    }

    //线程关闭测试
    private void stopThread() {

        boolean isDestroy = false;

    }



}

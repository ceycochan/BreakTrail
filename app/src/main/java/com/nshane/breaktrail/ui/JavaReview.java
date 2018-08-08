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
import com.nshane.breaktrail.proxytest.Student;
import com.nshane.breaktrail.proxytest.StudentProxy;
import com.nshane.breaktrail.utils.LogUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        proxyTest();

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


    // 今天变量extends测试
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


    private void proxyTest() {
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




}

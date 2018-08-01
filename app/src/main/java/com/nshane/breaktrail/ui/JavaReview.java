package com.nshane.breaktrail.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nshane.breaktrail.BaseActivity;
import com.nshane.breaktrail.R;
import com.nshane.breaktrail.bean.Person;
import com.nshane.breaktrail.bean.Student;
import com.nshane.breaktrail.config.StaticConstants;
import com.nshane.breaktrail.javatest.A;
import com.nshane.breaktrail.javatest.B;
import com.nshane.breaktrail.javatest.C;
import com.nshane.breaktrail.utils.LogUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bryan on 2018-6-25.
 */

public class JavaReview extends BaseActivity {


    public static String TAG = StaticConstants.TAG1;

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

        staticExtendsTrail();

    }


    private void javaTest() {
        Person p1 = new Person(20);
        Person p2 = new Person(16);

        LogUtil.d(TAG, "equals对比" + p1.equals(p2));
        LogUtil.d(TAG, "hashcode对比" + p1.hashCode() + "----" + p2.hashCode());


        String a = new String("fuck");
        String b = new String("fuck");

        LogUtil.d(TAG, "equals对比" + a.equals(b));
        LogUtil.d(TAG, "hashcode对比" + a.hashCode() + "----" + b.hashCode());

        try {
            LogUtil.d(TAG, "中".getBytes("UTF-8").length + "中-8");
            LogUtil.d(TAG, "中中".getBytes("UTF-8").length + "中中-8");

            LogUtil.d(TAG, "中".getBytes("GBK").length + "中gbk");
            LogUtil.d(TAG, "中中".getBytes("GBK").length + "中中gbk");

            LogUtil.d(TAG, "中".getBytes("Unicode").length + "中Unicode");
            LogUtil.d(TAG, "中中".getBytes("Unicode").length + "中中Unicode");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    private void genericsTest() {
        List<Person> al = new ArrayList<>();

        al.add(new Person("abc1"));
        al.add(new Person("abc2"));
        al.add(new Person("abc3"));

        List<Student> al1 = new ArrayList<>();
        al1.add(new Student("abc---1"));
        al1.add(new Student("abc---2"));
        al1.add(new Student("abc---3"));


        Iterator<? extends Person> it = al.iterator();

        while (it.hasNext()) {
            LogUtil.d(TAG, it.next().getName());
        }


        List<? extends Student> genList = new ArrayList<>();

//        genList.add(new Student("student1"));

    }


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

}

package com.nshane.breaktrail;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bryan on 2018-6-20.
 */

public class CastActivity extends AppCompatActivity {


    private BroadCastReceiver mReceiver;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, CastActivity.class);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    // 选择在Activity生命周期方法中的onResume()中注册
    @Override
    protected void onResume() {
        super.onResume();
        // 1. 实例化BroadcastReceiver子类 &  IntentFilter
        mReceiver = new BroadCastReceiver();


        IntentFilter filter = new IntentFilter();

        // 2. 设置接收广播的类型
        filter.addAction("testPro");
        filter.setPriority(500);
        // 3. 动态注册：调用Context的registerReceiver（）方法
        registerReceiver(mReceiver, filter);


        Intent intent = new Intent();
        intent.setAction("testPro");
//        intent.setPackage("test1");
        sendBroadcast(intent);


    }

    // 注册广播后，要在相应位置记得销毁广播
    // 即在onPause() 中unregisterReceiver(mBroadcastReceiver)
    // 当此Activity实例化时，会动态将MyBroadcastReceiver注册到系统中
    // 当此Activity销毁时，动态注册的MyBroadcastReceiver将不再接收到相应的广播。

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }
}

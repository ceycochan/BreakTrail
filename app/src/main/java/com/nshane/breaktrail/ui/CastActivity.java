package com.nshane.breaktrail.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import com.nshane.breaktrail.MyBroadCastReceiver;
import com.nshane.breaktrail.R;

/**
 * Created by bryan on 2018-6-20.
 */

public class CastActivity extends AppCompatActivity {


    private MyBroadCastReceiver mReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private BroadcastReceiver mReceiver1;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, CastActivity.class);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast);

    }


    // 选择在Activity生命周期方法中的onResume()中注册
    @Override
    protected void onResume() {
        super.onResume();
//        initCast();
//        initBroad();


        initCastManager(false);
    }


    /**
     * 注册广播后，要在相应位置记得销毁广播
     * 即在onPause() 中unregisterReceiver(mBroadcastReceiver)
     * 当此Activity实例化时，会动态将MyBroadcastReceiver注册到系统中
     * 当此Activity销毁时，动态注册的MyBroadcastReceiver将不再接收到相应的广播。
     */
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);

        localBroadcastManager.unregisterReceiver(mReceiver1);
    }


    private void initBroad() {
        Intent intent = new Intent();
        intent.setAction("testPro");
        sendBroadcast(intent);
    }


    // 注册源生cast
    private void initCast() {
        // 1. 实例化BroadcastReceiver子类 &  IntentFilter
        mReceiver = new MyBroadCastReceiver();
        IntentFilter filter = new IntentFilter();
        // 2. 设置接收广播的类型
        filter.addAction("testPro");
        filter.setPriority(500);
        // 3. 动态注册：调用Context的registerReceiver（）方法
        registerReceiver(mReceiver, filter);

    }


    // 注册local broadcast manager
    public void initCastManager(boolean isUIThread) {

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        mReceiver1 = new MyBroadCastReceiver();
        IntentFilter mFilter = new IntentFilter("myAction");

        localBroadcastManager.registerReceiver(mReceiver1, mFilter);


        if (isUIThread) {
            // 主线程中发消息
            Intent intent = new Intent("myAction");
            intent.putExtra("data", "data fm UI Thread");
            localBroadcastManager.sendBroadcast(intent);
        } else {
            // 子线程中发消息

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent("myAction");
                    intent.putExtra("data", "data fm sub Thread");
                    localBroadcastManager.sendBroadcast(intent);
                }
            }).start();

        }

    }



}

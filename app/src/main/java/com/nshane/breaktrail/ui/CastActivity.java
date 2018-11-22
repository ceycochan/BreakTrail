package com.nshane.breaktrail.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nshane.breaktrail.BaseActivity;
import com.nshane.breaktrail.MyBroadCastReceiver;
import com.nshane.breaktrail.R;
import com.nshane.breaktrail.adapter.RVAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bryan on 2018-6-20.
 */

public class CastActivity extends BaseActivity implements View.OnClickListener, RVAdapter.OnItemClickListener {


    private MyBroadCastReceiver mReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private BroadcastReceiver mReceiver1;

    private RecyclerView mRV;
    private RVAdapter mAdapter;
    private List<String> mInfoList = new ArrayList<>();
    private Button mBtnCallback;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, CastActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast);
        initView();
    }


    private void initView() {
        mBtnCallback = findViewById(R.id.btn_callback);
//        mBtnCallback.setOnClickListener(this);

        mRV = findViewById(R.id.rv_test);
        mRV.setLayoutManager(new LinearLayoutManager(this));
        mInfoList = Arrays.asList("TRAIL PANEL", "Custom View Revision", "静态内部类的设计意图");
        mAdapter = new RVAdapter(this, mInfoList);
        mAdapter.setOnItemClickListener(this);
        mRV.setAdapter(mAdapter);
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
//        unregisterReceiver(mReceiver);

        localBroadcastManager.unregisterReceiver(mReceiver1);
    }


    private void initBroad() {
        Intent intent = new Intent();
        intent.setAction("testPro");
        sendBroadcast(intent);
    }


    // 注册源生CAST
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


    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_callback:
                // TODO: 2018-6-23 回调
//                CallBackData.doCallBack("callback");
//                finish();
                break;
            default:
                break;
        }

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "点击了：" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(this, "长击了：" + position, Toast.LENGTH_SHORT).show();
    }


//    public static class CallBackData {
//        private static LogActivityInterface mActivityInterface;
//
//        public static void setInterface(LogActivityInterface activityInterface) {
//            mActivityInterface = activityInterface;
//        }
//
//
//        public static void doCallBack(String str) {
//            mActivityInterface.name(str);
//        }
//    }


}

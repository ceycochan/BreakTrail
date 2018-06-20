package com.nshane.breaktrail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by bryan on 2018-6-20.
 */

public class BroadCastReceiver extends BroadcastReceiver {


    /**
     * 默认情况下, 广播接收器运行在UI线程,切勿进行耗时操作
     * 收到广播后会自动调用该方法
     *
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        Log.d("cg", "接收到了广播 动态" + action);
    }
}

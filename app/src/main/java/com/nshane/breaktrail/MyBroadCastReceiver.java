package com.nshane.breaktrail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by bryan on 2018-6-20.
 */

public class MyBroadCastReceiver extends BroadcastReceiver {

    /**
     * 默认情况下, 广播接收器运行在UI线程,切勿进行耗时操作,10
     * 收到广播后会自动调用该方法
     *
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d("cg", "接收到了广播 动态:::::" + action);


        String actionIntent = intent.getAction();

        if (actionIntent!=null && actionIntent.equalsIgnoreCase("myAction")){
            Log.d("cg","获取到的消息::::"+intent.getStringExtra("data"));

        }else {
            Log.d("cg","未获取到 actionIntent");
        }





    }
}

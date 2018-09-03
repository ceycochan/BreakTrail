package com.nshane.breaktrail.boardcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.nshane.breaktrail.activityComm.ActivityE;

/**
 * Created by bryan on 2018-8-31.
 */

public class MyReceiver extends BroadcastReceiver {

    private Message msg;

    //初始化要广播接收器传递给Activity的信息
    private String trans = "_fuck_u";

    @Override
    public void onReceive(Context context, Intent intent) {
        // 接受传递的信息

        Toast.makeText(context, "" + intent.getStringExtra("bitch_1"), Toast.LENGTH_SHORT).show();


        String transData = intent.getStringExtra("bitch_1");

        //调用Message接口方法
        msg.getMsg(trans);


        //在广播接收器中打开E页面---

        Intent intent2E = new Intent(context, ActivityE.class);
        /**
         * 针对于低版本API. 执行addFlags, 以防报错
         */
        intent2E.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent2E);

    }


    public interface Message {
        void getMsg(String str);
    }

    public void setMessage(Message msg) {
        this.msg = msg;
    }
}

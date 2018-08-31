package com.nshane.breaktrail.boardcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by bryan on 2018-8-31.
 */

public class MyReceiver extends BroadcastReceiver {

    private Message msg;

    @Override
    public void onReceive(Context context, Intent intent) {
        // 接受传递的信息

        Toast.makeText(context, "" + intent.getStringExtra("bitch_1"), Toast.LENGTH_SHORT).show();


//        msg.getMsg("world");

    }


    interface Message {
        public void getMsg(String str);
    }

    public void setMessage(Message msg) {
        this.msg = msg;
    }
}

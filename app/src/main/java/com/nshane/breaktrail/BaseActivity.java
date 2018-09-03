package com.nshane.breaktrail;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.nshane.breaktrail.config.Constants;
import com.nshane.breaktrail.utils.LogUtil;

/**
 * Created by Administrator on 2018/7/13 0013.
 */

public class BaseActivity extends AppCompatActivity {


    private String TAG = Constants.INITMODE;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);


        LogUtil.i(TAG, "*****onCreate()方法******");
        LogUtil.i(TAG, "onCreate：" + getClass().getSimpleName() + " TaskId: " + getTaskId() + " hasCode:" + this.hashCode());
        dumpTaskAffinity();


    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);


        LogUtil.i(TAG, "*****onNewIntent()方法*****");
        LogUtil.i(TAG, "onNewIntent：" + getClass().getSimpleName() + " TaskId: " + getTaskId() + " hasCode:" + this.hashCode());
        dumpTaskAffinity();
    }


    protected void dumpTaskAffinity() {
        try {
            ActivityInfo info = this.getPackageManager()
                    .getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            LogUtil.i(TAG, "taskAffinity:" + info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}




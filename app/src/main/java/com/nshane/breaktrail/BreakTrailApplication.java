package com.nshane.breaktrail;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by bryan on 2018-6-22.
 */

public class BreakTrailApplication extends Application {

    private static Context mContext;

    public static Context getInstance() {
        return mContext;
    }

    private static Application mApplication;

    public static Application getApplication() {
        return mApplication;
    }

    public BreakTrailApplication() {
        mContext = this;
        mApplication = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("cg", "app onCreate 运行 ");

    }
}

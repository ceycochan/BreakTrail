package com.nshane.breaktrail.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nshane.breaktrail.BaseActivity;
import com.nshane.breaktrail.R;

/**
 * Created by Administrator on 2018/7/13 0013.
 */

public class CustomViewRevision extends BaseActivity {


    public static void intentTo(Context context) {
        Intent intent = new Intent(context, CustomViewRevision.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_revision);

    }



}

package com.nshane.breaktrail.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nshane.breaktrail.R;

/**
 * Created by bryan on 2018-6-25.
 */

public class MyViewActivity extends Activity {


    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MyViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);

    }
}

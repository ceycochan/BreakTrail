package com.nshane.breaktrail.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nshane.breaktrail.BaseActivity;
import com.nshane.breaktrail.R;

/**
 * Created by Administrator on 2018/10/5 0005.
 */

public class StaticInnerActivity extends BaseActivity {


    public static void intentTo(Context context) {
        Intent intent = new Intent(context, StaticInnerActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inner_class);


        initTheCLass();
    }


    /**
     * 验证静态内部类的设计原理
     */

    private void initTheCLass() {



    }
}

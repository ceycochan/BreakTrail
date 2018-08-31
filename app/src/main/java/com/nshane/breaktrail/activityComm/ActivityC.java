package com.nshane.breaktrail.activityComm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nshane.breaktrail.BaseActivity;
import com.nshane.breaktrail.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bryan on 2018-8-31.
 */

public class ActivityC extends BaseActivity {


    @BindView(R.id.tv_value_c)
    TextView tvValueC;
    @BindView(R.id.btn_trans)
    Button btnTrans;


    private String msg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        ButterKnife.bind(this);


        msg = getIntent().getStringExtra("bitch_1");


        tvValueC.setText("收到B传递:" + msg);
        btnTrans.setText("转回B");

    }

    @OnClick({R.id.tv_value_c, R.id.btn_trans})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_value_c:


                break;
            case R.id.btn_trans:

                Intent intent = new Intent("com.action.broadcast");
                intent.putExtra("bitch_1", "hello");
                sendBroadcast(intent);
                finish();
                break;
        }
    }


}

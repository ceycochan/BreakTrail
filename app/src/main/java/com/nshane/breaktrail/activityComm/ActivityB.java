package com.nshane.breaktrail.activityComm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nshane.breaktrail.BaseActivity;
import com.nshane.breaktrail.R;
import com.nshane.breaktrail.boardcastreceiver.MyReceiver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bryan on 2018-8-30.
 */

public class ActivityB extends BaseActivity  {


    @BindView(R.id.tv_value_b)
    TextView tvValueB;
    @BindView(R.id.btn_trans)
    Button btnTrans;
    @BindView(R.id.btn_cast_trans)
    Button btnCastTrans;
    @BindView(R.id.tv_)
    TextView tv;

    private String data;

    private String bitch_1;

    private String str = "world";

    private MyReceiver receiver;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);
        data = getIntent().getStringExtra("data");
        tvValueB.setText(data);

        btnTrans.setText("trans2a");
        btnTrans.setAllCaps(false);


        //使用广播接收器从B--c
        receiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.action.broadcast");
        registerReceiver(receiver, intentFilter);


        bitch_1 = getIntent().getStringExtra("bitch_1");
        btnCastTrans.setText("跳转到C");

    }

    @OnClick({R.id.tv_value_b, R.id.btn_trans, R.id.btn_cast_trans})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_value_b:
                break;
            case R.id.btn_trans:

                Intent intent = getIntent();
                intent.putExtra("data", "185");
                setResult(RESULT_OK, intent);
                finish();
                break;

            case R.id.btn_cast_trans:


                Intent intentCast = new Intent(this, ActivityC.class);
                intentCast.putExtra("bitch_1", str);
                tv.setText(str);
                startActivity(intentCast);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}

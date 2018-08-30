package com.nshane.breaktrail.activityComm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nshane.breaktrail.BaseActivity;
import com.nshane.breaktrail.R;
import com.nshane.breaktrail.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bryan on 2018-8-30.
 */

public class ActivityA extends BaseActivity {


    @BindView(R.id.tv_value_a)
    TextView tvValueA;
    @BindView(R.id.btn_trans)
    Button btnTrans;


    private final int REQUESTCODE = 5;
    @BindView(R.id.tv_value_a_1)
    TextView tvValueA1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);

        LogUtil.d("cg", "启动了ActivityA");
        btnTrans.setText("trans2b");
        btnTrans.setAllCaps(false);

    }

    @OnClick({R.id.tv_value_a, R.id.btn_trans})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_value_a:
                break;
            case R.id.btn_trans:
                Intent intent = new Intent(this, ActivityB.class);
                intent.putExtra("data", "123");
                startActivityForResult(intent, REQUESTCODE);



                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        LogUtil.d("cg", "接收resultCode：" + resultCode);

        if (resultCode == RESULT_OK) {

            if (requestCode == REQUESTCODE) {

                tvValueA.setText("收到信息：" + data.getStringExtra("data"));

            }
        }
    }

}

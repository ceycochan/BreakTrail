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
 * Created by bryan on 2018-8-30.
 */

public class ActivityB extends BaseActivity {


    @BindView(R.id.tv_value_b)
    TextView tvValueB;
    @BindView(R.id.btn_trans)
    Button btnTrans;

    private String data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);
        data = getIntent().getStringExtra("data");
        tvValueB.setText(data);

        btnTrans.setText("trans2a");
        btnTrans.setAllCaps(false);


    }

    @OnClick({R.id.tv_value_b, R.id.btn_trans})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_value_b:
                break;
            case R.id.btn_trans:

                Intent intent = getIntent();
                intent.putExtra("data","185");
                setResult(RESULT_OK,intent);
                finish();
                break;
        }
    }
}

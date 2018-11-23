package com.nshane.breaktrail.activityComm;

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
 * Created by Administrator on 2018/11/23 0023.
 */

public class HuiWenActivity extends BaseActivity {


    @BindView(R.id.btn_huiwen_test)
    Button btnHuiwenTest;
    @BindView(R.id.tv_ori_data)
    TextView tvOriData;
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_huiwen);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn_huiwen_test, R.id.tv_ori_data, R.id.tv_result})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_huiwen_test:
                break;
            case R.id.tv_ori_data:
                break;
            case R.id.tv_result:
                break;
        }
    }
}

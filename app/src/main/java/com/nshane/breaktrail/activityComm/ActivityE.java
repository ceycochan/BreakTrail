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
 * Created by bryan on 2018-9-1.
 */

public class ActivityE extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_act_dialog)
    Button btnActDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e);
        ButterKnife.bind(this);





    }

    @OnClick({R.id.tv_title, R.id.btn_act_dialog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_title:
                break;
            case R.id.btn_act_dialog:
                break;
        }
    }
}

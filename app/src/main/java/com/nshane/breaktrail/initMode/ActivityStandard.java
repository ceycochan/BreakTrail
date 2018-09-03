package com.nshane.breaktrail.initMode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.nshane.breaktrail.BaseActivity;
import com.nshane.breaktrail.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bryan on 2018-9-3.
 */

public class ActivityStandard extends BaseActivity {

    @BindView(R.id.btn_standard)
    Button btnStandard;
    @BindView(R.id.btn_singleTop)
    Button btnSingleTop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_standard, R.id.btn_singleTop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_standard:

                startActivity(new Intent(this, ActivityStandard.class));
                break;
            case R.id.btn_singleTop:
                break;
        }
    }
}

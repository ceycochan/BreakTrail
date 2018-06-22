package com.nshane.breaktrail.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nshane.breaktrail.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button mBtnCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }


    private void initView() {
        mBtnCast = findViewById(R.id.btn_cast);
        mBtnCast.setOnClickListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_cast:

                CastActivity.startActivity(this);
                Log.d("cg", "点击了2nd");
                break;
            default:
                break;

        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }
}

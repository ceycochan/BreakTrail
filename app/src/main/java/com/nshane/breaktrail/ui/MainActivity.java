package com.nshane.breaktrail.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nshane.breaktrail.BaseActivity;
import com.nshane.breaktrail.R;
import com.nshane.breaktrail.interfaces.LogActivityInterface;
import com.nshane.breaktrail.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnClickListener, LogActivityInterface {



    @BindView(R.id.btn_cast)
    Button btnCast;
    @BindView(R.id.btn_digui)
    Button btnDigui;
    @BindView(R.id.btn_huiwen)
    Button btnHuiwen;


    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LogUtil.d(TAG, "onCreate执行");

    }


    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(TAG, "onStart执行");
    }

    private void initView() {
//        CastActivity.CallBackData.setInterface(this);

    }


    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(TAG, "onResume执行");

    }


    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d(TAG, "onPause执行");
    }


    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d(TAG, "onStop执行");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d(TAG, "onRestart执行");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        LogUtil.d(TAG, "onDestroy执行");
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

//        LogUtil.d(TAG, "onSaveInstanceState执行");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        LogUtil.d(TAG, "onSaveInstanceState执行");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        LogUtil.d(TAG, "onRestoreInstanceState执行");
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtil.d(TAG, "onConfigurationChanged执行");
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_cast:
                break;
            default:
                break;

        }
    }


    @Override
    public void name(String name) {
//        mBtnCast.setText(name);
        Toast.makeText(this, "回调到的name" + name, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        LogUtil.d(TAG, "onNewIntent执行");
    }


    @OnClick({R.id.btn_cast, R.id.btn_huiwen, R.id.btn_digui})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_cast:
                CastActivity.startActivity(this);
                Log.d("cg", "点击了2nd");
                break;
            case R.id.btn_huiwen:
                Intent h = new Intent("com.huiwen.activity");
                startActivity(h);
                break;
            case R.id.btn_digui:
                Intent d = new Intent("com.digui.activity");
                startActivity(d);
                break;


        }
    }

    @OnClick(R.id.btn_huiwen)
    public void onViewClicked() {
    }


}

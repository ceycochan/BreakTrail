package com.nshane.breaktrail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mTv2ndActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }


    private void initView(){
        mTv2ndActivity = findViewById(R.id.tv_subActivity);
        mTv2ndActivity.setOnClickListener(this);
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
            case R.id.tv_subActivity:

                CastActivity.startActivity(this);
                Log.d("cg", "点击了2nd");
                break;
            default:
                break;

        }
    }
}

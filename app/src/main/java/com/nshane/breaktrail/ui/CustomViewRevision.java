package com.nshane.breaktrail.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nshane.breaktrail.BaseActivity;
import com.nshane.breaktrail.R;
import com.nshane.breaktrail.bean.PieInfo;
import com.nshane.breaktrail.view.MyPieView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/13 0013.
 */

public class CustomViewRevision extends BaseActivity {


    private List<PieInfo> mList = new ArrayList<>();

    public static void intentTo(Context context) {
        Intent intent = new Intent(context, CustomViewRevision.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_revision);
        initPieData();

        MyPieView myPieView = new MyPieView(this);
        myPieView.setData(mList);
        myPieView.setStartAngle(0);

    }


    private void initPieData() {
        mList.add(new PieInfo("a", 6));
        mList.add(new PieInfo("b", 3));
        mList.add(new PieInfo("c", 1));
        mList.add(new PieInfo("d", 9));
        mList.add(new PieInfo("e", 10));
    }

}

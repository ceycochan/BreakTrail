package com.nshane.breaktrail.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.nshane.breaktrail.BaseActivity;
import com.nshane.breaktrail.R;
import com.nshane.breaktrail.utils.LocalUtils;

/**
 * Created by Administrator on 2018/11/22 0022.
 */

public class DiGuiActivity extends BaseActivity {


    private TextView mTv = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_digui);
        mTv = findViewById(R.id.tv_result);

        calculateStairWay();

    }


    private void calculateStairWay() {
        int stair = 4;
        int maxStep = 2;

        int resultDiGui = LocalUtils.countStair(stair);
//        mTv.setText("总共台阶数：" + stair + "，每次最多台阶数" + maxStep + "，产生" + resultDiGui + "种走法");
        mTv.setText("产生" + resultDiGui + "种走法");

    }

    //递归爬楼梯
    /**
     假设一个楼梯有 N 阶台阶，人每次最多可以跨 M 阶，求总共的爬楼梯方案数。

     例如楼梯总共有3个台阶，人每次最多跨2个台阶，也就是说人每次可以走1个，也可以走2个，但最多不会超过2个，那么楼梯总共有这么几种走法：
     */


    //非递归爬楼梯
    /**
     * 假设一个楼梯有 N 阶台阶，人每次最多可以跨 2 阶，求总共的爬楼梯方案数，要求不用递归实现

     先不写代码，自己计算当楼梯数为1、2、3、4、5时，对应的爬法有：1、2、3、5、8、13、21种。
     可以发现，随着楼梯数n的增加，爬法总数呈现斐波那契数列规律增加，即f（n） = f（n-1） + f（n-2）
     知道这个规律后，使用下面的循环即可实现：

    /**
     * 该种方法分析：当楼梯数为12345时，对应的爬法是1,2,3,5,8,13，21
     */







}

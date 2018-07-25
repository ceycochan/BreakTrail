package com.nshane.breaktrail.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.nshane.breaktrail.bean.PieInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/17 0017.
 */

/**
 * log：0718日不可用,表现为不显示
 */
public class MyPieView extends View {

    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000,
            0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    // initialize starting angle
    private float mStartAngle = 0;

    private List<PieInfo> mInfoList = new ArrayList<>();


    private int mWidth, mHeight;


    private Paint mPaint;


    public MyPieView(Context context) {
        super(context);
    }

    public MyPieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyPieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(10f);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true); //锯齿
        mPaint.setDither(true); // 抖动,绘制柔和
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mInfoList == null) return;

        float currentStartAngle = mStartAngle;
        canvas.translate(mWidth / 2, mHeight / 2);
        float r = (float) ((Math.min(mWidth, mHeight)) / 2 * 0.8);
        RectF rectF = new RectF(-r, -r, r, r);

        for (int i = 0; i < mInfoList.size(); i++) {
            PieInfo pie = mInfoList.get(i);
            mPaint.setColor(pie.getColor());
            canvas.drawArc(rectF, currentStartAngle, pie.getAngle(), true, mPaint);
            currentStartAngle += pie.getAngle();
        }


    }

    //custom method for user invoking
    public void setStartAngle(int startAngle) {
        mStartAngle = startAngle;
        invalidate();
    }


    public void setData(List<PieInfo> mPieList) {
        initData(mPieList);
        invalidate();
    }


    private void initData(List<PieInfo> mPieList) {
        if (mInfoList == null || mInfoList.size() == 0) return;

        float sumValue = 0;

        for (int i = 0; i < mPieList.size(); i++) {
            PieInfo pie = mPieList.get(i);

            sumValue += pie.getValue();

            int j = i % mColors.length;
            pie.setColor(mColors[j]);
        }


        float sumAngle = 0;
        for (int i = 0; i < mPieList.size(); i++) {
            PieInfo pie = mPieList.get(i);
            float percentage = pie.getValue() / sumValue;
            float angle = percentage * 360;

            pie.setPercentage(percentage);
            pie.setAngle(angle);

            sumAngle += angle;

            Log.d("dax", "current area angle :" + pie.getAngle() + "current total angle :" + sumAngle);
        }

    }

}

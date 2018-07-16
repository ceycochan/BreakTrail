package com.nshane.breaktrail.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/7/13 0013.
 */

public class MyRevisionView extends View {

    /**
     *在view所属activity中new时使用。
     *
     *例子: new MyRevisionView(this);
     * @param context
     */
    public MyRevisionView(Context context) {
        super(context);
    }


    /**
     * 在layout文件中使用时会调用
     *
     * 例子
     * <com.xxx.xxx.MyRevisionView
     *
     * @param context
     * @param attrs
     */
    public MyRevisionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRevisionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyRevisionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    /**
     * 测量View大小
     *
     *
     * 可在onMeasure 两个参数中取出宽高的相关依据
     *
     * widthMeasureSpec 和 heightMeasureSpec 这两个 int 类型的参数;
     * 毫无疑问他们是和宽高相关的， 但它们其实不是宽和高，
     * 而是由宽、高和各自方向上对应的测量模式来合成的一个值
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        setMeasuredDimension(); // 对View的宽高进行修改时调用
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);



        int widthSize = MeasureSpec.getSize(widthMeasureSpec);// 取出宽度的确切数值
        int widthMode = MeasureSpec.getMode(widthMeasureSpec); //  宽度的测量模式

        int heightSize = MeasureSpec.getSize(heightMeasureSpec); //高度的确切数值
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);  // 取出高度的测量模式


    }

    /**
     * 确定View大小
     *
     * 该方法在视图大小发生改变时调用
     * w,h 决定了视图的大小,  oldw & oldh 为上一次的宽高
     */

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }


    /**
     * 确定子View布局位置;
     *
     * 在自定义ViewGroup中会用到
     *
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);


    }



    /**
     * 实际绘制内容
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         *
         */
    }
}

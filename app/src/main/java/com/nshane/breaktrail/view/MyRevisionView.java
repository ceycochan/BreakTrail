package com.nshane.breaktrail.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/7/13 0013.
 */

public class MyRevisionView extends View {

    /**
     * 在view所属activity中new时使用。
     * <p>
     * 例子: new MyRevisionView(this);
     *
     * @param context
     */
    public MyRevisionView(Context context) {
        super(context);
    }


    /**
     * 在layout文件中使用时会调用
     * <p>
     * 例子
     * <com.xxx.xxx.MyRevisionView
     *
     * @param context
     * @param attrs
     */
    public MyRevisionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyRevisionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyRevisionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    /**
     * 画笔相关
     */

    // 初始化画笔
    private Paint mPaint;

    private Paint mPaint2;


    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE); // 画笔颜色
        mPaint.setStyle(Paint.Style.FILL); //画笔填充方式
        mPaint.setStrokeWidth(10f); //画笔宽度


        mPaint2 = new Paint();
        mPaint2.setColor(Color.RED);
        mPaint2.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint2.setStrokeWidth(5f);

    }


    /**
     * 测量View大小
     * 可在onMeasure 两个参数中取出宽高的相关依据
     * <p>
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
     * <p>
     * 该方法在视图大小发生改变时调用
     * w,h 决定了视图的大小,  oldw & oldh 为上一次的宽高
     * 记录当前View的宽高
     */

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);


    }


    /**
     * 确定子View布局;
     * <p>
     * 在自定义ViewGroup中会用到,无子View时无需调用
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
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 1. 初始过的画笔作为参数传入Canvas方法中。(一定不能忘记要在构造函数中初始化画笔)
         */

        canvas.drawPoint(50, 50, mPaint);

        canvas.drawPoints(new float[]{
                75, 75, 75, 90
        }, mPaint);


        canvas.drawLine(200, 200, 300, 300, mPaint);


        //绘制矩形
        RectF rect1 = new RectF(100, 100, 150, 150);
        canvas.drawRect(rect1, mPaint);

        //绘制圆角矩形
        RectF rect2 = new RectF(850, 50, 1350, 300);
        canvas.drawRoundRect(rect2, 25, 25, mPaint);

//        api21 (5.0)之后才有,故多圆角矩形用第一种方法绘制
//        canvas.drawRoundRect(850,850,1050,1050,30,30,mPaint);

        // 绘制圆弧
        RectF rectF = new RectF(50,400,450,600);
        mPaint2.setColor(Color.GRAY);
        canvas.drawRect(rectF,mPaint2);

        mPaint2.setColor(Color.RED);
        canvas.drawArc(rectF,0,90,false,mPaint2);


        RectF rectF2 = new RectF(50,650,450,850);
        mPaint2.setColor(Color.GRAY);
        canvas.drawRect(rectF2,mPaint2);

        mPaint2.setColor(Color.RED);
        canvas.drawArc(rectF2,0,90,true,mPaint2);

    }


}

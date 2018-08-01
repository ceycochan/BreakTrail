package com.nshane.breaktrail.view;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bryan on 2018-7-23.
 */

public class MyCollectionsViewRevision extends View {


    private Paint mPaint;


    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }


    public MyCollectionsViewRevision(Context context) {
        super(context);
    }

    public MyCollectionsViewRevision(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCollectionsViewRevision(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}

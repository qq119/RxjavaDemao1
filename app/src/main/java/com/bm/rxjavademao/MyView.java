package com.bm.rxjavademao;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hecl on 2016/11/1.
 */

public class MyView extends View {
    private int width;
    private int height;
    private Paint paint;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.GREEN);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMySize(100, widthMeasureSpec);
        height = getMySize(100, heightMeasureSpec);
    }

    private int getMySize(int defaultSize, int measureSpec) {
        int mySize = defaultSize;

        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch (mode) {
            case MeasureSpec.UNSPECIFIED: {//如果没有指定大小，就设置为默认大小
                mySize = defaultSize;
                break;
            }
            case MeasureSpec.AT_MOST: {//如果测量模式是最大取值为size
                //我们将大小取最大值,你也可以取其他值
                mySize = size;
                break;
            }
            case MeasureSpec.EXACTLY: {//如果是固定的大小，那就不要去改变它
                mySize = size;
                break;
            }
        }

        return mySize;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r = getMeasuredWidth() / 2;
        int centerX = (int) (getX() + r);
        int centerY = (int) (getY() + r);
        canvas.drawCircle(centerX, centerY, r, paint);

    }
}

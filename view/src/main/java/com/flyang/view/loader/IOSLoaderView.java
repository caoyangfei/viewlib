package com.flyang.view.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.flyang.view.R;


/**
 * @author caoyangfei
 * @ClassName IOSLoaderView
 * @date 2019/6/29
 * ------------- Description -------------
 * ios加载样式
 */
@SuppressLint("AppCompatCustomView")
public class IOSLoaderView extends ImageView {
    private float rotateDegrees;
    private int frameTime;
    private boolean needToUpdateView;
    private Runnable updateViewRunnable;

    public IOSLoaderView(Context context) {
        this(context, null);
    }

    public IOSLoaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setImageResource(R.drawable.ios_progress);
        frameTime = 1000 / 12;
        updateViewRunnable = new Runnable() {
            @Override
            public void run() {
                rotateDegrees += 30;
                rotateDegrees = rotateDegrees < 360 ? rotateDegrees : rotateDegrees - 360;
                invalidate();
                if (needToUpdateView) {
                    postDelayed(this, frameTime);
                }
            }
        };
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.rotate(rotateDegrees, getWidth() / 2, getHeight() / 2);
        super.onDraw(canvas);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        needToUpdateView = true;
        post(updateViewRunnable);
    }

    @Override
    protected void onDetachedFromWindow() {
        needToUpdateView = false;
        super.onDetachedFromWindow();
    }
}

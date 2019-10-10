package com.flyang.view.layout.refresh.around.drawable;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

/**
 * @author caoyangfei
 * @ClassName PaintDrawable
 * @date 2019/10/10
 * ------------- Description -------------
 * 画笔 Drawable
 */
public abstract class PaintDrawable extends Drawable {

    protected Paint mPaint = new Paint();

    protected PaintDrawable() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setColor(0xffaaaaaa);
    }

    public void setColor(int color) {
        mPaint.setColor(color);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

}

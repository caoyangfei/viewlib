package com.flyang.view.loader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

import com.flyang.view.R;
import com.flyang.view.loader.spinkit.SpriteFactory;
import com.flyang.view.loader.spinkit.Style;
import com.flyang.view.loader.spinkit.sprite.Sprite;


/**
 * @author 曹阳飞
 * @ClassName SpinKitLoadingView
 * @date 2017/11/17
 * ------------- Description -------------
 * 多样式动画加载控件
 */

public class SpinKitLoadingView extends ProgressBar {

    private Style mStyle;
    private int mColor;
    private Sprite mSprite;

    public SpinKitLoadingView(Context context) {
        this(context, null);
    }

    public SpinKitLoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpinKitLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, R.style.SpinKitLoadingView);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SpinKitLoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SpinKitLoadingView, defStyleAttr,
                defStyleRes);
        mStyle = Style.values()[a.getInt(R.styleable.SpinKitLoadingView_SpinKit_Style, 0)];
        mColor = a.getColor(R.styleable.SpinKitLoadingView_SpinKit_Color, Color.WHITE);
        a.recycle();
        init();
        setIndeterminate(true);
    }

    private void init() {
        Sprite sprite = SpriteFactory.create(mStyle);
        setIndeterminateDrawable(sprite);
    }

    @Override
    public void setIndeterminateDrawable(Drawable d) {
        if (!(d instanceof Sprite)) {
            throw new IllegalArgumentException("this d must be instanceof Sprite");
        }
        setIndeterminateDrawable((Sprite) d);
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    public void setIndeterminateDrawable(Sprite d) {
        super.setIndeterminateDrawable(d);
        mSprite = d;
        if (mSprite.getColor() == 0) {
            mSprite.setColor(mColor);
        }
        onSizeChanged(getWidth(), getHeight(), getWidth(), getHeight());
        if (getVisibility() == VISIBLE) {
            mSprite.start();
        }
    }

    @Override
    public Sprite getIndeterminateDrawable() {
        return mSprite;
    }

    @Override
    public void unscheduleDrawable(Drawable who) {
        super.unscheduleDrawable(who);
        if (who instanceof Sprite) {
            ((Sprite) who).stop();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus) {
            if (mSprite != null && getVisibility() == VISIBLE) {
                mSprite.start();
            }
        }
    }

    @Override
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        if (screenState == View.SCREEN_STATE_OFF) {
            if (mSprite != null) {
                mSprite.stop();
            }
        }
    }

}

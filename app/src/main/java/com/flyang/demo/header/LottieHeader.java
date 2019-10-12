package com.flyang.demo.header;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;

import com.airbnb.lottie.LottieAnimationView;
import com.flyang.demo.R;
import com.flyang.view.layout.refresh.constant.SpinnerStyle;
import com.flyang.view.layout.refresh.inter.RefreshHeader;
import com.flyang.view.layout.refresh.inter.RefreshKernel;
import com.flyang.view.layout.refresh.inter.RefreshLayout;
import com.flyang.view.layout.refresh.simple.SimpleComponent;


/**
 * @author caoyangfei
 * @ClassName LottieHeader
 * @date 2019/10/12
 * ------------- Description -------------
 * Lottie动画
 */
public class LottieHeader extends SimpleComponent implements RefreshHeader {


    LottieAnimationView mAnimationView;
    protected int mBackgroundColor = 0xff283645;
    protected Paint mBackPaint;
    protected RefreshKernel mKernel;

    public LottieHeader(Context context) {
        this(context, null);
    }

    public LottieHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
        mSpinnerStyle = SpinnerStyle.Translate;
        initView(context);
        mBackPaint = new Paint();
        mBackPaint.setColor(mBackgroundColor);
        mBackPaint.setAntiAlias(true);
    }

    private void initView(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.loading_lottie, this);
        mAnimationView = view.findViewById(R.id.loading_lottie);
    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        mAnimationView.playAnimation();
    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        mAnimationView.cancelAnimation();
        return 0;
    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {
        mKernel = kernel;
        kernel.requestDrawBackgroundFor(this, mBackgroundColor);
    }

    @Override
    public void setPrimaryColors(@ColorInt int... colors) {
        if (colors.length > 0) {
            mBackgroundColor = colors[0];
            if (mKernel != null) {
                mKernel.requestDrawBackgroundFor(this, mBackgroundColor);
            }
        }
    }

    /**
     * 设置动画json文件
     *
     * @param animName json文件名
     */
    public void setAnimationViewJson(String animName) {
        mAnimationView.setAnimation(animName);
    }

    /**
     * Set animation view json.
     *
     * @param anim the anim
     */
    public void setAnimationViewJson(Animation anim) {
        mAnimationView.setAnimation(anim);
    }
}

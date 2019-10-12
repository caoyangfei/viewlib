package com.flyang.expandview.banner.transformer;

import android.view.View;

import com.flyang.view.banner.transformer.BaseTransformer;


/**
 * @author caoyangfei
 * @ClassName ZoomStackPageTransformer
 * @date 2019/10/12
 * ------------- Description -------------
 * 左滑缩小,右滑放大
 */
public class ZoomStackPageTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
        if (position <= 0.0f) {
            view.setTranslationX(-view.getWidth() * position);

            view.setPivotX(view.getWidth() * 0.5f);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setScaleX(1 + position);
            view.setScaleY(1 + position);

            if (position < -0.95f) {
                view.setAlpha(0);
            } else {
                view.setAlpha(1);
            }
        } else if (position <= 1.0f) {
            view.setTranslationX(-view.getWidth() * position);

            view.setPivotX(view.getWidth() * 0.5f);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setScaleX(1 + position);
            view.setScaleY(1 + position);

            if (position > 0.95f) {
                view.setAlpha(0);
            } else {
                view.setAlpha(1);
            }
        }
    }
}
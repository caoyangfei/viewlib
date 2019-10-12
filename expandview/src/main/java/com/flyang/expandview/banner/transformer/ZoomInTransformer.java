package com.flyang.expandview.banner.transformer;

import android.view.View;

import com.flyang.view.banner.transformer.BaseTransformer;

/**
 * @author caoyangfei
 * @ClassName ZoomInTransformer
 * @date 2019/10/12
 * ------------- Description -------------
 */
public class ZoomInTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
        final float scale = position < 0 ? position + 1f : Math.abs(1f - position);
        view.setScaleX(scale);
        view.setScaleY(scale);
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setAlpha((position < -1f || position > 1f) ? 0f : 1f - (scale - 1f));
    }

}

package com.flyang.expandview.banner.transformer;

import android.view.View;

import com.flyang.view.banner.transformer.BaseTransformer;

/**
 * @author caoyangfei
 * @ClassName ScaleInOutTransformer
 * @date 2019/10/12
 * ------------- Description -------------
 */
public class ScaleInOutTransformer extends BaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		view.setPivotX(position < 0 ? 0 : view.getWidth());
		view.setPivotY(view.getHeight() / 2f);
		float scale = position < 0 ? 1f + position : 1f - position;
		view.setScaleX(scale);
		view.setScaleY(scale);
	}

}

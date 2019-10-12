package com.flyang.expandview.banner.transformer;

import android.view.View;

import com.flyang.view.banner.transformer.BaseTransformer;

/**
 * @author caoyangfei
 * @ClassName CubeOutTransformer
 * @date 2019/10/12
 * ------------- Description -------------
 */
public class CubeOutTransformer extends BaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		view.setPivotX(position < 0f ? view.getWidth() : 0f);
		view.setPivotY(view.getHeight() * 0.5f);
		view.setRotationY(90f * position);
	}

	@Override
	public boolean isPagingEnabled() {
		return true;
	}

}

package com.flyang.expandview.banner.transformer;

import android.view.View;

import com.flyang.view.banner.transformer.BaseTransformer;

/**
 * @author caoyangfei
 * @ClassName RotateDownTransformer
 * @date 2019/10/12
 * ------------- Description -------------
 */
public class RotateDownTransformer extends BaseTransformer {

	private static final float ROT_MOD = -15f;

	@Override
	protected void onTransform(View view, float position) {
		final float width = view.getWidth();
		final float height = view.getHeight();
		final float rotation = ROT_MOD * position * -1.25f;

		view.setPivotX(width * 0.5f);
		view.setPivotY(height);
		view.setRotation(rotation);
	}
	
	@Override
	protected boolean isPagingEnabled() {
		return true;
	}

}

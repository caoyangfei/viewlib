package com.flyang.expandview.banner.transformer;

import android.view.View;

import com.flyang.view.banner.transformer.BaseTransformer;

/**
 * @author caoyangfei
 * @ClassName RotateUpTransformer
 * @date 2019/10/12
 * ------------- Description -------------
 */
public class RotateUpTransformer extends BaseTransformer {

	private static final float ROT_MOD = -15f;

	@Override
	protected void onTransform(View view, float position) {
		final float width = view.getWidth();
		final float rotation = ROT_MOD * position;

		view.setPivotX(width * 0.5f);
		view.setPivotY(0f);
		view.setTranslationX(0f);
		view.setRotation(rotation);
	}
	
	@Override
	protected boolean isPagingEnabled() {
		return true;
	}

}

package com.flyang.expandview.banner.transformer;

import android.view.View;

import com.flyang.view.banner.transformer.BaseTransformer;

/**
 * @author caoyangfei
 * @ClassName FlipVerticalTransformer
 * @date 2019/10/12
 * ------------- Description -------------
 */
public class FlipVerticalTransformer extends BaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		final float rotation = -180f * position;

		view.setAlpha(rotation > 90f || rotation < -90f ? 0f : 1f);
		view.setPivotX(view.getWidth() * 0.5f);
		view.setPivotY(view.getHeight() * 0.5f);
		view.setRotationX(rotation);
	}

	@Override
	protected void onPostTransform(View page, float position) {
		super.onPostTransform(page, position);

		if (position > -0.5f && position < 0.5f) {
			page.setVisibility(View.VISIBLE);
		} else {
			page.setVisibility(View.INVISIBLE);
		}
	}
}

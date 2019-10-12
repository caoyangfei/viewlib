package com.flyang.expandview.banner.transformer;

import android.view.View;

import com.flyang.view.banner.transformer.BaseTransformer;

/**
 * @author caoyangfei
 * @ClassName CubeInTransformer
 * @date 2019/10/12
 * ------------- Description -------------
 */
public class CubeInTransformer extends BaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		// Rotate the fragment on the left or right edge
		view.setPivotX(position > 0 ? 0 : view.getWidth());
		view.setPivotY(0);
		view.setRotationY(-90f * position);
	}

	@Override
	public boolean isPagingEnabled() {
		return true;
	}

}

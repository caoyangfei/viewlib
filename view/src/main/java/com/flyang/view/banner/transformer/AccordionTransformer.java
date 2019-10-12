package com.flyang.view.banner.transformer;

import android.view.View;

/**
 * @author caoyangfei
 * @ClassName AccordionTransformer
 * @date 2019/10/12
 * ------------- Description -------------
 */
public class AccordionTransformer extends BaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		view.setPivotX(position < 0 ? 0 : view.getWidth());
		view.setScaleX(position < 0 ? 1f + position : 1f - position);
	}

}

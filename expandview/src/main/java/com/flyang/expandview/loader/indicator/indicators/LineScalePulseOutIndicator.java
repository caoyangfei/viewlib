package com.flyang.expandview.loader.indicator.indicators;


import android.animation.ValueAnimator;

import com.flyang.view.loader.indicator.indicators.LineScaleIndicator;

import java.util.ArrayList;

/**
 * @author caoyangfei
 * @ClassName LineScalePulseOutIndicator
 * @date 2019/6/30
 * ------------- Description -------------
 * 音符
 */
public class LineScalePulseOutIndicator extends LineScaleIndicator {

    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators = new ArrayList<>();
        long[] delays = new long[]{500, 250, 0, 250, 500};
        for (int i = 0; i < 5; i++) {
            final int index = i;
            ValueAnimator scaleAnim = ValueAnimator.ofFloat(1, 0.3f, 1);
            scaleAnim.setDuration(900);
            scaleAnim.setRepeatCount(-1);
            scaleAnim.setStartDelay(delays[i]);
            addUpdateListener(scaleAnim, new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    scaleYFloats[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            animators.add(scaleAnim);
        }
        return animators;
    }

}

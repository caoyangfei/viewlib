package com.flyang.view.loader.spinkit.style;

import android.animation.ValueAnimator;

import com.flyang.view.loader.spinkit.animation.SpriteAnimatorBuilder;
import com.flyang.view.loader.spinkit.sprite.CircleSprite;


/**
 * @author caoyangfei
 * @ClassName RotatingCircle
 * @date 2019/6/29
 * ------------- Description -------------
 * 旋转圆
 */
public class RotatingCircle extends CircleSprite {

    @Override
    public ValueAnimator onCreateAnimation() {
        float fractions[] = new float[]{0f, 0.5f, 1f};
        return new SpriteAnimatorBuilder(this).
                rotateX(fractions, 0, -180, -180).
                rotateY(fractions, 0, 0, -180).
                duration(1200).
                easeInOut(fractions)
                .build();
    }
}

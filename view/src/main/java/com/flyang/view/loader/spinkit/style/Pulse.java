package com.flyang.view.loader.spinkit.style;

import android.animation.ValueAnimator;

import com.flyang.view.loader.spinkit.animation.SpriteAnimatorBuilder;
import com.flyang.view.loader.spinkit.sprite.CircleSprite;


/**
 * @author caoyangfei
 * @ClassName Pulse
 * @date 2019/6/29
 * ------------- Description -------------
 * 脉搏样式
 */
public class Pulse extends CircleSprite {

    public Pulse() {
        setScale(0f);
    }

    @Override
    public ValueAnimator onCreateAnimation() {
        float fractions[] = new float[]{0f, 1f};
        return new SpriteAnimatorBuilder(this).
                scale(fractions, 0f, 1f).
                alpha(fractions, 255, 0).
                duration(1000).
                easeInOut(fractions)
                .build();
    }
}

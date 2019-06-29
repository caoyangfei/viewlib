package com.flyang.view.loader.spinkit.style;

import android.animation.ValueAnimator;

import com.flyang.view.loader.spinkit.animation.SpriteAnimatorBuilder;
import com.flyang.view.loader.spinkit.sprite.CircleLayoutContainer;
import com.flyang.view.loader.spinkit.sprite.CircleSprite;
import com.flyang.view.loader.spinkit.sprite.Sprite;


/**
 * @author caoyangfei
 * @ClassName FadingCircle
 * @date 2019/6/29
 * ------------- Description -------------
 * 渐变圆形
 */
public class FadingCircle extends CircleLayoutContainer {

    @Override
    public Sprite[] onCreateChild() {
        Dot[] dots = new Dot[12];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new Dot();
            dots[i].setAnimationDelay(100 * i + -1200);
        }
        return dots;
    }

    private class Dot extends CircleSprite {

        Dot() {
            setAlpha(0);
        }

        @Override
        public ValueAnimator onCreateAnimation() {
            float fractions[] = new float[]{0f, 0.39f, 0.4f, 1f};
            return new SpriteAnimatorBuilder(this).
                    alpha(fractions, 0, 0, 255, 0).
                    duration(1200).
                    easeInOut(fractions).build();
        }
    }
}

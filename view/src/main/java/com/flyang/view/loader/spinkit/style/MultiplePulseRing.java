package com.flyang.view.loader.spinkit.style;


import com.flyang.view.loader.spinkit.sprite.Sprite;
import com.flyang.view.loader.spinkit.sprite.SpriteContainer;

/**
 * @author caoyangfei
 * @ClassName MultiplePulseRing
 * @date 2019/6/29
 * ------------- Description -------------
 * 多脉冲
 */
public class MultiplePulseRing extends SpriteContainer {

    @Override
    public Sprite[] onCreateChild() {
        return new Sprite[]{
                new PulseRing(),
                new PulseRing(),
                new PulseRing(),
        };
    }

    @Override
    public void onChildCreated(Sprite... sprites) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].setAnimationDelay(200 * (i + 1));
        }
    }
}

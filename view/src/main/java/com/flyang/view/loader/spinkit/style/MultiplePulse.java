package com.flyang.view.loader.spinkit.style;


import com.flyang.view.loader.spinkit.sprite.Sprite;
import com.flyang.view.loader.spinkit.sprite.SpriteContainer;

/**
 * @author caoyangfei
 * @ClassName MultiplePulse
 * @date 2019/6/29
 * ------------- Description -------------
 * 多脉冲
 */
public class MultiplePulse extends SpriteContainer {
    @Override
    public Sprite[] onCreateChild() {
        return new Sprite[]{
                new Pulse(),
                new Pulse(),
                new Pulse(),
        };
    }

    @Override
    public void onChildCreated(Sprite... sprites) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].setAnimationDelay(200 * (i + 1));
        }
    }
}

package com.flyang.view.loader.spinkit;


import com.flyang.view.loader.spinkit.sprite.Sprite;
import com.flyang.view.loader.spinkit.style.ChasingDots;
import com.flyang.view.loader.spinkit.style.Circle;
import com.flyang.view.loader.spinkit.style.CubeGrid;
import com.flyang.view.loader.spinkit.style.DoubleBounce;
import com.flyang.view.loader.spinkit.style.FadingCircle;
import com.flyang.view.loader.spinkit.style.FoldingCube;
import com.flyang.view.loader.spinkit.style.MultiplePulse;
import com.flyang.view.loader.spinkit.style.MultiplePulseRing;
import com.flyang.view.loader.spinkit.style.Pulse;
import com.flyang.view.loader.spinkit.style.PulseRing;
import com.flyang.view.loader.spinkit.style.RotatingCircle;
import com.flyang.view.loader.spinkit.style.RotatingPlane;
import com.flyang.view.loader.spinkit.style.ThreeBounce;
import com.flyang.view.loader.spinkit.style.WanderingCubes;
import com.flyang.view.loader.spinkit.style.Wave;

/**
 * @author caoyangfei
 * @ClassName SpriteFactory
 * @date 2019/6/29
 * ------------- Description -------------
 * 样式切换
 */
public class SpriteFactory {

    public static Sprite create(SpinKitStyle style) {
        Sprite sprite = null;
        switch (style) {
            case ROTATING_PLANE:
                sprite = new RotatingPlane();
                break;
            case DOUBLE_BOUNCE:
                sprite = new DoubleBounce();
                break;
            case WAVE:
                sprite = new Wave();
                break;
            case WANDERING_CUBES:
                sprite = new WanderingCubes();
                break;
            case PULSE:
                sprite = new Pulse();
                break;
            case CHASING_DOTS:
                sprite = new ChasingDots();
                break;
            case THREE_BOUNCE:
                sprite = new ThreeBounce();
                break;
            case CIRCLE:
                sprite = new Circle();
                break;
            case CUBE_GRID:
                sprite = new CubeGrid();
                break;
            case FADING_CIRCLE:
                sprite = new FadingCircle();
                break;
            case FOLDING_CUBE:
                sprite = new FoldingCube();
                break;
            case ROTATING_CIRCLE:
                sprite = new RotatingCircle();
                break;
            case MULTIPLE_PULSE:
                sprite = new MultiplePulse();
                break;
            case PULSE_RING:
                sprite = new PulseRing();
                break;
            case MULTIPLE_PULSE_RING:
                sprite = new MultiplePulseRing();
                break;
            default:
                break;
        }
        return sprite;
    }
}

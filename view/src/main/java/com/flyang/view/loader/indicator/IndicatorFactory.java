package com.flyang.view.loader.indicator;

import com.flyang.view.loader.indicator.indicators.BallGridBeatIndicator;
import com.flyang.view.loader.indicator.indicators.BallPulseRiseIndicator;
import com.flyang.view.loader.indicator.indicators.BallPulseSyncIndicator;
import com.flyang.view.loader.indicator.indicators.BallZigZagIndicator;
import com.flyang.view.loader.indicator.indicators.LineScaleIndicator;
import com.flyang.view.loader.indicator.indicators.PacmanIndicator;

/**
 * @author yangfei.cao
 * @ClassName viewlib_demo
 * @date 2019/6/30
 * ------------- Description -------------
 * 动画构建类
 */
public class IndicatorFactory {

    public static Indicator create(IndicatorStyle style) {
        Indicator indicator = null;
        switch (style) {
            case BallGridBeatIndicator:
                indicator = new BallGridBeatIndicator();
                break;
            case BallPulseRiseIndicator:
                indicator = new BallPulseRiseIndicator();
                break;
            case BallPulseSyncIndicator:
                indicator = new BallPulseSyncIndicator();
                break;
            case BallZigZagIndicator:
                indicator = new BallZigZagIndicator();
                break;
            case LineScaleIndicator:
                indicator = new LineScaleIndicator();
                break;
            case PacmanIndicator:
                indicator = new PacmanIndicator();
                break;
            default:
                break;
        }
        return indicator;
    }
}

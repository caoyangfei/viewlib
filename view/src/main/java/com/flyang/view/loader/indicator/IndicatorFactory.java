package com.flyang.view.loader.indicator;

import com.flyang.view.loader.indicator.indicators.BallBeatIndicator;
import com.flyang.view.loader.indicator.indicators.BallClipRotateIndicator;
import com.flyang.view.loader.indicator.indicators.BallClipRotateMultipleIndicator;
import com.flyang.view.loader.indicator.indicators.BallClipRotatePulseIndicator;
import com.flyang.view.loader.indicator.indicators.BallGridBeatIndicator;
import com.flyang.view.loader.indicator.indicators.BallGridPulseIndicator;
import com.flyang.view.loader.indicator.indicators.BallPulseIndicator;
import com.flyang.view.loader.indicator.indicators.BallPulseRiseIndicator;
import com.flyang.view.loader.indicator.indicators.BallPulseSyncIndicator;
import com.flyang.view.loader.indicator.indicators.BallRotateIndicator;
import com.flyang.view.loader.indicator.indicators.BallScaleIndicator;
import com.flyang.view.loader.indicator.indicators.BallScaleMultipleIndicator;
import com.flyang.view.loader.indicator.indicators.BallScaleRippleIndicator;
import com.flyang.view.loader.indicator.indicators.BallScaleRippleMultipleIndicator;
import com.flyang.view.loader.indicator.indicators.BallSpinFadeLoaderIndicator;
import com.flyang.view.loader.indicator.indicators.BallTrianglePathIndicator;
import com.flyang.view.loader.indicator.indicators.BallZigZagDeflectIndicator;
import com.flyang.view.loader.indicator.indicators.BallZigZagIndicator;
import com.flyang.view.loader.indicator.indicators.CubeTransitionIndicator;
import com.flyang.view.loader.indicator.indicators.LineScaleIndicator;
import com.flyang.view.loader.indicator.indicators.LineScalePartyIndicator;
import com.flyang.view.loader.indicator.indicators.LineScalePulseOutIndicator;
import com.flyang.view.loader.indicator.indicators.LineScalePulseOutRapidIndicator;
import com.flyang.view.loader.indicator.indicators.LineSpinFadeLoaderIndicator;
import com.flyang.view.loader.indicator.indicators.PacmanIndicator;
import com.flyang.view.loader.indicator.indicators.SemiCircleSpinIndicator;
import com.flyang.view.loader.indicator.indicators.SquareSpinIndicator;
import com.flyang.view.loader.indicator.indicators.TriangleSkewSpinIndicator;

/**
 * @author yangfei.cao
 * @ClassName viewlib_demo
 * @date 2019/6/30
 * ------------- Description -------------
 */
public class IndicatorFactory {

    public static Indicator create(IndicatorStyle style) {
        Indicator indicator = null;
        switch (style) {
            case BallBeatIndicator:
                indicator = new BallBeatIndicator();
                break;
            case BallClipRotateIndicator:
                indicator = new BallClipRotateIndicator();
                break;
            case BallClipRotateMultipleIndicator:
                indicator = new BallClipRotateMultipleIndicator();
                break;
            case BallClipRotatePulseIndicator:
                indicator = new BallClipRotatePulseIndicator();
                break;
            case BallGridBeatIndicator:
                indicator = new BallGridBeatIndicator();
                break;
            case BallGridPulseIndicator:
                indicator = new BallGridPulseIndicator();
                break;
            case BallPulseIndicator:
                indicator = new BallPulseIndicator();
                break;
            case BallPulseRiseIndicator:
                indicator = new BallPulseRiseIndicator();
                break;
            case BallPulseSyncIndicator:
                indicator = new BallPulseSyncIndicator();
                break;
            case BallRotateIndicator:
                indicator = new BallRotateIndicator();
                break;
            case BallScaleIndicator:
                indicator = new BallScaleIndicator();
                break;
            case BallScaleMultipleIndicator:
                indicator = new BallScaleMultipleIndicator();
                break;
            case BallScaleRippleIndicator:
                indicator = new BallScaleRippleIndicator();
                break;
            case BallScaleRippleMultipleIndicator:
                indicator = new BallScaleRippleMultipleIndicator();
                break;
            case BallZigZagDeflectIndicator:
                indicator = new BallZigZagDeflectIndicator();
                break;
            case BallTrianglePathIndicator:
                indicator = new BallTrianglePathIndicator();
                break;
            case BallSpinFadeLoaderIndicator:
                indicator = new BallSpinFadeLoaderIndicator();
            case BallZigZagIndicator:
                indicator = new BallZigZagIndicator();
                break;
            case CubeTransitionIndicator:
                indicator = new CubeTransitionIndicator();
                break;
            case LineScaleIndicator:
                indicator = new LineScaleIndicator();
                break;
            case LineScalePartyIndicator:
                indicator = new LineScalePartyIndicator();
                break;
            case LineScalePulseOutIndicator:
                indicator = new LineScalePulseOutIndicator();
                break;
            case LineScalePulseOutRapidIndicator:
                indicator = new LineScalePulseOutRapidIndicator();
                break;
            case LineSpinFadeLoaderIndicator:
                indicator = new LineSpinFadeLoaderIndicator();
                break;
            case PacmanIndicator:
                indicator = new PacmanIndicator();
                break;
            case SemiCircleSpinIndicator:
                indicator = new SemiCircleSpinIndicator();
                break;
            case SquareSpinIndicator:
                indicator = new SquareSpinIndicator();
                break;
            case TriangleSkewSpinIndicator:
                indicator = new TriangleSkewSpinIndicator();
                break;
            default:
                break;
        }
        return indicator;
    }
}

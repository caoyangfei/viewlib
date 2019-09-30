package com.flyang.expandview.loader.indicator;

import com.flyang.expandview.loader.indicator.indicators.BallBeatIndicator;
import com.flyang.expandview.loader.indicator.indicators.BallClipRotateIndicator;
import com.flyang.expandview.loader.indicator.indicators.BallClipRotateMultipleIndicator;
import com.flyang.expandview.loader.indicator.indicators.BallClipRotatePulseIndicator;
import com.flyang.expandview.loader.indicator.indicators.BallGridPulseIndicator;
import com.flyang.expandview.loader.indicator.indicators.BallPulseIndicator;
import com.flyang.expandview.loader.indicator.indicators.BallRotateIndicator;
import com.flyang.expandview.loader.indicator.indicators.BallScaleIndicator;
import com.flyang.expandview.loader.indicator.indicators.BallScaleMultipleIndicator;
import com.flyang.expandview.loader.indicator.indicators.BallScaleRippleIndicator;
import com.flyang.expandview.loader.indicator.indicators.BallScaleRippleMultipleIndicator;
import com.flyang.expandview.loader.indicator.indicators.BallSpinFadeLoaderIndicator;
import com.flyang.expandview.loader.indicator.indicators.BallTrianglePathIndicator;
import com.flyang.expandview.loader.indicator.indicators.BallZigZagDeflectIndicator;
import com.flyang.expandview.loader.indicator.indicators.CubeTransitionIndicator;
import com.flyang.expandview.loader.indicator.indicators.LineScalePartyIndicator;
import com.flyang.expandview.loader.indicator.indicators.LineScalePulseOutIndicator;
import com.flyang.expandview.loader.indicator.indicators.LineScalePulseOutRapidIndicator;
import com.flyang.expandview.loader.indicator.indicators.LineSpinFadeLoaderIndicator;
import com.flyang.expandview.loader.indicator.indicators.SemiCircleSpinIndicator;
import com.flyang.expandview.loader.indicator.indicators.SquareSpinIndicator;
import com.flyang.expandview.loader.indicator.indicators.TriangleSkewSpinIndicator;
import com.flyang.view.loader.indicator.Indicator;
import com.flyang.view.loader.indicator.IndicatorFactory;
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
 */
public class IndicatorFactoryExp extends IndicatorFactory {

    public static Indicator create(IndicatorStyleExp style) {
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
                break;
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

package com.flyang.expandview.loader.indicator;

/**
 * @author yangfei.cao
 * @ClassName viewlib_demo
 * @date 2019/6/30
 * ------------- Description -------------
 */
public enum IndicatorStyleExp {
    BallBeatIndicator(1),
    BallClipRotateIndicator(2),
    BallClipRotateMultipleIndicator(3),
    BallClipRotatePulseIndicator(4),
    BallGridBeatIndicator(5),
    BallGridPulseIndicator(6),
    BallPulseIndicator(7),
    BallPulseRiseIndicator(8),
    BallPulseSyncIndicator(9),
    BallRotateIndicator(10),
    BallScaleIndicator(11),
    BallScaleMultipleIndicator(12),
    BallScaleRippleIndicator(13),
    BallScaleRippleMultipleIndicator(14),
    BallSpinFadeLoaderIndicator(15),
    BallTrianglePathIndicator(16),
    BallZigZagDeflectIndicator(17),
    BallZigZagIndicator(18),
    CubeTransitionIndicator(19),
    LineScaleIndicator(20),
    LineScalePartyIndicator(21),
    LineScalePulseOutIndicator(22),
    LineScalePulseOutRapidIndicator(23),
    LineSpinFadeLoaderIndicator(24),
    PacmanIndicator(25),
    SemiCircleSpinIndicator(26),
    SquareSpinIndicator(27),
    TriangleSkewSpinIndicator(28);

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private int value;

    IndicatorStyleExp(int value) {
        this.value = value;
    }
}

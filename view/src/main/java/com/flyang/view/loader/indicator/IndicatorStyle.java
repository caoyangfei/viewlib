package com.flyang.view.loader.indicator;

/**
 * @author yangfei.cao
 * @ClassName viewlib_demo
 * @date 2019/6/30
 * ------------- Description -------------
 * 动画枚举
 */
public enum IndicatorStyle {
    BallGridBeatIndicator(1),
    BallPulseRiseIndicator(2),
    BallPulseSyncIndicator(3),
    BallZigZagIndicator(4),
    LineScaleIndicator(5),
    PacmanIndicator(6);

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private int value;

    IndicatorStyle(int value) {
        this.value = value;
    }
}

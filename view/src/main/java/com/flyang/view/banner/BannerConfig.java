package com.flyang.view.banner;

/**
 * @author caoyangfei
 * @ClassName BannerConfig
 * @date 2019/10/12
 * ------------- Description -------------
 * 配置
 */
public class BannerConfig {
    //TODO 指示器样式

    //不显示指示器和标题
    public static final int NOT_INDICATOR = 0;
    //显示圆形指示器
    public static final int CIRCLE_INDICATOR = 1;
    //显示数字指示器
    public static final int NUM_INDICATOR = 2;
    //显示数字指示器和标题
    public static final int NUM_INDICATOR_TITLE = 3;
    //显示圆形指示器和标题（垂直显示）
    public static final int CIRCLE_INDICATOR_TITLE = 4;
    //显示圆形指示器和标题（水平显示）
    public static final int CIRCLE_INDICATOR_TITLE_INSIDE = 5;

    //TODO 指示器位置

    //指示器居左
    public static final int LEFT = 5;
    //指示器居中
    public static final int CENTER = 6;
    //指示器居右
    public static final int RIGHT = 7;

    //TODO 轮播默认设置
    public static final int PADDING_SIZE = 5;
    public static final int TIME = 2000;
    public static final int DURATION = 800;
    public static final boolean IS_AUTO_PLAY = true;
    public static final boolean IS_SCROLL = true;

    //TODO 标题样式设置
    public static final int TITLE_BACKGROUND = -1;
    public static final int TITLE_HEIGHT = -1;
    public static final int TITLE_TEXT_COLOR = -1;
    public static final int TITLE_TEXT_SIZE = -1;

}

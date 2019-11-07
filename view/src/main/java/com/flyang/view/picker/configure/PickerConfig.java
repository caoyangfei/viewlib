package com.flyang.view.picker.configure;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import com.flyang.view.picker.lisenter.CustomListener;
import com.flyang.view.wheel.WheelView;

/**
 * @author caoyangfei
 * @ClassName PickerOptions
 * @date 2019/11/4
 * ------------- Description -------------
 * 参数配置
 */
public class PickerConfig {
    public View.OnClickListener cancelListener;
    public CustomListener customListener;
    public int inAnimRes;
    public int outAnimRes;
    public int layoutRes;
    public ViewGroup decorView;
    public Context context;
    public String textContentConfirm;//确定按钮文字
    public String textContentCancel;//取消按钮文字
    public String textContentTitle;//标题文字
    public int textColorConfirm;//确定按钮颜色
    public int textColorCancel;//取消按钮颜色
    public int textColorTitle;//标题颜色
    public int bgColorWheel = Color.WHITE;//滚轮背景颜色
    public int bgColorTitle;//标题背景颜色
    public int textSizeSubmitCancel;//确定取消按钮大小
    public int textSizeTitle; //标题文字大小
    public int textSizeContent;//内容文字大小
    public int textColorOut; //分割线以外的文字颜色
    public int textColorCenter; //分割线之间的文字颜色
    public int dividerColor; //分割线的颜色
    public int outSideColor; //显示时的外部背景色颜色,默认是灰色
    public float lineSpacingMultiplier; // 条目间距倍数 默认1.6
    public boolean isDialog;//是否是对话框模式
    public boolean cancelable;//是否能取消
    public boolean isCenterLabel;//是否只显示中间的label,默认每个item都显示
    public WheelView.DividerType dividerType;//分隔线类型
    public int itemsVisibleCount; //最大可见条目数
    public boolean isAlphaGradient; //透明度渐变
    public int gravity; //弹出框位置
    public int dialogAnim; //弹出动画
}

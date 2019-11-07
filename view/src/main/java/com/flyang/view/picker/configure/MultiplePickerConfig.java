package com.flyang.view.picker.configure;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.flyang.view.R;
import com.flyang.view.picker.MultiplePickerView;
import com.flyang.view.picker.lisenter.CustomListener;
import com.flyang.view.picker.lisenter.OnMultipleSelectChangeLisenter;
import com.flyang.view.picker.lisenter.OnMultipleSelectLisenter;
import com.flyang.view.wheel.WheelView;


/**
 * @author caoyangfei
 * @ClassName OptionsPickerBuilder
 * @date 2019/11/5
 * ------------- Description -------------
 * Builder模式构建三级联动选择器
 */
public class MultiplePickerConfig extends PickerConfig {
    public boolean cyclic;//是否循环，默认否
    public int x_offset;//x轴偏移量
    public Typeface font;//字体样式
    public int currentItem;//默认选中项
    public String[] label;//单位字符
    public OnMultipleSelectChangeLisenter onMultipleSelectChangeLisenter;
    public OnMultipleSelectLisenter onMultipleSelectLisenter;

    public MultiplePickerConfig(Builder builder) {
        context = builder.context;
        layoutRes = builder.layoutRes;
        cancelListener = builder.cancelListener;
        customListener = builder.customListener;
        inAnimRes = builder.inAnimRes;
        outAnimRes = builder.outAnimRes;
        decorView = builder.decorView;
        textContentConfirm = builder.textContentConfirm;
        textContentCancel = builder.textContentCancel;
        textContentTitle = builder.textContentTitle;
        textColorConfirm = builder.textColorConfirm;
        textColorCancel = builder.textColorCancel;
        textColorTitle = builder.textColorTitle;
        bgColorWheel = builder.bgColorWheel;
        bgColorTitle = builder.bgColorTitle;
        textSizeSubmitCancel = builder.textSizeSubmitCancel;
        textSizeTitle = builder.textSizeTitle;
        textSizeContent = builder.textSizeContent;
        textColorOut = builder.textColorOut;
        textColorCenter = builder.textColorCenter;
        dividerColor = builder.dividerColor;
        outSideColor = builder.outSideColor;
        lineSpacingMultiplier = builder.lineSpacingMultiplier;
        isDialog = builder.isDialog;
        cancelable = builder.cancelable;
        isCenterLabel = builder.isCenterLabel;
        font = builder.font;
        dividerType = builder.dividerType;
        itemsVisibleCount = builder.itemsVisibleCount;
        isAlphaGradient = builder.isAlphaGradient;
        gravity = builder.gravity;
        cyclic = builder.cyclic;//是否循环，默认否
        label = builder.label;//单位字符
        x_offset = builder.x_offset;//x轴偏移量
        currentItem = builder.currentItem;//默认选中项
        onMultipleSelectChangeLisenter = builder.onMultipleSelectChangeLisenter;
        onMultipleSelectLisenter = builder.onMultipleSelectLisenter;

    }

    public static final class Builder {
        Context context;
        int layoutRes = R.layout.pickerview_multiple;
        View.OnClickListener cancelListener;
        CustomListener customListener;
        int inAnimRes = R.anim.pickerview_slide_in_bottom;
        int outAnimRes = R.anim.pickerview_slide_out_bottom;
        ViewGroup decorView;
        String textContentConfirm;//确定按钮文字
        String textContentCancel;//取消按钮文字
        String textContentTitle;//标题文字
        int textColorConfirm = 0xFF057dff;//确定按钮颜色
        int textColorCancel = 0xFF057dff;//取消按钮颜色
        int textColorTitle = 0xFF000000;//标题颜色
        int bgColorWheel = 0xFFFFFFFF;//滚轮背景颜色
        int bgColorTitle = 0xFFf5f5f5;//标题背景颜色
        int textSizeSubmitCancel = 17;//确定取消按钮大小
        int textSizeTitle = 18;//标题文字大小
        int textSizeContent = 18;//内容文字大小
        int textColorOut = 0xFFa8a8a8; //分割线以外的文字颜色
        int textColorCenter = 0xFF2a2a2a; //分割线之间的文字颜色
        int dividerColor = 0xFFd5d5d5; //分割线的颜色
        int outSideColor = -1; //显示时的外部背景色颜色,默认是灰色
        float lineSpacingMultiplier = 1.6f; // 条目间距倍数 默认1.6
        boolean isDialog = true;//是否是对话框模式
        boolean cancelable = true;//是否能取消
        boolean isCenterLabel = false;//是否只显示中间的label,默认每个item都显示
        Typeface font = Typeface.MONOSPACE;//字体样式
        WheelView.DividerType dividerType = WheelView.DividerType.FILL;//分隔线类型
        int itemsVisibleCount = 9; //最大可见条目数
        boolean isAlphaGradient = false; //透明度渐变
        int gravity = Gravity.BOTTOM; //弹出框位置
        boolean cyclic;//是否循环，默认否
        String[] label;//单位字符
        int x_offset;//x轴偏移量
        int currentItem;//默认选中项
        OnMultipleSelectChangeLisenter onMultipleSelectChangeLisenter;
        OnMultipleSelectLisenter onMultipleSelectLisenter;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setCancelListener(View.OnClickListener cancelListener) {
            this.cancelListener = cancelListener;
            return this;
        }

        public Builder setInAnimRes(int inAnimRes) {
            this.inAnimRes = inAnimRes;
            return this;
        }

        public Builder setOutAnimRes(int outAnimRes) {
            this.outAnimRes = outAnimRes;
            return this;
        }

        public Builder setLayoutRes(int layoutRes, CustomListener customListener) {
            this.layoutRes = layoutRes;
            this.customListener = customListener;
            return this;
        }

        public Builder setDecorView(ViewGroup decorView) {
            this.decorView = decorView;
            return this;
        }


        public Builder setTextContentConfirm(String textContentConfirm) {
            this.textContentConfirm = textContentConfirm;
            return this;
        }

        public Builder setTextContentCancel(String textContentCancel) {
            this.textContentCancel = textContentCancel;
            return this;
        }

        public Builder setTextContentTitle(String textContentTitle) {
            this.textContentTitle = textContentTitle;
            return this;
        }

        public Builder setTextColorConfirm(int textColorConfirm) {
            this.textColorConfirm = textColorConfirm;
            return this;
        }

        public Builder setTextColorCancel(int textColorCancel) {
            this.textColorCancel = textColorCancel;
            return this;
        }

        public Builder setTextColorTitle(int textColorTitle) {
            this.textColorTitle = textColorTitle;
            return this;
        }

        public Builder setBgColorWheel(int bgColorWheel) {
            this.bgColorWheel = bgColorWheel;
            return this;
        }

        public Builder setBgColorTitle(int bgColorTitle) {
            this.bgColorTitle = bgColorTitle;
            return this;
        }

        public Builder setTextSizeSubmitCancel(int textSizeSubmitCancel) {
            this.textSizeSubmitCancel = textSizeSubmitCancel;
            return this;
        }

        public Builder setTextSizeTitle(int textSizeTitle) {
            this.textSizeTitle = textSizeTitle;
            return this;
        }

        public Builder setTextSizeContent(int textSizeContent) {
            this.textSizeContent = textSizeContent;
            return this;
        }

        public Builder setTextColorOut(int textColorOut) {
            this.textColorOut = textColorOut;
            return this;
        }

        public Builder setTextColorCenter(int textColorCenter) {
            this.textColorCenter = textColorCenter;
            return this;
        }

        public Builder setDividerColor(int dividerColor) {
            this.dividerColor = dividerColor;
            return this;
        }

        public Builder setOutSideColor(int outSideColor) {
            this.outSideColor = outSideColor;
            return this;
        }

        public Builder setLineSpacingMultiplier(float lineSpacingMultiplier) {
            this.lineSpacingMultiplier = lineSpacingMultiplier;
            return this;
        }

        public Builder setDialog(boolean dialog) {
            isDialog = dialog;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setCenterLabel(boolean centerLabel) {
            isCenterLabel = centerLabel;
            return this;
        }

        public Builder setDividerType(WheelView.DividerType dividerType) {
            this.dividerType = dividerType;
            return this;
        }

        /**
         * 设置最大可见数目
         *
         * @param itemsVisibleCount 建议设置为 3 ~ 9之间。
         */
        public Builder setItemsVisibleCount(int itemsVisibleCount) {
            this.itemsVisibleCount = itemsVisibleCount;
            return this;
        }

        /**
         * 透明度是否渐变
         *
         * @param alphaGradient true of false
         */
        public Builder setAlphaGradient(boolean alphaGradient) {
            isAlphaGradient = alphaGradient;
            return this;
        }

        public Builder setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }


        public Builder setFont(Typeface font) {
            this.font = font;
            return this;
        }

        public Builder setLayoutRes(int layoutRes) {
            this.layoutRes = layoutRes;
            return this;
        }

        public Builder setCustomListener(CustomListener customListener) {
            this.customListener = customListener;
            return this;
        }

        public Builder setCyclic(boolean cyclic) {
            this.cyclic = cyclic;
            return this;
        }

        public Builder setLabel(String[] label) {
            this.label = label;
            return this;
        }

        public Builder setX_offset(int x_offset) {
            this.x_offset = x_offset;
            return this;
        }

        public Builder setCurrentItem(int currentItem) {
            this.currentItem = currentItem;
            return this;
        }

        public Builder setOnMultipleSelectChangeLisenter(OnMultipleSelectChangeLisenter onMultipleSelectChangeLisenter) {
            this.onMultipleSelectChangeLisenter = onMultipleSelectChangeLisenter;
            return this;
        }

        public Builder setOnMultipleSelectLisenter(OnMultipleSelectLisenter onMultipleSelectLisenter) {
            this.onMultipleSelectLisenter = onMultipleSelectLisenter;
            return this;
        }

        public MultiplePickerView Builder() {
            MultiplePickerConfig mPickerOptions = new MultiplePickerConfig(this);
            return new MultiplePickerView<>(mPickerOptions);
        }
    }
}

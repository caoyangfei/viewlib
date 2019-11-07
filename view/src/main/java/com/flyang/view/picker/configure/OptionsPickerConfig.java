package com.flyang.view.picker.configure;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.flyang.view.R;
import com.flyang.view.picker.OptionsPickerView;
import com.flyang.view.picker.lisenter.CustomListener;
import com.flyang.view.picker.lisenter.OnOptionsSelectChangeListener;
import com.flyang.view.picker.lisenter.OnOptionsSelectListener;
import com.flyang.view.wheel.WheelView;


/**
 * @author caoyangfei
 * @ClassName OptionsPickerBuilder
 * @date 2019/11/5
 * ------------- Description -------------
 * Builder模式构建三级联动选择器
 */
public class OptionsPickerConfig extends PickerConfig {
    public boolean isRestoreItem; //切换时，还原第一项
    public String label1, label2, label3;//单位字符
    public int option1, option2, option3;//默认选中项
    public int x_offset_one, x_offset_two, x_offset_three;//x轴偏移量
    public boolean cyclic1, cyclic2, cyclic3;//是否循环，默认否
    public Typeface font;//字体样式
    public OnOptionsSelectChangeListener optionsSelectChangeListener;
    public OnOptionsSelectListener optionsSelectListener;

    public OptionsPickerConfig(Builder builder) {
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
        dialogAnim = builder.dialogAnim;

        isRestoreItem = builder.isRestoreItem;
        label1 = builder.label1;
        label2 = builder.label2;
        label3 = builder.label3;
        option1 = builder.option1;
        option2 = builder.option2;
        option3 = builder.option3;
        x_offset_one = builder.x_offset_one;
        x_offset_two = builder.x_offset_two;
        x_offset_three = builder.x_offset_three;
        cyclic1 = builder.cyclic1;
        cyclic2 = builder.cyclic2;
        cyclic3 = builder.cyclic3;
        optionsSelectChangeListener = builder.optionsSelectChangeListener;
        optionsSelectListener = builder.optionsSelectListener;

    }

    public static final class Builder {
        Context context;
        int layoutRes = R.layout.pickerview_options;
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
        int dialogAnim=R.style.pickerScaleAnim;

        boolean isRestoreItem = false; //切换时，还原第一项
        String label1, label2, label3;//单位字符
        int option1, option2, option3;//默认选中项
        int x_offset_one, x_offset_two, x_offset_three;//x轴偏移量
        boolean cyclic1 = false;//是否循环，默认否
        boolean cyclic2 = false;
        boolean cyclic3 = false;
        OnOptionsSelectChangeListener optionsSelectChangeListener;
        OnOptionsSelectListener optionsSelectListener;

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

        public Builder setDialogAnim(int dialogAnim) {
            this.dialogAnim = dialogAnim;
            return this;
        }

        /**
         * 切换选项时，是否还原第一项
         *
         * @param restoreItem true：还原； false: 保持上一个选项
         * @return TimePickerBuilder
         */
        public Builder setRestoreItem(boolean restoreItem) {
            isRestoreItem = restoreItem;
            return this;
        }

        public Builder setLabels(String label1, String label2, String label3) {
            this.label1 = label1;
            this.label2 = label2;
            this.label3 = label3;
            return this;
        }

        public Builder setSelectOptions(int option1) {
            this.option1 = option1;
            return this;
        }

        public Builder setSelectOptions(int option1, int option2) {
            this.option1 = option1;
            this.option2 = option2;
            return this;
        }

        public Builder setSelectOptions(int option1, int option2, int option3) {
            this.option1 = option1;
            this.option2 = option2;
            this.option3 = option3;
            return this;
        }

        public Builder setTextXOffset(int xoffset_one, int xoffset_two, int xoffset_three) {
            this.x_offset_one = xoffset_one;
            this.x_offset_two = xoffset_two;
            this.x_offset_three = xoffset_three;
            return this;
        }

        public Builder setCyclic(boolean cyclic1, boolean cyclic2, boolean cyclic3) {
            this.cyclic1 = cyclic1;
            this.cyclic2 = cyclic2;
            this.cyclic3 = cyclic3;
            return this;
        }

        public Builder setFont(Typeface font) {
            this.font = font;
            return this;
        }

        public Builder setOptionsSelectChangeListener(OnOptionsSelectChangeListener optionsSelectChangeListener) {
            this.optionsSelectChangeListener = optionsSelectChangeListener;
            return this;
        }

        public Builder setOptionsSelectListener(OnOptionsSelectListener optionsSelectListener) {
            this.optionsSelectListener = optionsSelectListener;
            return this;
        }

        public <Fst, Snd, Trd> OptionsPickerView<Fst, Snd, Trd> Builder() {
            OptionsPickerConfig mPickerOptions = new OptionsPickerConfig(this);
            return new OptionsPickerView<>(mPickerOptions);
        }
    }
}

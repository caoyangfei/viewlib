package com.flyang.view.picker.configure;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.flyang.view.R;
import com.flyang.view.picker.TimePickerView;
import com.flyang.view.picker.lisenter.CustomListener;
import com.flyang.view.picker.lisenter.OnTimeSelectChangeListener;
import com.flyang.view.picker.lisenter.OnTimeSelectListener;
import com.flyang.view.wheel.WheelView;

import java.util.Calendar;


/**
 * @author caoyangfei
 * @ClassName TimePickerBuilder
 * @date 2019/11/5
 * ------------- Description -------------
 * Builder模式构建时间选择器
 */
public class TimePickerConfig extends PickerConfig {
    public boolean[] type; //显示类型，默认显示： 年月日
    public String label_year, label_month, label_day, label_hours, label_minutes, label_seconds;//单位
    public int x_offset_year, x_offset_month, x_offset_day, x_offset_hours, x_offset_minutes, x_offset_seconds;//单位
    public Calendar date;//当前选中时间
    public Calendar startDate;//开始时间
    public Calendar endDate;//终止时间
    public int startYear;//开始年份
    public int endYear;//结尾年份
    public boolean cyclic;//是否循环
    public boolean isLunarCalendar;//是否显示农历
    public OnTimeSelectChangeListener timeSelectChangeListener;
    public OnTimeSelectListener timeSelectListener;
    public int textGravity;
    public Typeface font;//字体样式

    public TimePickerConfig(Builder builder) {
        context = builder.context;
        layoutRes = builder.layoutRes;
        cancelListener = builder.cancelListener;
        customListener = builder.customListener;
        inAnimRes = builder.inAnimRes;
        outAnimRes = builder.outAnimRes;
        decorView = builder.decorView;
        textGravity = builder.textGravity;
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

        type = builder.type;
        label_year = builder.label_year;
        label_month = builder.label_month;
        label_day = builder.label_day;
        label_hours = builder.label_hours;
        label_minutes = builder.label_minutes;
        label_seconds = builder.label_seconds;
        x_offset_year = builder.x_offset_year;
        x_offset_month = builder.x_offset_month;
        x_offset_day = builder.x_offset_day;
        x_offset_hours = builder.x_offset_hours;
        x_offset_minutes = builder.x_offset_minutes;
        x_offset_seconds = builder.x_offset_seconds;
        date = builder.date;
        startDate = builder.startDate;
        endDate = builder.endDate;
        startYear = builder.startYear;
        endYear = builder.endYear;
        cyclic = builder.cyclic;
        isLunarCalendar = builder.isLunarCalendar;
        timeSelectChangeListener = builder.timeSelectChangeListener;
        timeSelectListener = builder.timeSelectListener;
    }

    public static final class Builder {
        Context context;
        int layoutRes = R.layout.pickerview_time;
        View.OnClickListener cancelListener;
        CustomListener customListener;
        int inAnimRes = R.anim.pickerview_slide_in_bottom;
        int outAnimRes = R.anim.pickerview_slide_out_bottom;
        ViewGroup decorView;
        int textGravity = Gravity.CENTER;
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
        int dialogAnim = R.style.pickerScaleAnim;

        boolean[] type = new boolean[]{true, true, true, false, false, false};//显示类型，默认显示： 年月日
        String label_year, label_month, label_day, label_hours, label_minutes, label_seconds;//单位
        int x_offset_year, x_offset_month, x_offset_day, x_offset_hours, x_offset_minutes, x_offset_seconds;//单位
        Calendar date;//当前选中时间
        Calendar startDate;//开始时间
        Calendar endDate;//终止时间
        int startYear;//开始年份
        int endYear;//结尾年份
        boolean cyclic = false;//是否循环
        boolean isLunarCalendar = false;//是否显示农历
        OnTimeSelectChangeListener timeSelectChangeListener;
        OnTimeSelectListener timeSelectListener;

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

        /**
         * ViewGroup 类型的容器
         *
         * @param decorView 选择器会被添加到此容器中
         * @return TimePickerBuilder
         */
        public Builder setDecorView(ViewGroup decorView) {
            this.decorView = decorView;
            return this;
        }

        public Builder setTextGravity(int textGravity) {
            this.textGravity = textGravity;
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

        public Builder setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public Builder setDialogAnim(int dialogAnim) {
            this.dialogAnim = dialogAnim;
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

        /**
         * 设置分割线以外文字的颜色
         *
         * @param textColorOut
         * @return
         */
        public Builder setTextColorOut(int textColorOut) {
            this.textColorOut = textColorOut;
            return this;
        }

        public Builder setTextColorCenter(int textColorCenter) {
            this.textColorCenter = textColorCenter;
            return this;
        }

        /**
         * 设置分割线的颜色
         *
         * @param dividerColor
         * @return
         */
        public Builder setDividerColor(int dividerColor) {
            this.dividerColor = dividerColor;
            return this;
        }

        /**
         * 显示时的外部背景色颜色,默认是灰色
         *
         * @param outSideColor
         * @return
         */
        public Builder setOutSideColor(int outSideColor) {
            this.outSideColor = outSideColor;
            return this;
        }

        /**
         * 设置间距倍数,但是只能在1.0-4.0f之间
         *
         * @param lineSpacingMultiplier
         * @return
         */
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

        public Builder setFont(Typeface font) {
            this.font = font;
            return this;
        }

        /**
         * 设置分割线的类型
         *
         * @param dividerType
         * @return
         */
        public Builder setDividerType(WheelView.DividerType dividerType) {
            this.dividerType = dividerType;
            return this;
        }

        /**
         * 设置最大可见数目
         *
         * @param itemsVisibleCount suggest value: 3, 5, 7, 9
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

        /**
         * new boolean[]{true, true, true, false, false, false}
         * control the "year","month","day","hours","minutes","seconds " display or hide.
         * 分别控制“年”“月”“日”“时”“分”“秒”的显示或隐藏。
         *
         * @param type 布尔型数组，长度需要设置为6。
         * @return TimePickerBuilder
         */
        public Builder setType(boolean[] type) {
            this.type = type;
            return this;
        }

        public Builder setLabel(String label_year, String label_month, String label_day, String label_hours, String label_mins, String label_seconds) {
            this.label_year = label_year;
            this.label_month = label_month;
            this.label_day = label_day;
            this.label_hours = label_hours;
            this.label_minutes = label_mins;
            this.label_seconds = label_seconds;
            return this;
        }

        /**
         * 设置X轴倾斜角度[ -90 , 90°]
         *
         * @param x_offset_year    年
         * @param x_offset_month   月
         * @param x_offset_day     日
         * @param x_offset_hours   时
         * @param x_offset_minutes 分
         * @param x_offset_seconds 秒
         * @return
         */
        public Builder setTextXOffset(int x_offset_year, int x_offset_month, int x_offset_day,
                                      int x_offset_hours, int x_offset_minutes, int x_offset_seconds) {
            this.x_offset_year = x_offset_year;
            this.x_offset_month = x_offset_month;
            this.x_offset_day = x_offset_day;
            this.x_offset_hours = x_offset_hours;
            this.x_offset_minutes = x_offset_minutes;
            this.x_offset_seconds = x_offset_seconds;
            return this;
        }


        public Builder setDate(Calendar date) {
            this.date = date;
            return this;
        }

        /**
         * 设置起始时间
         * 因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         */
        public Builder setStartDate(Calendar startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * 设置起始时间
         * 因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         */
        public Builder setEndDate(Calendar endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setRangDate(Calendar startDate, Calendar endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
            return this;
        }

        public Builder setStartYear(int startYear) {
            this.startYear = startYear;
            return this;
        }

        public Builder setEndYear(int endYear) {
            this.endYear = endYear;
            return this;
        }

        public Builder setCyclic(boolean cyclic) {
            this.cyclic = cyclic;
            return this;
        }

        public Builder setLunarCalendar(boolean lunarCalendar) {
            isLunarCalendar = lunarCalendar;
            return this;
        }

        /**
         * 切换item项滚动停止时，实时回调监听。
         *
         * @param timeSelectChangeListener
         * @return
         */
        public Builder setTimeSelectChangeListener(OnTimeSelectChangeListener timeSelectChangeListener) {
            this.timeSelectChangeListener = timeSelectChangeListener;
            return this;
        }

        public Builder setTimeSelectListener(OnTimeSelectListener timeSelectListener) {
            this.timeSelectListener = timeSelectListener;
            return this;
        }

        public TimePickerView Builder() {
            TimePickerConfig timePickerBuilder = new TimePickerConfig(this);
            return new TimePickerView(timePickerBuilder);
        }

    }
}

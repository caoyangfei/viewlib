package com.flyang.view.picker;

import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flyang.view.R;
import com.flyang.view.picker.configure.TimePickerConfig;
import com.flyang.view.picker.lisenter.ISelectTimeCallback;
import com.flyang.view.picker.wheel.WheelTime;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static android.support.annotation.RestrictTo.Scope.LIBRARY;


/**
 * @author caoyangfei
 * @ClassName TimePickerView
 * @date 2019/11/5
 * ------------- Description -------------
 * 时间选择器
 */
@RestrictTo({LIBRARY})
public class TimePickerView extends BasePickerView implements View.OnClickListener {
    TimePickerConfig timePickerConfig;
    private WheelTime wheelTime; //自定义控件

    public TimePickerView(TimePickerConfig pickerOptions) {
        super(pickerOptions);
        timePickerConfig = pickerOptions;
        initView();
    }

    private void initView() {
        setDialogOutSideCancelable();
        initViews();
        initAnim();

        if (timePickerConfig.customListener == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, contentContainer);

            //顶部标题
            TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout rv_top_bar = (RelativeLayout) findViewById(R.id.rv_topbar);

            //确定和取消按钮
            Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
            Button btnCancel = (Button) findViewById(R.id.btnCancel);

            btnSubmit.setOnClickListener(this);
            btnCancel.setOnClickListener(this);
            tvTitle.setOnClickListener(null);

            //设置文字
            btnSubmit.setText(TextUtils.isEmpty(timePickerConfig.textContentConfirm) ? context.getResources().getString(R.string.pickerview_submit) : timePickerConfig.textContentConfirm);
            btnCancel.setText(TextUtils.isEmpty(timePickerConfig.textContentCancel) ? context.getResources().getString(R.string.pickerview_cancel) : timePickerConfig.textContentCancel);
            tvTitle.setText(TextUtils.isEmpty(timePickerConfig.textContentTitle) ? "" : timePickerConfig.textContentTitle);//默认为空

            //设置color
            btnSubmit.setTextColor(timePickerConfig.textColorConfirm);
            btnCancel.setTextColor(timePickerConfig.textColorCancel);
            tvTitle.setTextColor(timePickerConfig.textColorTitle);
            rv_top_bar.setBackgroundColor(timePickerConfig.bgColorTitle);

            //设置文字大小
            btnSubmit.setTextSize(timePickerConfig.textSizeSubmitCancel);
            btnCancel.setTextSize(timePickerConfig.textSizeSubmitCancel);
            tvTitle.setTextSize(timePickerConfig.textSizeTitle);

        } else {
            timePickerConfig.customListener.customLayout(LayoutInflater.from(context).inflate(timePickerConfig.layoutRes, contentContainer));
        }
        // 时间转轮 自定义控件
        LinearLayout timePickerView = (LinearLayout) findViewById(R.id.timePicker);
        timePickerView.setBackgroundColor(timePickerConfig.bgColorWheel);

        initWheelTime(timePickerView);
    }

    private void initWheelTime(LinearLayout timePickerView) {
        wheelTime = new WheelTime(timePickerView, timePickerConfig.type, timePickerConfig.textGravity, timePickerConfig.textSizeContent);
        if (timePickerConfig.timeSelectChangeListener != null) {
            wheelTime.setSelectChangeCallback(new ISelectTimeCallback() {
                @Override
                public void onTimeSelectChanged() {
                    try {
                        Date date = WheelTime.dateFormat.parse(wheelTime.getTime());
                        timePickerConfig.timeSelectChangeListener.onTimeSelectChanged(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        wheelTime.setLunarMode(timePickerConfig.isLunarCalendar);

        if (timePickerConfig.startYear != 0 && timePickerConfig.endYear != 0
                && timePickerConfig.startYear <= timePickerConfig.endYear) {
            setRange();
        }

        //若手动设置了时间范围限制
        if (timePickerConfig.startDate != null && timePickerConfig.endDate != null) {
            if (timePickerConfig.startDate.getTimeInMillis() > timePickerConfig.endDate.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            } else {
                setRangDate();
            }
        } else if (timePickerConfig.startDate != null) {
            if (timePickerConfig.startDate.get(Calendar.YEAR) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            } else {
                setRangDate();
            }
        } else if (timePickerConfig.endDate != null) {
            if (timePickerConfig.endDate.get(Calendar.YEAR) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            } else {
                setRangDate();
            }
        } else {//没有设置时间范围限制，则会使用默认范围。
            setRangDate();
        }

        setTime();
        wheelTime.setLabels(timePickerConfig.label_year, timePickerConfig.label_month, timePickerConfig.label_day
                , timePickerConfig.label_hours, timePickerConfig.label_minutes, timePickerConfig.label_seconds);
        wheelTime.setTextXOffset(timePickerConfig.x_offset_year, timePickerConfig.x_offset_month, timePickerConfig.x_offset_day,
                timePickerConfig.x_offset_hours, timePickerConfig.x_offset_minutes, timePickerConfig.x_offset_seconds);
        wheelTime.setItemsVisible(timePickerConfig.itemsVisibleCount);
        wheelTime.setAlphaGradient(timePickerConfig.isAlphaGradient);
        setOutSideCancelable(timePickerConfig.cancelable);
        wheelTime.setCyclic(timePickerConfig.cyclic);
        wheelTime.setDividerColor(timePickerConfig.dividerColor);
        wheelTime.setDividerType(timePickerConfig.dividerType);
        wheelTime.setLineSpacingMultiplier(timePickerConfig.lineSpacingMultiplier);
        wheelTime.setTextColorOut(timePickerConfig.textColorOut);
        wheelTime.setTextColorCenter(timePickerConfig.textColorCenter);
        wheelTime.isCenterLabel(timePickerConfig.isCenterLabel);
    }


    /**
     * 设置默认时间
     */
    public TimePickerView setDate(Calendar date) {
        timePickerConfig.date = date;
        setTime();
        return this;
    }

    /**
     * 设置可以选择的时间范围, 要在setTime之前调用才有效果
     */
    private void setRange() {
        wheelTime.setStartYear(timePickerConfig.startYear);
        wheelTime.setEndYear(timePickerConfig.endYear);
    }

    /**
     * 设置可以选择的时间范围, 要在setTime之前调用才有效果
     */
    private void setRangDate() {
        wheelTime.setRangDate(timePickerConfig.startDate, timePickerConfig.endDate);
        initDefaultSelectedDate();
    }

    private void initDefaultSelectedDate() {
        //如果手动设置了时间范围
        if (timePickerConfig.startDate != null && timePickerConfig.endDate != null) {
            //若默认时间未设置，或者设置的默认时间越界了，则设置默认选中时间为开始时间。
            if (timePickerConfig.date == null || timePickerConfig.date.getTimeInMillis() < timePickerConfig.startDate.getTimeInMillis()
                    || timePickerConfig.date.getTimeInMillis() > timePickerConfig.endDate.getTimeInMillis()) {
                timePickerConfig.date = timePickerConfig.startDate;
            }
        } else if (timePickerConfig.startDate != null) {
            //没有设置默认选中时间,那就拿开始时间当默认时间
            timePickerConfig.date = timePickerConfig.startDate;
        } else if (timePickerConfig.endDate != null) {
            timePickerConfig.date = timePickerConfig.endDate;
        }
    }

    /**
     * 设置选中时间,默认选中当前时间
     */
    private void setTime() {
        int year, month, day, hours, minute, seconds;
        Calendar calendar = Calendar.getInstance();

        if (timePickerConfig.date == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            hours = calendar.get(Calendar.HOUR_OF_DAY);
            minute = calendar.get(Calendar.MINUTE);
            seconds = calendar.get(Calendar.SECOND);
        } else {
            year = timePickerConfig.date.get(Calendar.YEAR);
            month = timePickerConfig.date.get(Calendar.MONTH);
            day = timePickerConfig.date.get(Calendar.DAY_OF_MONTH);
            hours = timePickerConfig.date.get(Calendar.HOUR_OF_DAY);
            minute = timePickerConfig.date.get(Calendar.MINUTE);
            seconds = timePickerConfig.date.get(Calendar.SECOND);
        }

        wheelTime.setPicker(year, month, day, hours, minute, seconds);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmit) {
            returnData();
        } else if (v.getId() == R.id.btnCancel) {
            if (timePickerConfig.cancelListener != null) {
                timePickerConfig.cancelListener.onClick(v);
            }
        }
        dismiss();
    }

    public void returnData() {
        if (timePickerConfig.timeSelectListener != null) {
            try {
                Date date = WheelTime.dateFormat.parse(wheelTime.getTime());
                timePickerConfig.timeSelectListener.onTimeSelect(clickView, date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 动态设置标题
     *
     * @param text 标题文本内容
     */
    public TimePickerView setTitleText(String text) {
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        if (tvTitle != null) {
            tvTitle.setText(text);
        }
        return this;
    }

    /**
     * 目前暂时只支持设置1900 - 2100年
     *
     * @param lunar 农历的开关
     */
    public TimePickerView setLunarCalendar(boolean lunar) {
        try {
            int year, month, day, hours, minute, seconds;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(WheelTime.dateFormat.parse(wheelTime.getTime()));
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            hours = calendar.get(Calendar.HOUR_OF_DAY);
            minute = calendar.get(Calendar.MINUTE);
            seconds = calendar.get(Calendar.SECOND);

            wheelTime.setLunarMode(lunar);
            wheelTime.setLabels(timePickerConfig.label_year, timePickerConfig.label_month, timePickerConfig.label_day,
                    timePickerConfig.label_hours, timePickerConfig.label_minutes, timePickerConfig.label_seconds);
            wheelTime.setPicker(year, month, day, hours, minute, seconds);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this;
    }

    public boolean isLunarCalendar() {
        return wheelTime.isLunarMode();
    }


    @Override
    public boolean isDialog() {
        return timePickerConfig.isDialog;
    }
}

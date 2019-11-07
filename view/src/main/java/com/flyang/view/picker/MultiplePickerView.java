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
import com.flyang.view.picker.configure.MultiplePickerConfig;
import com.flyang.view.picker.wheel.WheelMultiple;

import java.util.List;

import static android.support.annotation.RestrictTo.Scope.LIBRARY;

/**
 * @author yangfei.cao
 * @ClassName viewlib
 * @date 2019/11/5
 * ------------- Description -------------
 * 自定义个数选择器
 */
@RestrictTo({LIBRARY})
public class MultiplePickerView<T> extends BasePickerView implements View.OnClickListener {
    private MultiplePickerConfig multiplePickerConfig;
    private WheelMultiple<T> wheelMultiple;

    public MultiplePickerView(MultiplePickerConfig pickerOptions) {
        super(pickerOptions);
        multiplePickerConfig = pickerOptions;
        initView();
    }

    private void initView() {
        setDialogOutSideCancelable();
        initViews();
        initAnim();
        if (multiplePickerConfig.customListener == null) {
            LayoutInflater.from(context).inflate(multiplePickerConfig.layoutRes, contentContainer);
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
            btnSubmit.setText(TextUtils.isEmpty(multiplePickerConfig.textContentConfirm) ? context.getResources().getString(R.string.pickerview_submit) : multiplePickerConfig.textContentConfirm);
            btnCancel.setText(TextUtils.isEmpty(multiplePickerConfig.textContentCancel) ? context.getResources().getString(R.string.pickerview_cancel) : multiplePickerConfig.textContentCancel);
            tvTitle.setText(TextUtils.isEmpty(multiplePickerConfig.textContentTitle) ? "" : multiplePickerConfig.textContentTitle);//默认为空
            //设置color
            btnSubmit.setTextColor(multiplePickerConfig.textColorConfirm);
            btnCancel.setTextColor(multiplePickerConfig.textColorCancel);
            tvTitle.setTextColor(multiplePickerConfig.textColorTitle);
            rv_top_bar.setBackgroundColor(multiplePickerConfig.bgColorTitle);
            //设置文字大小
            btnSubmit.setTextSize(multiplePickerConfig.textSizeSubmitCancel);
            btnCancel.setTextSize(multiplePickerConfig.textSizeSubmitCancel);
            tvTitle.setTextSize(multiplePickerConfig.textSizeTitle);
        } else {
            multiplePickerConfig.customListener.customLayout(LayoutInflater.from(context).inflate(multiplePickerConfig.layoutRes, contentContainer));
        }
        setOutSideCancelable(multiplePickerConfig.cancelable);

        //选择控件
        LinearLayout multiplePicker = (LinearLayout) findViewById(R.id.multiplePicker);
        multiplePicker.setBackgroundColor(multiplePickerConfig.bgColorWheel);
        wheelMultiple = new WheelMultiple<>(multiplePicker, multiplePickerConfig);
    }

    public MultiplePickerView setPicker(List<T>... items) {
        if (wheelMultiple != null) {
            wheelMultiple.setPicker(items);
        }
        return this;
    }

    /**
     * 设置默认选中项
     *
     * @param currentItem
     */
    public MultiplePickerView setSelectItem(int currentItem) {
        if (wheelMultiple != null) {
            wheelMultiple.setCurrentItems(currentItem);
        }
        return this;
    }


    private MultiplePickerView setTextContentSize(int textSizeContent) {
        if (wheelMultiple != null) {
            wheelMultiple.setTextContentSize(textSizeContent);
        }
        return this;
    }

    private MultiplePickerView setLabels(String... labels) {
        if (wheelMultiple != null) {
            wheelMultiple.setLabels(labels);
        }
        return this;
    }

    public MultiplePickerView setLineSpacingMultiplier(float lineSpacingMultiplier) {
        if (wheelMultiple != null) {
            wheelMultiple.setLineSpacingMultiplier(lineSpacingMultiplier);
        }
        return this;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmit) {
            returnData();
        } else if (v.getId() == R.id.btnCancel) {
            if (multiplePickerConfig.cancelListener != null) {
                multiplePickerConfig.cancelListener.onClick(v);
            }
        }
        dismiss();
    }

    //抽离接口回调的方法
    public void returnData() {
        if (multiplePickerConfig.onMultipleSelectLisenter != null) {
            int[] currentItems = wheelMultiple.getCurrentItems();
            multiplePickerConfig.onMultipleSelectLisenter.OnMultipleSelect(clickView, currentItems);
        }
    }

    @Override
    public boolean isDialog() {
        return multiplePickerConfig.isDialog;
    }
}

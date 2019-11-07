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
import com.flyang.view.picker.configure.OptionsPickerConfig;
import com.flyang.view.picker.wheel.WheelOptions;

import java.util.List;

import static android.support.annotation.RestrictTo.Scope.LIBRARY;


/**
 * @author caoyangfei
 * @ClassName OptionsPickerView
 * @date 2019/11/5
 * ------------- Description -------------
 * 联动选择器
 */
@RestrictTo({LIBRARY})
public class OptionsPickerView<Fst, Snd, Trd> extends BasePickerView implements View.OnClickListener {
    OptionsPickerConfig optionsPickerConfig;

    private WheelOptions<Fst, Snd, Trd> wheelOptions;

    public OptionsPickerView(OptionsPickerConfig pickerOptions) {
        super(pickerOptions);
        optionsPickerConfig = pickerOptions;
        initView();
    }

    private void initView() {
        setDialogOutSideCancelable();
        initViews();
        initAnim();
        if (optionsPickerConfig.customListener == null) {
            LayoutInflater.from(context).inflate(optionsPickerConfig.layoutRes, contentContainer);

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
            btnSubmit.setText(TextUtils.isEmpty(optionsPickerConfig.textContentConfirm) ? context.getResources().getString(R.string.pickerview_submit) : optionsPickerConfig.textContentConfirm);
            btnCancel.setText(TextUtils.isEmpty(optionsPickerConfig.textContentCancel) ? context.getResources().getString(R.string.pickerview_cancel) : optionsPickerConfig.textContentCancel);
            tvTitle.setText(TextUtils.isEmpty(optionsPickerConfig.textContentTitle) ? "" : optionsPickerConfig.textContentTitle);//默认为空

            //设置color
            btnSubmit.setTextColor(optionsPickerConfig.textColorConfirm);
            btnCancel.setTextColor(optionsPickerConfig.textColorCancel);
            tvTitle.setTextColor(optionsPickerConfig.textColorTitle);
            rv_top_bar.setBackgroundColor(optionsPickerConfig.bgColorTitle);

            //设置文字大小
            btnSubmit.setTextSize(optionsPickerConfig.textSizeSubmitCancel);
            btnCancel.setTextSize(optionsPickerConfig.textSizeSubmitCancel);
            tvTitle.setTextSize(optionsPickerConfig.textSizeTitle);
        } else {
            optionsPickerConfig.customListener.customLayout(LayoutInflater.from(context).inflate(optionsPickerConfig.layoutRes, contentContainer));
        }

        //滚轮布局
        final LinearLayout optionsPicker = (LinearLayout) findViewById(R.id.optionsPicker);
        optionsPicker.setBackgroundColor(optionsPickerConfig.bgColorWheel);

        wheelOptions = new WheelOptions<>(optionsPicker, optionsPickerConfig.isRestoreItem);
        if (optionsPickerConfig.optionsSelectChangeListener != null) {
            wheelOptions.setOptionsSelectChangeListener(optionsPickerConfig.optionsSelectChangeListener);
        }

        wheelOptions.setTextContentSize(optionsPickerConfig.textSizeContent);
        wheelOptions.setItemsVisible(optionsPickerConfig.itemsVisibleCount);
        wheelOptions.setAlphaGradient(optionsPickerConfig.isAlphaGradient);
        wheelOptions.setLabels(optionsPickerConfig.label1, optionsPickerConfig.label2, optionsPickerConfig.label3);
        wheelOptions.setTextXOffset(optionsPickerConfig.x_offset_one, optionsPickerConfig.x_offset_two, optionsPickerConfig.x_offset_three);
        wheelOptions.setCyclic(optionsPickerConfig.cyclic1, optionsPickerConfig.cyclic2, optionsPickerConfig.cyclic3);
        wheelOptions.setTypeface(optionsPickerConfig.font);

        setOutSideCancelable(optionsPickerConfig.cancelable);

        wheelOptions.setDividerColor(optionsPickerConfig.dividerColor);
        wheelOptions.setDividerType(optionsPickerConfig.dividerType);
        wheelOptions.setLineSpacingMultiplier(optionsPickerConfig.lineSpacingMultiplier);
        wheelOptions.setTextColorOut(optionsPickerConfig.textColorOut);
        wheelOptions.setTextColorCenter(optionsPickerConfig.textColorCenter);
        wheelOptions.isCenterLabel(optionsPickerConfig.isCenterLabel);
    }

    /**
     * 设置默认选中项
     *
     * @param option1
     */
    public OptionsPickerView setSelectOptions(int option1) {
        optionsPickerConfig.option1 = option1;
        reSetCurrentItems();
        return this;
    }

    public OptionsPickerView setSelectOptions(int option1, int option2) {
        optionsPickerConfig.option1 = option1;
        optionsPickerConfig.option2 = option2;
        reSetCurrentItems();
        return this;
    }

    public OptionsPickerView setSelectOptions(int option1, int option2, int option3) {
        optionsPickerConfig.option1 = option1;
        optionsPickerConfig.option2 = option2;
        optionsPickerConfig.option3 = option3;
        reSetCurrentItems();
        return this;
    }

    private void reSetCurrentItems() {
        if (wheelOptions != null) {
            wheelOptions.setCurrentItems(optionsPickerConfig.option1, optionsPickerConfig.option2, optionsPickerConfig.option3);
        }
    }

    public OptionsPickerView setPicker(List<Fst> optionsItems) {
        setPicker(optionsItems, null, null);
        return this;
    }

    public OptionsPickerView setPicker(List<Fst> options1Items, List<List<Snd>> options2Items) {
        setPicker(options1Items, options2Items, null);
        return this;
    }

    public OptionsPickerView setPicker(List<Fst> options1Items,
                                       List<List<Snd>> options2Items,
                                       List<List<List<Trd>>> options3Items) {
        wheelOptions.setPicker(options1Items, options2Items, options3Items);
        reSetCurrentItems();
        return this;
    }

    //不联动情况下调用
    public OptionsPickerView setNPicker(List<Fst> options1Items,
                                        List<Snd> options2Items,
                                        List<Trd> options3Items) {
        wheelOptions.setLinkage(false);
        wheelOptions.setNPicker(options1Items, options2Items, options3Items);
        reSetCurrentItems();
        return this;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmit) {
            returnData();
        } else if (v.getId() == R.id.btnCancel) {
            if (optionsPickerConfig.cancelListener != null) {
                optionsPickerConfig.cancelListener.onClick(v);
            }
        }
        dismiss();
    }

    //抽离接口回调的方法
    public void returnData() {
        if (optionsPickerConfig.optionsSelectListener != null) {
            int[] optionsCurrentItems = wheelOptions.getCurrentItems();
            optionsPickerConfig.optionsSelectListener.onOptionsSelect(clickView, optionsCurrentItems[0], optionsCurrentItems[1], optionsCurrentItems[2]);
        }
    }

    @Override
    public boolean isDialog() {
        return optionsPickerConfig.isDialog;
    }
}

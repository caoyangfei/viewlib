package com.flyang.view.picker.wheel;

import android.widget.LinearLayout;

import com.flyang.view.picker.adapter.ArrayWheelAdapter;
import com.flyang.view.picker.configure.MultiplePickerConfig;
import com.flyang.view.wheel.WheelView;
import com.flyang.view.wheel.listener.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * @author yangfei.cao
 * @ClassName viewlib
 * @date 2019/11/5
 * ------------- Description -------------
 * 自定义数量选择器
 */
public class WheelMultiple<T> {
    protected MultiplePickerConfig multiplePickerConfig;
    private LinearLayout view;

    private List<WheelView> wheelViews = new LinkedList<>();

    private List<OnItemSelectedListener> onItemSelectedListeners = new ArrayList<>();

    private OnItemSelectedListener onItemSelectedListener;

    public WheelMultiple(LinearLayout view, MultiplePickerConfig pickerOptions) {
        this.view = view;
        multiplePickerConfig = pickerOptions;
    }

    public void setPicker(List<T>... items) {
        view.removeAllViews();
        wheelViews.clear();
        onItemSelectedListeners.clear();
        int[] currentItems = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            WheelView wheelView = new WheelView(multiplePickerConfig.context);
            wheelView.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT, 1.0f));
            wheelView.setTextColorCenter(multiplePickerConfig.textColorCenter);
            wheelView.setTextSize(multiplePickerConfig.textSizeContent);
            wheelView.setItemsVisibleCount(multiplePickerConfig.itemsVisibleCount);
            wheelView.setAlphaGradient(multiplePickerConfig.isAlphaGradient);
            wheelView.setTextXOffset(multiplePickerConfig.x_offset);
            wheelView.setCyclic(multiplePickerConfig.cyclic);
            wheelView.setTypeface(multiplePickerConfig.font);
            wheelView.setDividerColor(multiplePickerConfig.dividerColor);
            wheelView.setDividerType(multiplePickerConfig.dividerType);
            wheelView.setLineSpacingMultiplier(multiplePickerConfig.lineSpacingMultiplier);
            wheelView.setTextColorOut(multiplePickerConfig.textColorOut);
            wheelView.isCenterLabel(multiplePickerConfig.isCenterLabel);
            if (multiplePickerConfig.label != null && i < multiplePickerConfig.label.length) {
                wheelView.setLabel(multiplePickerConfig.label[i]);
            }
            wheelView.setCurrentItem(multiplePickerConfig.currentItem);
            onItemSelectedListener = new OnItemSelectedListener() {
                @Override
                public void onItemSelected(int index) {
                    //监听器数量,定位到监听位置
                    int i1 = onItemSelectedListeners.indexOf(this);
                    currentItems[i1] = index;
                    if (multiplePickerConfig.onMultipleSelectChangeLisenter != null) {
                        multiplePickerConfig.onMultipleSelectChangeLisenter.OnMultipleSelectChanged(currentItems);
                    }
                }
            };
            onItemSelectedListeners.add(onItemSelectedListener);
            wheelView.setOnItemSelectedListener(onItemSelectedListener);
            wheelView.setAdapter(new ArrayWheelAdapter(items[i]));
            view.addView(wheelView);
            wheelViews.add(wheelView);
        }
    }

    public void setCurrentItems(int currentItem) {
        for (WheelView wheelView : wheelViews) {
            wheelView.setCurrentItem(currentItem);
        }
    }

    public void setTextContentSize(int textSizeContent) {
        for (WheelView wheelView : wheelViews) {
            wheelView.setCurrentItem(textSizeContent);
        }
    }

    /**
     * 设置选项的单位
     */
    public void setLabels(String... labels) {
        for (int i = 0; i < wheelViews.size(); i++) {
            WheelView wheelView = wheelViews.get(i);
            if (labels != null && i < labels.length) {
                wheelView.setLabel(labels[i]);
            }
        }

    }

    /**
     * 设置间距倍数,但是只能在1.2-4.0f之间
     *
     * @param lineSpacingMultiplier
     */
    public void setLineSpacingMultiplier(float lineSpacingMultiplier) {
        for (WheelView wheelView : wheelViews) {
            wheelView.setLineSpacingMultiplier(lineSpacingMultiplier);
        }
    }

    /**
     * 返回当前选中的结果对应的位置数组 因为支持三级联动效果，分三个级别索引，0，1，2。
     * 在快速滑动未停止时，点击确定按钮，会进行判断，如果匹配数据越界，则设为0，防止index出错导致崩溃。
     *
     * @return 索引数组
     */
    public int[] getCurrentItems() {
        int[] currentItems = new int[wheelViews.size()];
        for (int i = 0; i < wheelViews.size(); i++) {
            currentItems[i] = wheelViews.get(i).getCurrentItem();
        }
        return currentItems;
    }

}

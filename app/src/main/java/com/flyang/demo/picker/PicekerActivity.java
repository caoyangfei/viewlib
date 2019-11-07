package com.flyang.demo.picker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flyang.demo.R;
import com.flyang.view.picker.MultiplePickerView;
import com.flyang.view.picker.configure.MultiplePickerConfig;
import com.flyang.view.picker.lisenter.OnMultipleSelectChangeLisenter;

import java.util.LinkedList;

/**
 * @author yangfei.cao
 * @ClassName viewlib
 * @date 2019/11/7
 * ------------- Description -------------
 */
public class PicekerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
    }

    public void onPickerClick(View view) {
        MultiplePickerView builder = new MultiplePickerConfig.Builder(this)
                .setDecorView(findViewById(R.id.fragmen_fragment))
                .setOnMultipleSelectChangeLisenter(new OnMultipleSelectChangeLisenter() {
                    @Override
                    public void OnMultipleSelectChanged(int... select) {
                        int length = select.length;
                    }
                })
                .setCancelable(false)
                .Builder();
        LinkedList<String> card = new LinkedList<>();
        card.add("京");
        card.add("津");
        card.add("冀");
        card.add("晋");
        card.add("蒙");
        LinkedList<String> cardNum = new LinkedList<>();
        cardNum.add("1");
        cardNum.add("2");
        cardNum.add("3");
        cardNum.add("4");
        cardNum.add("5");
        builder.setPicker(card, cardNum).show();

//        Calendar selectedDate = Calendar.getInstance();
//
//        Calendar startDate = Calendar.getInstance();
//        startDate.set(2013, 0, 23);
//
//        Calendar endDate = Calendar.getInstance();
//        endDate.set(2019, 11, 28);
//
//        TimePickerView builder = new TimePickerConfig.Builder(this).setTimeSelectListener(new OnTimeSelectListener() {
//            @Override
//            public void onTimeSelect(View v, Date date) {
//
//            }
//        })
//                .setType(new boolean[]{true, true, true, false, false, false})
//                .setLabel("", "", "", "", "", "") //设置空字符串以隐藏单位提示   hide label
//                .setDividerColor(Color.DKGRAY)
//                .setDate(selectedDate)
//                .setStartDate(startDate)
//                .setEndDate(endDate)
//                .setOutSideColor(0x00000000)
//                .setCancelable(false).Builder();
//        builder.show();
    }
}

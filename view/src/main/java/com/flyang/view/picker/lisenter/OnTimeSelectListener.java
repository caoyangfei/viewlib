package com.flyang.view.picker.lisenter;

import android.view.View;

import java.util.Date;


/**
 * @author caoyangfei
 * @ClassName OnTimeSelectListener
 * @date 2019/11/5
 * ------------- Description -------------
 * 时间选择监听
 */
public interface OnTimeSelectListener {

    void onTimeSelect(View v, Date date);
}

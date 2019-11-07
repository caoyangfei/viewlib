package com.flyang.view.picker.lisenter;

import android.view.View;


/**
 * @author caoyangfei
 * @ClassName OnOptionsSelectListener
 * @date 2019/11/5
 * ------------- Description -------------
 * 三级联动监听
 */
public interface OnOptionsSelectListener {

    void onOptionsSelect(View v,int options1, int options2, int options3 );
}

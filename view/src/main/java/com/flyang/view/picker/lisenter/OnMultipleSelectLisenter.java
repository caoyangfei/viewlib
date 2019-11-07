package com.flyang.view.picker.lisenter;

import android.view.View;

/**
 * @author yangfei.cao
 * @ClassName viewlib
 * @date 2019/11/7
 * ------------- Description -------------
 * 自定义选择监听
 */
public interface OnMultipleSelectLisenter {
    void OnMultipleSelect(View v, int... select);
}

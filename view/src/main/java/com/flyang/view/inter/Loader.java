package com.flyang.view.inter;

import android.text.TextUtils;

/**
 * @author caoyangfei
 * @ClassName Loader
 * @date 2019/6/29
 * ------------- Description -------------
 * 加载接口
 */
public interface Loader {

    default void showLoader(String msg) {
        if (TextUtils.isEmpty(msg))
            msg = "正在处理中。。。！";
    }

    void closeLoader();

    default void showMsg(String msg) {
        if (TextUtils.isEmpty(msg))
            msg = "正在处理中。。。！";
    }

    default void showResultMsg(String msg, boolean isSuccess) {
        if (TextUtils.isEmpty(msg))
            if (isSuccess) {
                msg = "操作成功！";
            } else {
                msg = "加载失败！";
            }
    }

    void setLoadingText(String str);

    void setLoadingTextColor(int color);
}

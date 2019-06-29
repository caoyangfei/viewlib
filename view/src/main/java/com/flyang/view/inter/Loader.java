package com.flyang.view.inter;

/**
 * @author caoyangfei
 * @ClassName Loader
 * @date 2019/6/29
 * ------------- Description -------------
 * 加载接口
 */
public interface Loader {

    void showLoader(String msg);

    void closeLoader();

    void showMsg(String msg);

    void showResultMsg(String msg, boolean isSuccess);
}

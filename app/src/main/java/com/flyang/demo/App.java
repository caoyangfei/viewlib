package com.flyang.demo;

import android.app.Application;

import com.flyang.util.app.ApplicationUtils;

/**
 * @author yangfei.cao
 * @ClassName viewlib
 * @date 2019/6/29
 * ------------- Description -------------
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationUtils.init(this);
    }
}

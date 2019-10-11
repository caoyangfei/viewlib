package com.flyang.view.layout.refresh.listener;

import android.content.Context;
import android.support.annotation.NonNull;

import com.flyang.view.layout.refresh.inter.RefreshLayout;


/**
 * @author caoyangfei
 * @ClassName DefaultRefreshInitializer
 * @date 2019/10/11
 * ------------- Description -------------
 * 默认全局初始化接口
 */
public interface DefaultRefreshInitializer {
    void initialize(@NonNull Context context, @NonNull RefreshLayout layout);
}

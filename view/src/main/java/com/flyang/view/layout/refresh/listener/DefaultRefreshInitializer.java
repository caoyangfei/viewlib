package com.flyang.view.layout.refresh.listener;

import android.content.Context;
import android.support.annotation.NonNull;

import com.flyang.view.layout.refresh.inter.RefreshLayout;


/**
 * 默认全局初始化器
 * Created by scwang on 2018/5/29 0029.
 */
public interface DefaultRefreshInitializer {
    void initialize(@NonNull Context context, @NonNull RefreshLayout layout);
}

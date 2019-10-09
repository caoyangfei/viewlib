package com.flyang.view.layout.refresh.listener;

import android.content.Context;
import android.support.annotation.NonNull;

import com.flyang.view.layout.refresh.inter.RefreshHeader;
import com.flyang.view.layout.refresh.inter.RefreshLayout;


/**
 * 默认Header创建器
 * Created by scwang on 2018/1/26.
 */
public interface DefaultRefreshHeaderCreator {
    @NonNull
    RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout);
}

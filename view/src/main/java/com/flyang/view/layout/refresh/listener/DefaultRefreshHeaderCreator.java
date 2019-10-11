package com.flyang.view.layout.refresh.listener;

import android.content.Context;
import android.support.annotation.NonNull;

import com.flyang.view.layout.refresh.inter.RefreshHeader;
import com.flyang.view.layout.refresh.inter.RefreshLayout;


/**
 * @author caoyangfei
 * @ClassName DefaultRefreshHeaderCreator
 * @date 2019/10/11
 * ------------- Description -------------
 * 默认头部创建接口
 */
public interface DefaultRefreshHeaderCreator {
    @NonNull
    RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout);
}

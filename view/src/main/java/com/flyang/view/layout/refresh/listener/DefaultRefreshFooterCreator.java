package com.flyang.view.layout.refresh.listener;

import android.content.Context;
import android.support.annotation.NonNull;

import com.flyang.view.layout.refresh.inter.RefreshFooter;
import com.flyang.view.layout.refresh.inter.RefreshLayout;


/**
 * @author caoyangfei
 * @ClassName DefaultRefreshFooterCreator
 * @date 2019/10/11
 * ------------- Description -------------
 * 默认Footer创建接口
 */
public interface DefaultRefreshFooterCreator {
    @NonNull
    RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout);
}

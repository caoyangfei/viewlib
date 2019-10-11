package com.flyang.view.layout.refresh.listener;

import android.support.annotation.NonNull;

import com.flyang.util.log.LogUtils;
import com.flyang.view.layout.refresh.inter.RefreshLayout;


/**
 * @author caoyangfei
 * @ClassName OnLoadMoreListener
 * @date 2019/10/10
 * ------------- Description -------------
 * 加载更多监听
 */
public interface OnLoadMoreListener {
    default void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        LogUtils.tag("SmartRefresh").d("LoadMore:加载更多");
    }
}

package com.flyang.view.layout.refresh.listener;

import android.support.annotation.NonNull;

import com.flyang.view.layout.refresh.inter.RefreshLayout;


/**
 * @author caoyangfei
 * @ClassName OnLoadMoreListener
 * @date 2019/10/10
 * ------------- Description -------------
 * 加载更多监听器
 */
public interface OnLoadMoreListener {
    void onLoadMore(@NonNull RefreshLayout refreshLayout);
}

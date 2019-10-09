package com.flyang.view.layout.refresh.listener;

import android.support.annotation.NonNull;

import com.flyang.view.layout.refresh.inter.RefreshLayout;


/**
 * 刷新监听器
 * Created by scwang on 2017/5/26.
 */
public interface OnRefreshListener {
    void onRefresh(@NonNull RefreshLayout refreshLayout);
}

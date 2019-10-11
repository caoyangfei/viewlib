package com.flyang.view.layout.refresh.listener;

import android.support.annotation.NonNull;

import com.flyang.util.log.LogUtils;
import com.flyang.view.layout.refresh.inter.RefreshLayout;


/**
 * @author caoyangfei
 * @ClassName OnRefreshListener
 * @date 2019/10/11
 * ------------- Description -------------
 * 刷新监听
 */
public interface OnRefreshListener {
    default void onRefresh(@NonNull RefreshLayout refreshLayout) {
        LogUtils.tag("SmartRefresh").d("Refresh:刷新");
    }
}

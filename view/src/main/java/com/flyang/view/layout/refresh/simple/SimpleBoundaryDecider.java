package com.flyang.view.layout.refresh.simple;

import android.graphics.PointF;
import android.view.View;

import com.flyang.view.layout.refresh.listener.ScrollBoundaryDecider;
import com.flyang.view.layout.refresh.util.SmartUtil;


/**
 * @author caoyangfei
 * @ClassName SimpleBoundaryDecider
 * @date 2019/10/11
 * ------------- Description -------------
 * 滚动边界
 */
public class SimpleBoundaryDecider implements ScrollBoundaryDecider {

    //<editor-fold desc="Internal">
    public PointF mActionEvent;
    public ScrollBoundaryDecider boundary;
    public boolean mEnableLoadMoreWhenContentNotFull = true;

    @Override
    public boolean canRefresh(View content) {
        if (boundary != null) {
            return boundary.canRefresh(content);
        }
        //mActionEvent == null 时 canRefresh 不会动态递归搜索
        return SmartUtil.canRefresh(content, mActionEvent);
    }

    @Override
    public boolean canLoadMore(View content) {
        if (boundary != null) {
            return boundary.canLoadMore(content);
        }
        //mActionEvent == null 时 canLoadMore 不会动态递归搜索
        return SmartUtil.canLoadMore(content, mActionEvent, mEnableLoadMoreWhenContentNotFull);
    }
}

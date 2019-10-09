package com.flyang.view.layout.refresh.simple;

import android.support.annotation.NonNull;

import com.flyang.view.layout.refresh.constant.RefreshState;
import com.flyang.view.layout.refresh.inter.RefreshFooter;
import com.flyang.view.layout.refresh.inter.RefreshHeader;
import com.flyang.view.layout.refresh.inter.RefreshLayout;
import com.flyang.view.layout.refresh.listener.OnMultiListener;


/**
 * 多功能监听器
 * Created by scwang on 2017/5/26.
 */
public class SimpleMultiListener implements OnMultiListener {

    @Override
    public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {

    }

    @Override
    public void onHeaderReleased(RefreshHeader header, int headerHeight, int maxDragHeight) {

    }

    @Override
    public void onHeaderStartAnimator(RefreshHeader header, int footerHeight, int maxDragHeight) {

    }

    @Override
    public void onHeaderFinish(RefreshHeader header, boolean success) {

    }

    @Override
    public void onFooterMoving(RefreshFooter footer, boolean isDragging, float percent, int offset, int footerHeight, int maxDragHeight) {

    }

    @Override
    public void onFooterReleased(RefreshFooter footer, int footerHeight, int maxDragHeight) {

    }

    @Override
    public void onFooterStartAnimator(RefreshFooter footer, int headerHeight, int maxDragHeight) {

    }

    @Override
    public void onFooterFinish(RefreshFooter footer, boolean success) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {

    }

}

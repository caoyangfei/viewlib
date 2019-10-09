package com.flyang.view.layout.refresh.listener;

import android.support.annotation.NonNull;

import com.flyang.view.layout.refresh.constant.RefreshState;
import com.flyang.view.layout.refresh.inter.RefreshFooter;
import com.flyang.view.layout.refresh.inter.RefreshHeader;
import com.flyang.view.layout.refresh.inter.RefreshLayout;


/**
 * 多功能监听器
 * Created by scwang on 2017/5/26.
 */
public class SimpleMultiPurposeListener implements OnMultiPurposeListener, OnMultiListener {

    protected RefreshLayout refreshLayout;
    protected OnMultiPurposeListener listener;

    public SimpleMultiPurposeListener() {

    }

    public SimpleMultiPurposeListener(OnMultiPurposeListener listener, RefreshLayout refreshLayout) {
        this.listener = listener;
        this.refreshLayout = refreshLayout;
    }

    @Override
    public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
        if (listener != null) {
            listener.onHeaderMoving(header, isDragging, percent, offset, headerHeight, maxDragHeight);
        }
    }

    @Override
    public void onHeaderReleased(RefreshHeader header, int headerHeight, int maxDragHeight) {
        if (listener != null) {
            listener.onHeaderReleased(header, headerHeight, maxDragHeight);
        }
    }

    @Override
    public void onHeaderStartAnimator(RefreshHeader header, int footerHeight, int maxDragHeight) {
        if (listener != null) {
            listener.onHeaderStartAnimator(header, footerHeight, maxDragHeight);
        }
    }

    @Override
    public void onHeaderFinish(RefreshHeader header, boolean success) {
        if (listener != null) {
            listener.onHeaderFinish(header, success);
        }
    }

    @Override
    public void onFooterMoving(RefreshFooter footer, boolean isDragging, float percent, int offset, int footerHeight, int maxDragHeight) {
        if (listener != null) {
            listener.onFooterMoving(footer, isDragging, percent, offset, footerHeight, maxDragHeight);
        }
    }

    @Override
    public void onFooterReleased(RefreshFooter footer, int footerHeight, int maxDragHeight) {
        if (listener != null) {
            listener.onFooterReleased(footer, footerHeight, maxDragHeight);
        }
    }

    @Override
    public void onFooterStartAnimator(RefreshFooter footer, int headerHeight, int maxDragHeight) {
        if (listener != null) {
            listener.onFooterStartAnimator(footer, headerHeight, maxDragHeight);
        }
    }

    @Override
    public void onFooterFinish(RefreshFooter footer, boolean success) {
        if (listener != null) {
            listener.onFooterFinish(footer, success);
        }
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        if (listener != null) {
            listener.onRefresh(refreshLayout);
        }
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        if (listener != null) {
            listener.onLoadMore(refreshLayout);
        }
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        if (listener != null) {
            listener.onStateChanged(refreshLayout, oldState, newState);
        }
    }

}

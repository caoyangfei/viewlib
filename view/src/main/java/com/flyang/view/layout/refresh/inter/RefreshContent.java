package com.flyang.view.layout.refresh.inter;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;

import com.flyang.view.layout.refresh.listener.ScrollBoundaryDecider;

/**
 * @author caoyangfei
 * @ClassName RefreshContent
 * @date 2019/10/10
 * ------------- Description -------------
 * 刷新内容组件
 */
public interface RefreshContent {

    @NonNull
    View getView();

    @NonNull
    View getScrollableView();

    void onActionDown(MotionEvent e);

    void setUpComponent(RefreshKernel kernel, View fixedHeader, View fixedFooter);

    void setScrollBoundaryDecider(ScrollBoundaryDecider boundary);

    /**
     * 设置内容不满一页是否可以加载更多
     *
     * @param enable
     */
    void setEnableLoadMoreWhenContentNotFull(boolean enable);

    void moveSpinner(int spinner, int headerTranslationViewId, int footerTranslationViewId);

    /**
     * 是否可以刷新
     *
     * @return
     */
    boolean canRefresh();

    /**
     * 是否能加载更多
     *
     * @return
     */
    boolean canLoadMore();

    AnimatorUpdateListener scrollContentWhenFinished(int spinner);
}

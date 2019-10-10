package com.flyang.view.layout.refresh.listener;


import com.flyang.util.log.LogUtils;
import com.flyang.view.layout.refresh.inter.RefreshFooter;
import com.flyang.view.layout.refresh.inter.RefreshHeader;

/**
 * @author caoyangfei
 * @ClassName OnMultiListener
 * @date 2019/10/10
 * ------------- Description -------------
 * 多功能监听器
 */
public interface OnMultiListener extends OnRefreshLoadMoreListener, OnStateChangedListener {
    /**
     * 手指拖动下拉（会连续多次调用，添加isDragging并取代之前的onPulling、onReleasing）
     *
     * @param header        头部
     * @param isDragging    true 手指正在拖动 false 回弹动画
     * @param percent       下拉的百分比 值 = offset/footerHeight (0 - percent - (footerHeight+maxDragHeight) / footerHeight )
     * @param offset        下拉的像素偏移量  0 - offset - (footerHeight+maxDragHeight)
     * @param headerHeight  高度 HeaderHeight or FooterHeight
     * @param maxDragHeight 最大拖动高度
     */
    default void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
    }

    /**
     * 头部释放
     *
     * @param header
     * @param headerHeight
     * @param maxDragHeight
     */
    default void onHeaderReleased(RefreshHeader header, int headerHeight, int maxDragHeight) {
        LogUtils.tag("Refresh").d("Header:头部释放");
    }

    /**
     * 头部开始动画
     *
     * @param header
     * @param headerHeight
     * @param maxDragHeight
     */
    default void onHeaderStartAnimator(RefreshHeader header, int headerHeight, int maxDragHeight) {
        LogUtils.tag("Refresh").d("Header:头部开始动画");
    }

    /**
     * 头部消失
     *
     * @param header
     * @param success
     */
    default void onHeaderFinish(RefreshHeader header, boolean success) {
        LogUtils.tag("Refresh").d("Header:头部消失");
    }

    /**
     * 手指拖动上拉（会连续多次调用，添加isDragging并取代之前的onPulling、onReleasing）
     *
     * @param footer        尾部
     * @param isDragging    true 手指正在拖动 false 回弹动画
     * @param percent       下拉的百分比 值 = offset/footerHeight (0 - percent - (footerHeight+maxDragHeight) / footerHeight )
     * @param offset        下拉的像素偏移量  0 - offset - (footerHeight+maxDragHeight)
     * @param footerHeight  高度 HeaderHeight or FooterHeight
     * @param maxDragHeight 最大拖动高度
     */
    default void onFooterMoving(RefreshFooter footer, boolean isDragging, float percent, int offset, int footerHeight, int maxDragHeight) {
    }

    /**
     * 底部释放
     *
     * @param footer
     * @param footerHeight
     * @param maxDragHeight
     */
    default void onFooterReleased(RefreshFooter footer, int footerHeight, int maxDragHeight) {
        LogUtils.tag("Refresh").d("Footer:底部释放");
    }

    /**
     * 底部开始动画
     *
     * @param footer
     * @param footerHeight
     * @param maxDragHeight
     */
    default void onFooterStartAnimator(RefreshFooter footer, int footerHeight, int maxDragHeight) {
        LogUtils.tag("Refresh").d("Footer:底部开始动画");
    }

    /**
     * 底部消失
     *
     * @param footer
     * @param success
     */
    default void onFooterFinish(RefreshFooter footer, boolean success) {
        LogUtils.tag("Refresh").d("Footer:底部消失");
    }
}

package com.flyang.view.inter;

/**
 * @author yangfei.cao
 * @ClassName Delegate
 * @date 2019/6/29
 * ------------- Description -------------
 * 侧滑返回
 */
public interface Delegate {
    /**
     * 是否支持滑动返回
     *
     * @return
     */
    boolean isSupportSwipeBack();

    /**
     * 正在滑动返回
     *
     * @param slideOffset 从 0 到 1
     */
    void onSwipeBackLayoutSlide(float slideOffset);

    /**
     * 没达到滑动返回的阈值，取消滑动返回动作，回到默认状态
     */
    void onSwipeBackLayoutCancel();

    /**
     * 滑动返回执行完毕，销毁当前 Activity
     */
    void onSwipeBackLayoutExecuted();

}

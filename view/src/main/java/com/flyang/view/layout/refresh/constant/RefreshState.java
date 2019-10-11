package com.flyang.view.layout.refresh.constant;

/**
 * @author caoyangfei
 * @ClassName RefreshState
 * @date 2019/10/10
 * ------------- Description -------------
 * 刷新状态
 */
@SuppressWarnings("unused")
public enum RefreshState {
    //初始化
    None(0, false, false, false, false, false),
    //下拉刷新
    PullDownToRefresh(1, true, false, false, false, false),
    //上拉加载
    PullUpToLoad(2, true, false, false, false, false),
    //下拉刷新取消
    PullDownCanceled(1, false, false, false, false, false),
    //上拉加载取消
    PullUpCanceled(2, false, false, false, false, false),
    //达到可以释放刷新位置
    ReleaseToRefresh(1, true, false, false, false, true),
    //达到可以释放加载位置
    ReleaseToLoad(2, true, false, false, false, true),
    //达到可以释放二级刷新位置
    ReleaseToTwoLevel(1, true, false, false, true, true),
    //释放开始二级刷新
    TwoLevelReleased(1, false, false, false, true, false),
    //释放开始刷新
    RefreshReleased(1, false, false, false, false, false),
    //释放开始加载
    LoadReleased(2, false, false, false, false, false),
    //刷新中
    Refreshing(1, false, true, false, false, false),
    //加载中
    Loading(2, false, true, false, false, false),
    //二级页面显示
    TwoLevel(1, false, true, false, true, false),
    //刷新结束
    RefreshFinish(1, false, false, true, false, false),
    //加载结束
    LoadFinish(2, false, false, true, false, false),
    //二级刷新结束
    TwoLevelFinish(1, false, false, true, true, false);

    public final boolean isHeader;
    public final boolean isFooter;
    public final boolean isTwoLevel;// 二级刷新
    public final boolean isDragging;// 正在拖动状态
    public final boolean isOpening;// 正在刷新状态
    public final boolean isFinishing;//正在完成状态
    public final boolean isReleaseToOpening;// 释放立马打开

    RefreshState(int role, boolean dragging, boolean opening, boolean finishing, boolean twoLevel, boolean releaseToOpening) {
        this.isHeader = role == 1;
        this.isFooter = role == 2;
        this.isDragging = dragging;
        this.isOpening = opening;
        this.isFinishing = finishing;
        this.isTwoLevel = twoLevel;
        this.isReleaseToOpening = releaseToOpening;
    }

    public static RefreshState from(RefreshState newState) {
        for (RefreshState state : values()) {
            if (state.ordinal() == newState.ordinal()) {
                return state;
            }
        }
        return None;
    }

    public RefreshState toFooter() {
        if (isHeader && !isTwoLevel) {
            return values()[ordinal() + 1];
        }
        return this;
    }

    public RefreshState toHeader() {
        if (isFooter && !isTwoLevel) {
            return values()[ordinal() - 1];
        }
        return this;
    }
}
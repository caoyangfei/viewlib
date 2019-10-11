package com.flyang.view.layout.refresh.inter;

import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

import com.flyang.view.layout.refresh.constant.RefreshState;
import com.flyang.view.layout.refresh.listener.OnLoadMoreListener;
import com.flyang.view.layout.refresh.listener.OnMultiListener;
import com.flyang.view.layout.refresh.listener.OnRefreshListener;
import com.flyang.view.layout.refresh.listener.OnRefreshLoadMoreListener;
import com.flyang.view.layout.refresh.listener.ScrollBoundaryDecider;
import com.flyang.view.layout.refresh.simple.SimpleBoundaryDecider;


/**
 * @author caoyangfei
 * @ClassName RefreshLayout
 * @date 2019/10/10
 * ------------- Description -------------
 * 刷新布局
 */
@SuppressWarnings({"UnusedReturnValue", "SameParameterValue", "unused"})
public interface RefreshLayout {

    /**
     * 设置 Footer 的高度
     *
     * @param dp Density-independent Pixels 虚拟像素（px需要调用px2dp转换）
     * @return RefreshLayout
     */
    RefreshLayout setFooterHeight(float dp);

    /**
     * 设置 Footer 高度
     *
     * @param px 像素
     * @return RefreshLayout
     */
    RefreshLayout setFooterHeightPx(int px);

    /**
     * Set the Header's height.
     * 设置 Header 高度
     *
     * @param dp Density-independent Pixels 虚拟像素（px需要调用px2dp转换）
     * @return RefreshLayout
     */
    RefreshLayout setHeaderHeight(float dp);

    /**
     * 设置 Header 高度
     *
     * @param px 像素
     * @return RefreshLayout
     */
    RefreshLayout setHeaderHeightPx(int px);

    /**
     * 设置 Header 的起始偏移量（使用方法参考 demo-app 中的 RepastPracticeActivity xml 中的 refreshHeaderInsetStart）
     *
     * @param dp Density-independent Pixels 虚拟像素（px需要调用px2dp转换）
     * @return RefreshLayout
     */
    RefreshLayout setHeaderInsetStart(float dp);

    /**
     * 设置 Header 起始偏移量（使用方法参考 demo-app 中的 RepastPracticeActivity xml 中的 refreshHeaderInsetStart）
     *
     * @param px 像素
     * @return RefreshLayout
     */
    RefreshLayout setHeaderInsetStartPx(int px);

    /**
     * 设置 Footer 起始偏移量（用处和 setHeaderInsetStart 一样）
     *
     * @param dp Density-independent Pixels 虚拟像素（px需要调用px2dp转换）
     * @return RefreshLayout
     * @see RefreshLayout#setHeaderInsetStart(float)
     */
    RefreshLayout setFooterInsetStart(float dp);

    /**
     * 设置 Footer 起始偏移量（用处和 setFooterInsetStartPx 一样）
     *
     * @param px 像素
     * @return RefreshLayout
     */
    RefreshLayout setFooterInsetStartPx(int px);

    /**
     * 显示拖动高度/真实拖动高度 比率（默认0.5，阻尼效果）
     *
     * @param rate ratio = (The drag height of the view)/(The actual drag height of the finger)
     *             比率 = 视图拖动高度 / 手指拖动高度
     * @return RefreshLayout
     */
    RefreshLayout setDragRate(@FloatRange(from = 0, to = 1) float rate);

    /**
     * 设置下拉最大高度和Header高度的比率（将会影响可以下拉的最大高度）
     *
     * @param rate ratio = (the maximum height to drag header)/(the height of header)
     *             比率 = 下拉最大高度 / Header的高度
     * @return RefreshLayout
     */
    RefreshLayout setHeaderMaxDragRate(@FloatRange(from = 1, to = 10) float rate);

    /**
     * 设置上拉最大高度和Footer高度的比率（将会影响可以上拉的最大高度）
     *
     * @param rate ratio = (the maximum height to drag footer)/(the height of footer)
     *             比率 = 下拉最大高度 / Footer的高度
     * @return RefreshLayout
     */
    RefreshLayout setFooterMaxDragRate(@FloatRange(from = 1, to = 10) float rate);

    /**
     * 设置 触发刷新距离 与 HeaderHeight 的比率
     *
     * @param rate 触发刷新距离 与 HeaderHeight 的比率
     * @return RefreshLayout
     */
    RefreshLayout setHeaderTriggerRate(@FloatRange(from = 0, to = 1.0) float rate);

    /**
     * 设置 触发加载距离 与 FooterHeight 的比率
     *
     * @param rate 触发加载距离 与 FooterHeight 的比率
     * @return RefreshLayout
     */
    RefreshLayout setFooterTriggerRate(@FloatRange(from = 0, to = 1.0) float rate);

    /**
     * 设置回弹显示插值器 [放手时回弹动画,结束时收缩动画]
     *
     * @param interpolator 动画插值器
     * @return RefreshLayout
     */
    RefreshLayout setReboundInterpolator(@NonNull Interpolator interpolator);

    /**
     * 设置回弹动画时长 [放手时回弹动画,结束时收缩动画]
     *
     * @param duration 时长
     * @return RefreshLayout
     */
    RefreshLayout setReboundDuration(int duration);

    /**
     * 设置指定的 Footer
     *
     * @param footer RefreshFooter 刷新尾巴
     * @return RefreshLayout
     */
    RefreshLayout setRefreshFooter(@NonNull RefreshFooter footer);

    /**
     * 设置指定的 Footer
     *
     * @param footer RefreshFooter 刷新尾巴
     * @param width  the width in px, can use MATCH_PARENT and WRAP_CONTENT.
     *               宽度 可以使用 MATCH_PARENT, WRAP_CONTENT
     * @param height the height in px, can use MATCH_PARENT and WRAP_CONTENT.
     *               高度 可以使用 MATCH_PARENT, WRAP_CONTENT
     * @return RefreshLayout
     */
    RefreshLayout setRefreshFooter(@NonNull RefreshFooter footer, int width, int height);

    /**
     * 设置指定的 Header
     *
     * @param header RefreshHeader 刷新头
     * @return RefreshLayout
     */
    RefreshLayout setRefreshHeader(@NonNull RefreshHeader header);

    /**
     * 设置指定的 Header
     *
     * @param header RefreshHeader 刷新头
     * @param width  the width in px, can use MATCH_PARENT and WRAP_CONTENT.
     *               宽度 可以使用 MATCH_PARENT, WRAP_CONTENT
     * @param height the height in px, can use MATCH_PARENT and WRAP_CONTENT.
     *               高度 可以使用 MATCH_PARENT, WRAP_CONTENT
     * @return RefreshLayout
     */
    RefreshLayout setRefreshHeader(@NonNull RefreshHeader header, int width, int height);

    /**
     * 设置指定的 Content（适用于非XML页面，不适合用替换空布局）
     *
     * @param content View 内容视图
     * @return RefreshLayout
     */
    RefreshLayout setRefreshContent(@NonNull View content);

    /**
     * 设置指定的 Content（适用于非XML页面，不适合用替换空布局）
     *
     * @param content View 内容视图
     * @param width   the width in px, can use MATCH_PARENT and WRAP_CONTENT.
     *                宽度 可以使用 MATCH_PARENT, WRAP_CONTENT
     * @param height  the height in px, can use MATCH_PARENT and WRAP_CONTENT.
     *                高度 可以使用 MATCH_PARENT, WRAP_CONTENT
     * @return RefreshLayout
     */
    RefreshLayout setRefreshContent(@NonNull View content, int width, int height);

    /**
     * 是否启用下拉刷新（默认启用）
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableRefresh(boolean enabled);

    /**
     * 设置是否启用上拉加载更多（默认启用）
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableLoadMore(boolean enabled);

    /**
     * 设置是否监听列表在滚动到底部时触发加载事件（默认true）
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableAutoLoadMore(boolean enabled);

    /**
     * 设置是否启在下拉 Header 的同时下拉内容
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableHeaderTranslationContent(boolean enabled);

    /**
     * 设置是否启在上拉 Footer 的同时上拉内容
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableFooterTranslationContent(boolean enabled);

    /**
     * 设置是否启用越界回弹
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableOverScrollBounce(boolean enabled);

    /**
     * 设置是否开启纯滚动模式
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnablePureScrollMode(boolean enabled);

    /**
     * 设置是否在加载更多完成之后滚动内容显示新数据
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableScrollContentWhenLoaded(boolean enabled);

    /**
     * 是否在刷新完成之后滚动内容显示新数据
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableScrollContentWhenRefreshed(boolean enabled);

    /**
     * 设置在内容不满一页的时候，是否可以上拉加载更多
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableLoadMoreWhenContentNotFull(boolean enabled);

    /**
     * 设置是否启用越界拖动（仿苹果效果）
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableOverScrollDrag(boolean enabled);

    /**
     * 设置是否在没有更多数据之后 Footer 跟随内容
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableFooterFollowWhenNoMoreData(boolean enabled);

    /**
     * 设置是否在当 Header 处于 FixedBehind 状态的时候剪裁遮挡 Header
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableClipHeaderWhenFixedBehind(boolean enabled);

    /**
     * 设置是否在当 Footer 处于 FixedBehind 状态的时候剪裁遮挡 Footer
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableClipFooterWhenFixedBehind(boolean enabled);

    /**
     * 设置是会否启用嵌套滚动功能（默认关闭+智能开启）
     *
     * @param enabled 是否启用
     * @return RefreshLayout
     */
    RefreshLayout setEnableNestedScroll(boolean enabled);

    /**
     * 设置是否开启在刷新时候禁止操作内容视图
     *
     * @param disable 是否禁止
     * @return RefreshLayout
     */
    RefreshLayout setDisableContentWhenRefresh(boolean disable);

    /**
     * 设置是否开启在加载时候禁止操作内容视图
     *
     * @param disable 是否禁止
     * @return RefreshLayout
     */
    RefreshLayout setDisableContentWhenLoading(boolean disable);

    /**
     * 单独设置刷新监听器
     *
     * @param listener OnRefreshListener 刷新监听器
     * @return RefreshLayout
     */
    RefreshLayout setOnRefreshListener(OnRefreshListener listener);

    /**
     * 单独设置加载监听器
     *
     * @param listener OnLoadMoreListener 加载监听器
     * @return RefreshLayout
     */
    RefreshLayout setOnLoadMoreListener(OnLoadMoreListener listener);

    /**
     * 同时设置刷新和加载监听器
     *
     * @param listener OnRefreshLoadMoreListener 刷新加载监听器
     * @return RefreshLayout
     */
    RefreshLayout setOnRefreshLoadMoreListener(OnRefreshLoadMoreListener listener);

    /**
     * 设置多功能监听器
     *
     * @param listener OnMultiPurposeListener 多功能监听器
     * @return RefreshLayout
     */
    RefreshLayout setOnMultiListener(OnMultiListener listener);

    /**
     * Recommended {@link SimpleBoundaryDecider}
     * 设置滚动边界判断器
     * 建议使用 {@link SimpleBoundaryDecider}
     *
     * @param boundary ScrollBoundaryDecider 判断器
     * @return RefreshLayout
     */
    RefreshLayout setScrollBoundaryDecider(ScrollBoundaryDecider boundary);

    /**
     * 设置主题颜色
     *
     * @param primaryColors ColorInt 主题颜色
     * @return RefreshLayout
     */
    RefreshLayout setPrimaryColors(@ColorInt int... primaryColors);

    /**
     * 设置主题颜色
     *
     * @param primaryColorId ColorRes 主题颜色ID
     * @return RefreshLayout
     */
    RefreshLayout setPrimaryColorsId(@ColorRes int... primaryColorId);

    /**
     * 完成刷新
     *
     * @return RefreshLayout
     */
    RefreshLayout finishRefresh();

    /**
     * 完成刷新
     *
     * @param delayed 开始延时
     * @return RefreshLayout
     */
    RefreshLayout finishRefresh(int delayed);

    /**
     * 完成刷新
     *
     * @param success 数据是否成功刷新 （会影响到上次更新时间的改变）
     * @return RefreshLayout
     */
    RefreshLayout finishRefresh(boolean success);

    /**
     * 完成刷新
     *
     * @param delayed    开始延时
     * @param success    数据是否成功刷新 （会影响到上次更新时间的改变）
     * @param noMoreData 是否有更多数据
     * @return RefreshLayout
     */
    RefreshLayout finishRefresh(int delayed, boolean success, Boolean noMoreData);

    /**
     * 完成刷新并标记没有更多数据
     *
     * @return RefreshLayout
     */
    RefreshLayout finishRefreshWithNoMoreData();

    /**
     * 完成加载
     *
     * @return RefreshLayout
     */
    RefreshLayout finishLoadMore();

    /**
     * 完成加载
     *
     * @param delayed 开始延时
     * @return RefreshLayout
     */
    RefreshLayout finishLoadMore(int delayed);

    /**
     * 完成加载
     *
     * @param success 数据是否成功
     * @return RefreshLayout
     */
    RefreshLayout finishLoadMore(boolean success);

    /**
     * 完成加载
     *
     * @param delayed    开始延时
     * @param success    数据是否成功
     * @param noMoreData 是否有更多数据
     * @return RefreshLayout
     */
    RefreshLayout finishLoadMore(int delayed, boolean success, boolean noMoreData);

    /**
     * 完成加载并标记没有更多数据
     *
     * @return RefreshLayout
     */
    RefreshLayout finishLoadMoreWithNoMoreData();

    /**
     * 关闭 Header 或者 Footer
     *
     * @return RefreshLayout
     */
    RefreshLayout closeHeaderOrFooter();

    /**
     * 设置没有更多数据的状态
     *
     * @param noMoreData 是否有更多数据
     * @return RefreshLayout
     * 尽量使用下面三个方法代替，他们可以让状态切换与动画结束合拍
     * use {@link RefreshLayout#resetNoMoreData()}
     * use {@link RefreshLayout#finishRefreshWithNoMoreData()}
     * use {@link RefreshLayout#finishLoadMoreWithNoMoreData()}
     */
    RefreshLayout setNoMoreData(boolean noMoreData);

    /**
     * 恢复没有更多数据的原始状态
     *
     * @return RefreshLayout
     */
    RefreshLayout resetNoMoreData();

    /**
     * 获取当前 Header
     *
     * @return RefreshLayout
     */
    @Nullable
    RefreshHeader getRefreshHeader();

    /**
     * 获取当前 Footer
     *
     * @return RefreshLayout
     */
    @Nullable
    RefreshFooter getRefreshFooter();

    /**
     * 获取当前状态
     *
     * @return RefreshLayout
     */
    @NonNull
    RefreshState getState();

    /**
     * 获取实体布局视图
     *
     * @return ViewGroup
     */
    @NonNull
    ViewGroup getLayout();

    /**
     * 显示刷新动画并且触发刷新事件
     *
     * @return true or false, Status non-compliance will fail.
     * 是否成功（状态不符合会失败）
     */
    boolean autoRefresh();

    /**
     * 显示刷新动画并且触发刷新事件，延时启动
     *
     * @param delayed 开始延时
     * @return true or false, Status non-compliance will fail.
     * 是否成功（状态不符合会失败）
     */
    boolean autoRefresh(int delayed);

    /**
     * 显示刷新动画，不触发事件
     *
     * @return true or false, Status non-compliance will fail.
     * 是否成功（状态不符合会失败）
     */
    boolean autoRefreshAnimationOnly();

    /**
     * 显示刷新动画并且触发刷新事件
     *
     * @param delayed       开始延时
     * @param duration      拖拽动画持续时间
     * @param dragRate      拉拽的高度比率
     * @param animationOnly animation only 只有动画
     * @return true or false, Status non-compliance will fail.
     * 是否成功（状态不符合会失败）
     */
    boolean autoRefresh(int delayed, int duration, float dragRate, boolean animationOnly);

    /**
     * 显示加载动画并且触发刷新事件
     *
     * @return true or false, Status non-compliance will fail.
     * 是否成功（状态不符合会失败）
     */
    boolean autoLoadMore();

    /**
     * 显示加载动画并且触发刷新事件, 延时启动
     *
     * @param delayed 开始延时
     * @return true or false, Status non-compliance will fail.
     * 是否成功（状态不符合会失败）
     */
    boolean autoLoadMore(int delayed);

    /**
     * 显示加载动画，不触发事件
     *
     * @return true or false, Status non-compliance will fail.
     * 是否成功（状态不符合会失败）
     */
    boolean autoLoadMoreAnimationOnly();

    /**
     * 显示加载动画, 多功能选项
     *
     * @param delayed       开始延时
     * @param duration      拖拽动画持续时间
     * @param dragRate      拉拽的高度比率
     * @param animationOnly 是否只是显示动画，不回调
     * @return true or false, Status non-compliance will fail.
     * 是否成功（状态不符合会失败）
     */
    boolean autoLoadMore(int delayed, int duration, float dragRate, boolean animationOnly);

    /**
     * 是否正在刷新
     *
     * @return RefreshLayout
     */
    boolean isRefreshing();

    /**
     * 是否正在加载
     *
     * @return RefreshLayout
     */
    boolean isLoading();

}

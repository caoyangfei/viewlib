package com.flyang.expandview.refresh.around.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent2;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.flyang.base.view.refresh.around.ClassicsHeader;
import com.flyang.base.view.refresh.constant.RefreshState;
import com.flyang.base.view.refresh.constant.SpinnerStyle;
import com.flyang.base.view.refresh.inter.RefreshComponent;
import com.flyang.base.view.refresh.inter.RefreshHeader;
import com.flyang.base.view.refresh.inter.RefreshKernel;
import com.flyang.base.view.refresh.inter.RefreshLayout;
import com.flyang.base.view.refresh.listener.OnStateChangedListener;
import com.flyang.base.view.refresh.simple.SimpleComponent;
import com.flyang.expandview.R;
import com.flyang.expandview.refresh.around.listener.OnTwoLevelListener;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * @author caoyangfei
 * @ClassName TwoLevelHeader
 * @date 2019/10/10
 * ------------- Description -------------
 * 二级刷新
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class TwoLevelHeader extends SimpleComponent implements RefreshHeader, NestedScrollingParent2 {

    //<editor-fold desc="属性字段">
    protected int mSpinner;
    protected float mPercent = 0;
    protected float mMaxRage = 2.5f;
    protected float mFloorRage = 1.9f;
    protected float mRefreshRage = 1f;
    protected boolean mEnableTwoLevel = true;
    protected boolean mEnablePullToCloseTwoLevel = true;
    protected int mFloorDuration = 1000;
    protected int mHeaderHeight;

    protected RefreshComponent mRefreshHeader;
    protected RefreshKernel mRefreshKernel;
    protected OnTwoLevelListener mTwoLevelListener;
    //</editor-fold>

    //<editor-fold desc="构造方法">
    public TwoLevelHeader(Context context) {
        this(context, null);
    }

    public TwoLevelHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);

        mSpinnerStyle = SpinnerStyle.FixedBehind;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TwoLevelHeader);

        mMaxRage = ta.getFloat(R.styleable.TwoLevelHeader_refreshMaxRage, mMaxRage);
        mFloorRage = ta.getFloat(R.styleable.TwoLevelHeader_refreshFloorRage, mFloorRage);
        mRefreshRage = ta.getFloat(R.styleable.TwoLevelHeader_refreshRefreshRage, mRefreshRage);
        mFloorDuration = ta.getInt(R.styleable.TwoLevelHeader_refreshFloorDuration, mFloorDuration);
        mEnableTwoLevel = ta.getBoolean(R.styleable.TwoLevelHeader_refreshEnableTwoLevel, mEnableTwoLevel);
        mEnablePullToCloseTwoLevel = ta.getBoolean(R.styleable.TwoLevelHeader_refreshEnablePullToCloseTwoLevel, mEnablePullToCloseTwoLevel);

        ta.recycle();
    }
    //</editor-fold>

    //<editor-fold desc="生命周期">
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        final ViewGroup thisGroup = this;
        for (int i = 0, len = thisGroup.getChildCount(); i < len; i++) {
            View childAt = thisGroup.getChildAt(i);
            if (childAt instanceof RefreshHeader) {
                mRefreshHeader = (RefreshHeader) childAt;
                mWrappedInternal = (RefreshComponent) childAt;
                thisGroup.bringChildToFront(childAt);
                break;
            }
        }
        if (mRefreshHeader == null) {
            final ViewGroup thisView = this;
            setRefreshHeader(new ClassicsHeader(thisView.getContext()));
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mSpinnerStyle = SpinnerStyle.MatchLayout;
        if (mRefreshHeader == null) {
            final ViewGroup thisView = this;
            setRefreshHeader(new ClassicsHeader(thisView.getContext()));
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mSpinnerStyle = SpinnerStyle.FixedBehind;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final RefreshComponent refreshHeader = mRefreshHeader;
        if (refreshHeader != null) {
            int mode = View.MeasureSpec.getMode(heightMeasureSpec);
            if (mode == View.MeasureSpec.AT_MOST) {
                refreshHeader.getView().measure(widthMeasureSpec, heightMeasureSpec);
                int height = refreshHeader.getView().getMeasuredHeight();
                super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), widthMeasureSpec), height);
            } else {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    public boolean equals(Object obj) {
        final Object header = mRefreshHeader;
        return (header != null && header.equals(obj)) || super.equals(obj);
    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {
        final View thisView = this;
        final RefreshComponent refreshHeader = mRefreshHeader;
        if (refreshHeader == null) {
            return;
        }
        if (1f * (maxDragHeight + height) / height != mMaxRage && mHeaderHeight == 0) {
            mHeaderHeight = height;
            mRefreshHeader = null;
            kernel.getRefreshLayout().setHeaderMaxDragRate(mMaxRage);
            mRefreshHeader = refreshHeader;
        }
        if (mRefreshKernel == null //第一次初始化
                && refreshHeader.getSpinnerStyle() == SpinnerStyle.Translate
                && !thisView.isInEditMode()) {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) refreshHeader.getView().getLayoutParams();
            params.topMargin -= height;
            refreshHeader.getView().setLayoutParams(params);
        }

        mHeaderHeight = height;
        mRefreshKernel = kernel;
        kernel.requestFloorDuration(mFloorDuration);
        kernel.requestNeedTouchEventFor(this, !mEnablePullToCloseTwoLevel);
        refreshHeader.onInitialized(kernel, height, maxDragHeight);

    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        final RefreshComponent refreshHeader = mRefreshHeader;
        if (refreshHeader != null) {
            final OnStateChangedListener listener = mRefreshHeader;
            listener.onStateChanged(refreshLayout, oldState, newState);
            switch (newState) {
                case TwoLevelReleased:
                    if (refreshHeader.getView() != this) {
                        refreshHeader.getView().animate().alpha(0).setDuration(mFloorDuration / 2);
                    }
                    final RefreshKernel refreshKernel = mRefreshKernel;
                    if (refreshKernel != null) {
                        final OnTwoLevelListener twoLevelListener = mTwoLevelListener;
                        refreshKernel.startTwoLevel(twoLevelListener == null || twoLevelListener.onTwoLevel(refreshLayout));
                    }
                    break;
                case TwoLevel:
                    break;
                case TwoLevelFinish:
                    if (refreshHeader.getView() != this) {
                        refreshHeader.getView().animate().alpha(1).setDuration(mFloorDuration / 2);
                    }
                    break;
                case PullDownToRefresh:
                    if (refreshHeader.getView().getAlpha() == 0 && refreshHeader.getView() != this) {
                        refreshHeader.getView().setAlpha(1);
                    }
                    break;
            }
        }
    }

    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
        moveSpinner(offset);
        final RefreshComponent refreshHeader = mRefreshHeader;
        final RefreshKernel refreshKernel = mRefreshKernel;
        if (refreshHeader != null) {
            refreshHeader.onMoving(isDragging, percent, offset, height, maxDragHeight);
        }
        if (isDragging) {
            if (mPercent < mFloorRage && percent >= mFloorRage && mEnableTwoLevel) {
                refreshKernel.setState(RefreshState.ReleaseToTwoLevel);
            } else if (mPercent >= mFloorRage && percent < mRefreshRage) {
                refreshKernel.setState(RefreshState.PullDownToRefresh);
            } else if (mPercent >= mFloorRage && percent < mFloorRage) {
                refreshKernel.setState(RefreshState.ReleaseToRefresh);
            }
            mPercent = percent;
        }
    }

    protected void moveSpinner(int spinner) {
        final RefreshComponent refreshHeader = mRefreshHeader;
        if (mSpinner != spinner && refreshHeader != null) {
            mSpinner = spinner;
            SpinnerStyle style = refreshHeader.getSpinnerStyle();
            if (style == SpinnerStyle.Translate) {
                refreshHeader.getView().setTranslationY(spinner);
            } else if (style.scale) {
                View view = refreshHeader.getView();
                view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, spinner));
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="NestedScrollingParent2">
    private int mNestedScrollAxes = 0;

    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int nestedScrollAxes) {
        return true;
    }

    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int nestedScrollAxes) {
        mNestedScrollAxes = nestedScrollAxes;
    }

    public void onStopNestedScroll(@NonNull View target) {
    }

    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
    }

    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed) {
    }

    public boolean onNestedFling(@NonNull View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    public boolean onNestedPreFling(@NonNull View target, float velocityX, float velocityY) {
        return false;
    }

    public int getNestedScrollAxes() {
        return mNestedScrollAxes;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int nestedScrollAxes, int i1) {
        return true;
    }

    @Override
    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int nestedScrollAxes, int i1) {
        mNestedScrollAxes = nestedScrollAxes;
    }

    @Override
    public void onStopNestedScroll(@NonNull View view, int i) {

    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int i4) {

    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int i2) {

    }
    //</editor-fold>

    //<editor-fold desc="开放接口 - API">

    /**
     * 设置指定的 Header
     *
     * @param header RefreshHeader
     * @return TwoLevelHeader
     */
    public TwoLevelHeader setRefreshHeader(RefreshHeader header) {
        return setRefreshHeader(header, MATCH_PARENT, WRAP_CONTENT);
    }

    /**
     * 设置指定的 Header
     *
     * @param header RefreshHeader
     * @param width  指定宽度
     * @param height 指定高度
     * @return TwoLevelHeader
     */
    public TwoLevelHeader setRefreshHeader(RefreshHeader header, int width, int height) {
        final ViewGroup thisGroup = this;
        if (header != null) {
            RefreshComponent refreshHeader = mRefreshHeader;
            if (refreshHeader != null) {
                thisGroup.removeView(refreshHeader.getView());
            }
            refreshHeader = header;
            if (refreshHeader.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                thisGroup.addView(refreshHeader.getView(), 0, new RelativeLayout.LayoutParams(width, height));
            } else {
                thisGroup.addView(refreshHeader.getView(), thisGroup.getChildCount(), new RelativeLayout.LayoutParams(width, height));
            }
            this.mRefreshHeader = header;
            this.mWrappedInternal = header;
        }
        return this;
    }

    /**
     * 设置下拉 Header 的最大高度比值
     *
     * @param rate MaxDragHeight/HeaderHeight
     * @return TwoLevelHeader
     */
    public TwoLevelHeader setMaxRage(float rate) {
        if (this.mMaxRage != rate) {
            this.mMaxRage = rate;
            final RefreshKernel refreshKernel = mRefreshKernel;
            if (refreshKernel != null) {
                this.mHeaderHeight = 0;
                refreshKernel.getRefreshLayout().setHeaderMaxDragRate(mMaxRage);
            }
        }
        return this;
    }

    /**
     * 是否禁止在二极状态是上滑关闭状态回到初态
     *
     * @param enabled 是否启用
     * @return TwoLevelHeader
     */
    public TwoLevelHeader setEnablePullToCloseTwoLevel(boolean enabled) {
        final RefreshKernel refreshKernel = mRefreshKernel;
        this.mEnablePullToCloseTwoLevel = enabled;
        if (refreshKernel != null) {
            refreshKernel.requestNeedTouchEventFor(this, !enabled);
        }
        return this;
    }

    /**
     * 设置触发二楼的白百分比
     *
     * @param rate 比率 要求大于 RefreshRage
     * @return TwoLevelHeader
     */
    public TwoLevelHeader setFloorRage(float rate) {
        this.mFloorRage = rate;
        return this;
    }

    /**
     * 设置触发刷新的百分比
     *
     * @param rate 比率 要求小于 FloorRage
     * @return TwoLevelHeader
     */
    public TwoLevelHeader setRefreshRage(float rate) {
        this.mRefreshRage = rate;
        return this;
    }

    /**
     * 设置是否开启二级刷新
     *
     * @param enabled 是否开启
     * @return TwoLevelHeader
     */
    public TwoLevelHeader setEnableTwoLevel(boolean enabled) {
        this.mEnableTwoLevel = enabled;
        return this;
    }

    /**
     * 设置二楼展开动画持续的时间
     *
     * @param duration 毫秒
     * @return TwoLevelHeader
     */
    public TwoLevelHeader setFloorDuration(int duration) {
        this.mFloorDuration = duration;
        return this;
    }

    /**
     * 设置二级刷新监听器
     *
     * @param listener 监听器
     * @return TwoLevelHeader
     */
    public TwoLevelHeader setOnTwoLevelListener(OnTwoLevelListener listener) {
        this.mTwoLevelListener = listener;
        return this;
    }

    /**
     * 结束二级刷新
     *
     * @return TwoLevelHeader
     */
    public TwoLevelHeader finishTwoLevel() {
        final RefreshKernel refreshKernel = mRefreshKernel;
        if (refreshKernel != null) {
            refreshKernel.finishTwoLevel();
        }
        return this;
    }

    /**
     * Open the second floor voluntarily
     * 主动打开二楼
     *
     * @param widthOnTwoLevelListener 是否触发 OnTwoLevelListener 监听器
     * @return TwoLevelHeader
     */
    public TwoLevelHeader openTwoLevel(boolean widthOnTwoLevelListener) {
        final RefreshKernel refreshKernel = mRefreshKernel;
        if (refreshKernel != null) {
            final OnTwoLevelListener twoLevelListener = mTwoLevelListener;
            refreshKernel.startTwoLevel(!widthOnTwoLevelListener || twoLevelListener == null || twoLevelListener.onTwoLevel(refreshKernel.getRefreshLayout()));
        }
        return this;
    }
    //</editor-fold>
}
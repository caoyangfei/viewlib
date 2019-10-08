package com.flyang.view.layout.refresh.internal;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.flyang.view.constant.RefreshState;
import com.flyang.view.constant.SpinnerStyle;
import com.flyang.view.layout.SmartRefreshLayout;
import com.flyang.view.layout.refresh.impl.RefreshFooterWrapper;
import com.flyang.view.layout.refresh.impl.RefreshHeaderWrapper;
import com.flyang.view.layout.refresh.inter.RefreshFooter;
import com.flyang.view.layout.refresh.inter.RefreshHeader;
import com.flyang.view.layout.refresh.inter.RefreshInternal;
import com.flyang.view.layout.refresh.inter.RefreshKernel;
import com.flyang.view.layout.refresh.inter.RefreshLayout;
import com.flyang.view.layout.refresh.listener.OnStateChangedListener;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * Internal 初步实现
 * 实现 Header 和 Footer 时，继承 InternalAbstract 的话可以少写很多接口方法
 * Created by SCWANG on 2018/2/6.
 */

public abstract class InternalAbstract extends RelativeLayout implements RefreshInternal {

    protected View mWrappedView;
    protected SpinnerStyle mSpinnerStyle;
    protected RefreshInternal mWrappedInternal;

    protected InternalAbstract(@NonNull View wrapped) {
        this(wrapped, wrapped instanceof RefreshInternal ? (RefreshInternal) wrapped : null);
    }

    protected InternalAbstract(@NonNull View wrappedView, @Nullable RefreshInternal wrappedInternal) {
        super(wrappedView.getContext(), null, 0);
        this.mWrappedView = wrappedView;
        this.mWrappedInternal = wrappedInternal;
        if (this instanceof RefreshFooterWrapper && mWrappedInternal instanceof RefreshHeader && mWrappedInternal.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
            wrappedInternal.getView().setScaleY(-1);
        } else if (this instanceof RefreshHeaderWrapper && mWrappedInternal instanceof RefreshFooter && mWrappedInternal.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
            wrappedInternal.getView().setScaleY(-1);
        }
    }

    protected InternalAbstract(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            if (obj instanceof RefreshInternal) {
                final RefreshInternal thisView = this;
                return thisView.getView() == ((RefreshInternal)obj).getView();
            }
            return false;
        }
        return true;
    }

    @NonNull
    public View getView() {
        return mWrappedView == null ? this : mWrappedView;
    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        if (mWrappedInternal != null && mWrappedInternal != this) {
            return mWrappedInternal.onFinish(refreshLayout, success);
        }
        return 0;
    }

    @Override
    public void setPrimaryColors(@ColorInt int ... colors) {
        if (mWrappedInternal != null && mWrappedInternal != this) {
            mWrappedInternal.setPrimaryColors(colors);
        }
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        if (mSpinnerStyle != null) {
            return mSpinnerStyle;
        }
        if (mWrappedInternal != null && mWrappedInternal != this) {
            return mWrappedInternal.getSpinnerStyle();
        }
        if (mWrappedView != null) {
            ViewGroup.LayoutParams params = mWrappedView.getLayoutParams();
            if (params instanceof SmartRefreshLayout.LayoutParams) {
                mSpinnerStyle = ((SmartRefreshLayout.LayoutParams) params).spinnerStyle;
                if (mSpinnerStyle != null) {
                    return mSpinnerStyle;
                }
            }
            if (params != null) {
                if (params.height == 0 || params.height == MATCH_PARENT) {
                    return mSpinnerStyle = SpinnerStyle.Scale;
                }
            }
        }
        return mSpinnerStyle = SpinnerStyle.Translate;
    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {
        if (mWrappedInternal != null && mWrappedInternal != this) {
            mWrappedInternal.onInitialized(kernel, height, maxDragHeight);
        } else if (mWrappedView != null) {
            ViewGroup.LayoutParams params = mWrappedView.getLayoutParams();
            if (params instanceof SmartRefreshLayout.LayoutParams) {
                kernel.requestDrawBackgroundFor(this, ((SmartRefreshLayout.LayoutParams) params).backgroundColor);
            }
        }
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return mWrappedInternal != null && mWrappedInternal != this && mWrappedInternal.isSupportHorizontalDrag();
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
        if (mWrappedInternal != null && mWrappedInternal != this) {
            mWrappedInternal.onHorizontalDrag(percentX, offsetX, offsetMax);
        }
    }

    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
        if (mWrappedInternal != null && mWrappedInternal != this) {
            mWrappedInternal.onMoving(isDragging, percent, offset, height, maxDragHeight);
        }
    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        if (mWrappedInternal != null && mWrappedInternal != this) {
            mWrappedInternal.onReleased(refreshLayout, height, maxDragHeight);
        }
    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        if (mWrappedInternal != null && mWrappedInternal != this) {
            mWrappedInternal.onStartAnimator(refreshLayout, height, maxDragHeight);
        }
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        if (mWrappedInternal != null && mWrappedInternal != this) {
            if (this instanceof RefreshFooterWrapper && mWrappedInternal instanceof RefreshHeader) {
                if (oldState.isFooter) {
                    oldState = oldState.toHeader();
                }
                if (newState.isFooter) {
                    newState = newState.toHeader();
                }
            } else if (this instanceof RefreshHeaderWrapper && mWrappedInternal instanceof RefreshFooter) {
                if (oldState.isHeader) {
                    oldState = oldState.toFooter();
                }
                if (newState.isHeader) {
                    newState = newState.toFooter();
                }
            }
            final OnStateChangedListener listener = mWrappedInternal;
            if (listener != null) {
                listener.onStateChanged(refreshLayout, oldState, newState);
            }
        }
    }

//    @Override
    public boolean setNoMoreData(boolean noMoreData) {
        return mWrappedInternal instanceof RefreshFooter && ((RefreshFooter) mWrappedInternal).setNoMoreData(noMoreData);
    }
}

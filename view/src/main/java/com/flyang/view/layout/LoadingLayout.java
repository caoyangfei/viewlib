package com.flyang.view.layout;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyang.util.data.PreconditionUtils;
import com.flyang.view.R;

import java.util.HashMap;
import java.util.Map;


/**
 * @author caoyangfei
 * @ClassName LoadingLayout
 * @date 2019/10/11
 * ------------- Description -------------
 * 空数据,加载中,加载失败
 */
public class LoadingLayout extends FrameLayout {
    public interface OnInflateListener {
        void onInflate(View inflated);
    }

    public static LoadingLayout wrap(Activity activity) {
        return wrap(((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0));
    }

    public static LoadingLayout wrap(Fragment fragment) {
        return wrap(fragment.getView());
    }

    public static LoadingLayout wrap(View view) {
        PreconditionUtils.checkNotNull(view, "content view can not be null");
        ViewGroup parent = (ViewGroup) view.getParent();
        PreconditionUtils.checkNotNull(parent, "parent view can not be null");

        ViewGroup.LayoutParams lp = view.getLayoutParams();
        int index = parent.indexOfChild(view);
        parent.removeView(view);

        LoadingLayout layout = new LoadingLayout(view.getContext());
        parent.addView(layout, index, lp);
        layout.addView(view);
        layout.setContentView(view);
        return layout;
    }

    int mEmptyImage;
    CharSequence mEmptyText;

    int mErrorImage;
    CharSequence mErrorText, mRetryText;
    OnClickListener mRetryButtonClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mRetryListener != null) {
                mRetryListener.onClick(v);
            }
        }
    };
    OnClickListener mRetryListener;

    OnInflateListener mOnEmptyInflateListener;
    OnInflateListener mOnErrorInflateListener;

    int mTextColor, mTextSize;
    int mButtonTextColor, mButtonTextSize;
    Drawable mButtonBackground;
    int mEmptyResId, mLoadingResId, mErrorResId;
    int mContentId = NO_ID;

    Map<Integer, View> mLayouts = new HashMap<>();


    public LoadingLayout(Context context) {
        this(context, null, R.attr.styleLoadingLayout);
    }

    public LoadingLayout(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.styleLoadingLayout);
    }

    public LoadingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mInflater = LayoutInflater.from(context);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LoadingLayout, defStyleAttr, R.style.LoadingLayout_Style);
        mEmptyImage = a.getResourceId(R.styleable.LoadingLayout_llEmptyImage, NO_ID);
        mEmptyText = a.getString(R.styleable.LoadingLayout_llEmptyText);

        mErrorImage = a.getResourceId(R.styleable.LoadingLayout_llErrorImage, NO_ID);
        mErrorText = a.getString(R.styleable.LoadingLayout_llErrorText);
        mRetryText = a.getString(R.styleable.LoadingLayout_llRetryText);

        mTextColor = a.getColor(R.styleable.LoadingLayout_llTextColor, 0xff999999);
        mTextSize = a.getDimensionPixelSize(R.styleable.LoadingLayout_llTextSize, dp2px(16));

        mButtonTextColor = a.getColor(R.styleable.LoadingLayout_llButtonTextColor, 0xff999999);
        mButtonTextSize = a.getDimensionPixelSize(R.styleable.LoadingLayout_llButtonTextSize, dp2px(16));
        mButtonBackground = a.getDrawable(R.styleable.LoadingLayout_llButtonBackground);

        mEmptyResId = a.getResourceId(R.styleable.LoadingLayout_llEmptyResId, R.layout.loading_layout_empty);
        mLoadingResId = a.getResourceId(R.styleable.LoadingLayout_llLoadingResId, R.layout.loading_layout_loading);
        mErrorResId = a.getResourceId(R.styleable.LoadingLayout_llErrorResId, R.layout.loading_layout_error);
        a.recycle();
    }

    int dp2px(float dp) {
        return (int) (getResources().getDisplayMetrics().density * dp);
    }


    LayoutInflater mInflater;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 0) {
            return;
        }
        if (getChildCount() > 1) {
            removeViews(1, getChildCount() - 1);
        }
        View view = getChildAt(0);
        setContentView(view);
        showLoading();
    }

    private void setContentView(View view) {
        mContentId = view.getId();
        mLayouts.put(mContentId, view);
    }

    //TODO 对外方法

    /**
     * 设置加载中布局
     *
     * @param id
     * @return
     */
    public LoadingLayout setLoading(@LayoutRes int id) {
        if (mLoadingResId != id) {
            remove(mLoadingResId);
            mLoadingResId = id;
        }
        return this;
    }

    /**
     * 设置空页面布局
     *
     * @param id
     * @return
     */
    public LoadingLayout setEmpty(@LayoutRes int id) {
        if (mEmptyResId != id) {
            remove(mEmptyResId);
            mEmptyResId = id;
        }
        return this;
    }


    public LoadingLayout setOnEmptyInflateListener(OnInflateListener listener) {
        mOnEmptyInflateListener = listener;
        if (mOnEmptyInflateListener != null && mLayouts.containsKey(mEmptyResId)) {
            listener.onInflate(mLayouts.get(mEmptyResId));
        }
        return this;
    }

    public LoadingLayout setOnErrorInflateListener(OnInflateListener listener) {
        mOnErrorInflateListener = listener;
        if (mOnErrorInflateListener != null && mLayouts.containsKey(mErrorResId)) {
            listener.onInflate(mLayouts.get(mErrorResId));
        }
        return this;
    }

    public LoadingLayout setEmptyImage(@DrawableRes int resId) {
        mEmptyImage = resId;
        image(mEmptyResId, R.id.loadingEmptyIv, mEmptyImage);
        return this;
    }

    public LoadingLayout setEmptyText(String value) {
        mEmptyText = value;
        text(mEmptyResId, R.id.loadingEmptyTv, mEmptyText);
        return this;
    }

    public LoadingLayout setErrorImage(@DrawableRes int resId) {
        mErrorImage = resId;
        image(mErrorResId, R.id.loadingErrorIv, mErrorImage);
        return this;
    }

    public LoadingLayout setErrorText(String value) {
        mErrorText = value;
        text(mErrorResId, R.id.loadingErrorTv, mErrorText);
        return this;
    }

    public LoadingLayout setRetryText(String text) {
        mRetryText = text;
        text(mErrorResId, R.id.loadingRetryBtn, mRetryText);
        return this;
    }

    public LoadingLayout setRetryListener(OnClickListener listener) {
        mRetryListener = listener;
        return this;
    }

    /**
     * 加载中
     */
    public void showLoading() {
        show(mLoadingResId);
    }

    /**
     * 空页面
     */
    public void showEmpty() {
        show(mEmptyResId);
    }

    /**
     * 加载失败
     */
    public void showError() {
        show(mErrorResId);
    }

    /**
     * 显示内容
     */
    public void showContent() {
        show(mContentId);
    }

    private void show(int layoutId) {
        for (View view : mLayouts.values()) {
            view.setVisibility(GONE);
        }
        layout(layoutId).setVisibility(VISIBLE);
    }

    private void remove(int layoutId) {
        if (mLayouts.containsKey(layoutId)) {
            View vg = mLayouts.remove(layoutId);
            removeView(vg);
        }
    }

    private View layout(int layoutId) {
        if (mLayouts.containsKey(layoutId)) {
            return mLayouts.get(layoutId);
        }
        View layout = mInflater.inflate(layoutId, this, false);
        layout.setVisibility(GONE);
        addView(layout);
        mLayouts.put(layoutId, layout);

        if (layoutId == mEmptyResId) {
            ImageView img = layout.findViewById(R.id.loadingEmptyIv);
            if (img != null) {
                img.setImageResource(mEmptyImage);
            }
            TextView view = layout.findViewById(R.id.loadingEmptyTv);
            if (view != null) {
                view.setText(mEmptyText);
                view.setTextColor(mTextColor);
                view.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
            }
            if (mOnEmptyInflateListener != null) {
                mOnEmptyInflateListener.onInflate(layout);
            }
        } else if (layoutId == mErrorResId) {
            ImageView img = layout.findViewById(R.id.loadingErrorIv);
            if (img != null) {
                img.setImageResource(mErrorImage);
            }
            TextView txt = layout.findViewById(R.id.loadingErrorTv);
            if (txt != null) {
                txt.setText(mErrorText);
                txt.setTextColor(mTextColor);
                txt.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
            }
            TextView btn = layout.findViewById(R.id.loadingRetryBtn);
            if (btn != null) {
                btn.setText(mRetryText);
                btn.setTextColor(mButtonTextColor);
                btn.setTextSize(TypedValue.COMPLEX_UNIT_PX, mButtonTextSize);
                btn.setBackground(mButtonBackground);
                btn.setOnClickListener(mRetryButtonClickListener);
            }
            if (mOnErrorInflateListener != null) {
                mOnErrorInflateListener.onInflate(layout);
            }
        }
        return layout;
    }

    private void text(int layoutId, int ctrlId, CharSequence value) {
        if (mLayouts.containsKey(layoutId)) {
            TextView view = mLayouts.get(layoutId).findViewById(ctrlId);
            if (view != null) {
                view.setText(value);
            }
        }
    }

    private void image(int layoutId, int ctrlId, int resId) {
        if (mLayouts.containsKey(layoutId)) {
            ImageView view = mLayouts.get(layoutId).findViewById(ctrlId);
            if (view != null) {
                view.setImageResource(resId);
            }
        }
    }
}

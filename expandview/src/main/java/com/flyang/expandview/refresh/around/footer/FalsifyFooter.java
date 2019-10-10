package com.flyang.expandview.refresh.around.footer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import com.flyang.expandview.refresh.around.internal.falsify.FalsifyAbstract;
import com.flyang.view.layout.refresh.constant.RefreshState;
import com.flyang.view.layout.refresh.inter.RefreshFooter;
import com.flyang.view.layout.refresh.inter.RefreshKernel;
import com.flyang.view.layout.refresh.inter.RefreshLayout;


/**
 * 虚假的 Footer
 * 用于 正真的 Footer 在 RefreshLayout 外部时，
 * Created by scwang on 2017/6/14.
 */
@SuppressWarnings("unused")
public class FalsifyFooter extends FalsifyAbstract implements RefreshFooter {

    //<editor-fold desc="FalsifyHeader">
    public FalsifyFooter(Context context) {
        this(context, null);
    }

    public FalsifyFooter(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }
    //</editor-fold>

    //<editor-fold desc="RefreshFooter">
    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {
        mRefreshKernel = kernel;
        kernel.getRefreshLayout().setEnableAutoLoadMore(false);
    }

    @Override
    public void onReleased(@NonNull RefreshLayout layout, int height, int maxDragHeight) {
        if (mRefreshKernel != null) {
            mRefreshKernel.setState(RefreshState.None);
            //onReleased 的时候 调用 setState(RefreshState.None); 并不会立刻改变成 None
            //而是先执行一个回弹动画，LoadFinish 是介于 Refreshing 和 None 之间的状态
            //LoadFinish 用于在回弹动画结束时候能顺利改变为 None
            mRefreshKernel.setState(RefreshState.LoadFinish);
        }
    }
    //</editor-fold>

}

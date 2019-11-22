package com.flyang.demo;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;

import com.flyang.base.view.SmartRefreshLayout;
import com.flyang.base.view.refresh.around.ClassicsFooter;
import com.flyang.base.view.refresh.around.ClassicsHeader;
import com.flyang.base.view.refresh.inter.RefreshFooter;
import com.flyang.base.view.refresh.inter.RefreshHeader;
import com.flyang.base.view.refresh.inter.RefreshLayout;
import com.flyang.base.view.refresh.listener.DefaultRefreshFooterCreator;
import com.flyang.base.view.refresh.listener.DefaultRefreshHeaderCreator;
import com.flyang.base.view.refresh.listener.DefaultRefreshInitializer;
import com.flyang.util.app.ApplicationUtils;

/**
 * @author yangfei.cao
 * @ClassName viewlib
 * @date 2019/6/29
 * ------------- Description -------------
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationUtils.init(this);
        //启用矢量图兼容
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        //设置全局默认配置（优先级最低，会被其他设置覆盖）
        SmartRefreshLayout.setDefaultRefreshInitializer(new DefaultRefreshInitializer() {
            @Override
            public void initialize(@NonNull Context context, @NonNull RefreshLayout layout) {
                //全局设置（优先级最低）
                layout.setEnableAutoLoadMore(true);
                layout.setEnableOverScrollDrag(false);
                layout.setEnableOverScrollBounce(true);
                layout.setEnableLoadMoreWhenContentNotFull(true);
                layout.setEnableScrollContentWhenRefreshed(true);
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);
            }
        });

        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                //全局设置主题颜色（优先级第二低，可以覆盖 DefaultRefreshInitializer 的配置，与下面的ClassicsHeader绑定）
                layout.setEnableHeaderTranslationContent(true);
                return new ClassicsHeader(context).setTimeFormat(new DynamicTimeFormat("更新于 %s"));
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new ClassicsFooter(context).setPrimaryColorId(R.color.color_aa72d572);
            }
        });
    }
}

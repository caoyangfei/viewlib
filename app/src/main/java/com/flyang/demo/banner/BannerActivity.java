package com.flyang.demo.banner;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.flyang.base.view.refresh.constant.RefreshState;
import com.flyang.base.view.refresh.constant.SpinnerStyle;
import com.flyang.base.view.refresh.inter.RefreshLayout;
import com.flyang.base.view.refresh.listener.OnMultiListener;
import com.flyang.demo.R;
import com.flyang.expandview.banner.transformer.ZoomStackPageTransformer;
import com.flyang.expandview.refresh.around.footer.BallPulseFooter;
import com.flyang.expandview.refresh.around.header.MaterialHeader;
import com.flyang.view.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class BannerActivity extends AppCompatActivity {

    private RefreshLayout refreshLayout;
    private Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        refreshLayout = findViewById(R.id.refreshLayout);
        banner = findViewById(R.id.banner);

        List<Integer> list=new ArrayList<>();
        list.add(R.mipmap.b1);
        list.add(R.mipmap.b2);
        list.add(R.mipmap.b3);

        banner.setImages(list).setImageLoader(new GlideImageLoader()).start();
        banner.setBannerAnimation(ZoomStackPageTransformer.class);
        /*
         * 以下代码仅仅为了演示效果而已，不是必须的
         */
        //设置主题颜色
        refreshLayout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);
        refreshLayout.autoRefresh();
        //设置 Header 为 Material风格
        refreshLayout.setRefreshHeader(new MaterialHeader(this).setShowBezierWave(true));
        //设置 Footer 为 球脉冲
        refreshLayout.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.FixedBehind));


        refreshLayout.setOnMultiListener(new OnMultiListener() {
            @Override
            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
                if (oldState == RefreshState.LoadFinish && newState == RefreshState.None) {
                    refreshLayout.autoRefresh();
                    refreshLayout.setOnMultiListener(null);
                }
            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(3000);
            }
        });
    }


}

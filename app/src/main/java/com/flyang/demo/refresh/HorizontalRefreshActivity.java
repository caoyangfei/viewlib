package com.flyang.demo.refresh;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.flyang.demo.R;
import com.flyang.view.layout.refresh.constant.RefreshState;
import com.flyang.view.layout.refresh.inter.RefreshLayout;
import com.flyang.view.layout.refresh.listener.OnMultiListener;

public class HorizontalRefreshActivity extends AppCompatActivity {

    private RefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_refresh);

        refreshLayout = findViewById(R.id.refreshLayout);


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
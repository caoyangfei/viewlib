package com.flyang.demo.refresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.flyang.base.view.refresh.inter.RefreshLayout;
import com.flyang.demo.R;

public class AssignXmlRefreshActivity extends AppCompatActivity {

    private RefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignxml_refresh);

        refreshLayout = findViewById(R.id.refreshLayout);

//        refreshLayout.setRefreshHeader(new RefreshHeaderWrapper(new ArrowHeader(this)));

//        refreshLayout.setOnMultiListener(new OnMultiListener() {
//            @Override
//            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
//                if (oldState == RefreshState.LoadFinish && newState == RefreshState.None) {
//                    refreshLayout.autoRefresh();
//                    refreshLayout.setOnMultiListener(null);
//                }
//            }
//
//            @Override
//            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//                refreshLayout.finishLoadMore(2000);
//            }
//
//            @Override
//            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
//                refreshLayout.finishRefresh(3000);
//            }
//        });
    }


}

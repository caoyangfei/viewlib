package com.flyang.demo.refresh;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.flyang.demo.R;
import com.flyang.view.layout.refresh.inter.RefreshLayout;
import com.flyang.view.layout.refresh.listener.OnMultiListener;

public class PureRollingRefreshActivity extends AppCompatActivity {

    private RefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purerolling_refresh);

        refreshLayout = findViewById(R.id.refreshLayout);

        refreshLayout.setOnMultiListener(new OnMultiListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }

        });
    }


}

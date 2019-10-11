package com.flyang.demo.refresh;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.flyang.demo.R;
import com.flyang.demo.StatusBarUtil;
import com.flyang.expandview.refresh.around.header.TwoLevelHeader;
import com.flyang.expandview.refresh.around.listener.OnTwoLevelListener;
import com.flyang.view.layout.refresh.constant.RefreshState;
import com.flyang.view.layout.refresh.inter.RefreshHeader;
import com.flyang.view.layout.refresh.inter.RefreshLayout;
import com.flyang.view.layout.refresh.listener.OnMultiListener;
import com.flyang.view.layout.refresh.listener.OnRefreshListener;

import java.util.Arrays;
import java.util.List;

public class TwoLevelRefreshActivity extends AppCompatActivity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twolevel_refresh);


        final View floor = findViewById(R.id.second_floor);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        final TwoLevelHeader header = findViewById(R.id.header);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final RefreshLayout refreshLayouts = findViewById(R.id.refreshLayout);
        refreshLayouts.setOnMultiListener(new OnMultiListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Toast.makeText(TwoLevelRefreshActivity.this, "触发刷新事件", Toast.LENGTH_SHORT).show();
                refreshLayout.finishRefresh(2000);
            }

            @Override
            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
                toolbar.setAlpha(1 - Math.min(percent, 1));
                floor.setTranslationY(Math.min(offset - floor.getHeight() + toolbar.getHeight(), refreshLayouts.getLayout().getHeight() - floor.getHeight()));
            }

            @Override
            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
                if (oldState == RefreshState.TwoLevel) {
                    findViewById(R.id.second_floor_content).animate().alpha(0).setDuration(1000);
                }
            }
        });

        /*
         * 主动打开二楼
         */
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                header.openTwoLevel(true);
            }
        });

        header.setOnTwoLevelListener(new OnTwoLevelListener() {
            @Override
            public boolean onTwoLevel(@NonNull RefreshLayout refreshLayout) {
                Toast.makeText(TwoLevelRefreshActivity.this, "触发二楼事件", Toast.LENGTH_SHORT).show();
                findViewById(R.id.second_floor_content).animate().alpha(1).setDuration(2000);
//                refreshLayout.getLayout().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        header.finishTwoLevel();
//                        root.findViewById(R.id.second_floor_content).animate().alpha(0).setDuration(1000);
//                    }
//                },5000);
                return true;//true 将会展开二楼状态 false 关闭刷新
            }
        });

        refreshLayouts.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Toast.makeText(TwoLevelRefreshActivity.this, "触发刷新事件", Toast.LENGTH_SHORT).show();
                refreshLayout.finishRefresh(2000);
            }
        });

        ListView listView = findViewById(R.id.listview);
        if (listView != null) {
            listView.setNestedScrollingEnabled(false);
            List<String> voids = Arrays.asList("1", "2", "3", "1", "2", "3", "9", "0", "12", "32", "4", "7", "13", "89", "90", "08", "79", "68", "90", "78");
            listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                    android.R.id.text1, voids) {
            });
        }

//        BarUtils.setStatusBarColor(this, getResources().getColor(R.color.transparent), 255);
//        BarUtils.addMarginTopEqualStatusBarHeight(findViewById(R.id.classics));
//        BarUtils.addMarginTopEqualStatusBarHeight(findViewById(R.id.toolbar));
//        BarUtils.addMarginTopEqualStatusBarHeight(findViewById(R.id.contentPanel));
//        //状态栏透明和间距处理
        StatusBarUtil.immersive(this);
        StatusBarUtil.setMargin(this, findViewById(R.id.classics));
        StatusBarUtil.setPaddingSmart(this, findViewById(R.id.toolbar));
        StatusBarUtil.setPaddingSmart(this, findViewById(R.id.contentPanel));
    }


}

package com.flyang.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flyang.demo.banner.BannerActivity;
import com.flyang.demo.refresh.AssignRefreshActivity;
import com.flyang.demo.refresh.AssignXmlRefreshActivity;
import com.flyang.demo.refresh.HorizontalRefreshActivity;
import com.flyang.demo.refresh.LottieRefreshActivity;
import com.flyang.demo.refresh.PureRollingRefreshActivity;
import com.flyang.demo.refresh.TwoLevelRefreshActivity;
import com.flyang.util.app.ActivityUtils;
import com.flyang.util.view.KeyboardUtils;
import com.flyang.view.inter.Delegate;
import com.flyang.view.layout.manager.SwipeBackManager;
import com.flyang.view.progress.CircularAnim;

public class MainActivity extends AppCompatActivity implements Delegate {

    protected SwipeBackManager swipeBackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initSwipeBackFinish();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LoadingLayout loadingLayout = LoadingLayout.wrap(this);
//        loadingLayout.setRetryListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "retry", Toast.LENGTH_LONG).show();
//                loadingLayout.showContent();
//            }
//        });
//        loadingLayout.showError();
//        loadingLayout.showContent();
    }

    /**
     * 初始化滑动返回。在 super.onCreate(savedInstanceState) 之前调用该方法
     */
    private void initSwipeBackFinish() {
        swipeBackManager = new SwipeBackManager(this, this);

        // 「必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回」
        // 下面几项可以不配置，这里只是为了讲述接口用法。

        // 设置滑动返回是否可用。默认值为 true
        swipeBackManager.setSwipeBackEnable(true);
        // 设置是否仅仅跟踪左侧边缘的滑动返回。默认值为 true
        swipeBackManager.setIsOnlyTrackingLeftEdge(false);
        // 设置是否是微信滑动返回样式。默认值为 true
        swipeBackManager.setIsWeChatStyle(true);
        // 设置阴影资源 id。默认值为 R.drawable.bga_sbl_shadow
        swipeBackManager.setShadowResId(R.drawable.swipeback_shadow_bg_view);
        // 设置是否显示滑动返回的阴影效果。默认值为 true
        swipeBackManager.setIsNeedShowShadow(true);
        // 设置阴影区域的透明度是否根据滑动的距离渐变。默认值为 true
        swipeBackManager.setIsShadowAlphaGradient(true);
        // 设置触发释放后自动滑动返回的阈值，默认值为 0.3f
        swipeBackManager.setSwipeBackThreshold(0.3f);
        // 设置底部导航条是否悬浮在内容上，默认值为 false
        swipeBackManager.setIsNavigationBarOverlap(false);
    }

    @Override
    public boolean isSupportSwipeBack() {
        return true;
    }

    @Override
    public void onSwipeBackLayoutSlide(float slideOffset) {

    }

    @Override
    public void onSwipeBackLayoutCancel() {

    }

    @Override
    public void onSwipeBackLayoutExecuted() {
        KeyboardUtils.hideSoftInput(this);
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed() {
        // 正在滑动返回的时候取消返回按钮事件
        if (swipeBackManager.isSliding()) {
            return;
        }
        finish();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.test:
                Intent intent = new Intent(this, TestActivity.class);
                startActivity(intent);
                break;
            case R.id.refreshBtn1:
                CircularAnim.fullActivity(MainActivity.this, view)
                        .colorOrImageRes(R.color.colorPrimary)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                ActivityUtils.startActivity(AssignRefreshActivity.class);
                            }
                        });
                break;
            case R.id.refreshBtn2:
                CircularAnim.fullActivity(MainActivity.this, view)
                        .colorOrImageRes(R.color.colorPrimary)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                ActivityUtils.startActivity(AssignXmlRefreshActivity.class);
                            }
                        });
                break;
            case R.id.refreshBtn3:
                CircularAnim.fullActivity(MainActivity.this, view)
                        .colorOrImageRes(R.color.color_2E8B57)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                ActivityUtils.startActivity(HorizontalRefreshActivity.class);
                            }
                        });
            case R.id.refreshBtn4:
                CircularAnim.fullActivity(MainActivity.this, view)
                        .colorOrImageRes(R.color.color_2E8B57)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                ActivityUtils.startActivity(PureRollingRefreshActivity.class);
                            }
                        });
                break;
            case R.id.refreshBtn5:
                CircularAnim.fullActivity(MainActivity.this, view)
                        .colorOrImageRes(R.color.color_2E8B57)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                ActivityUtils.startActivity(TwoLevelRefreshActivity.class);
                            }
                        });
                break;
            case R.id.refreshBtn6:
                CircularAnim.fullActivity(MainActivity.this, view)
                        .colorOrImageRes(R.color.color_2E8B57)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                ActivityUtils.startActivity(BannerActivity.class);
                            }
                        });
                break;
            case R.id.refreshBtn7:
                CircularAnim.fullActivity(MainActivity.this, view)
                        .colorOrImageRes(R.color.color_2E8B57)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                ActivityUtils.startActivity(LottieRefreshActivity.class);
                            }
                        });
                break;
        }
    }


}

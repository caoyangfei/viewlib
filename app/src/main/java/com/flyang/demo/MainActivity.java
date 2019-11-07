package com.flyang.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flyang.demo.banner.BannerActivity;
import com.flyang.demo.picker.PicekerActivity;
import com.flyang.demo.refresh.AssignRefreshActivity;
import com.flyang.demo.refresh.AssignXmlRefreshActivity;
import com.flyang.demo.refresh.HorizontalRefreshActivity;
import com.flyang.demo.refresh.LottieRefreshActivity;
import com.flyang.demo.refresh.PureRollingRefreshActivity;
import com.flyang.demo.refresh.TwoLevelRefreshActivity;
import com.flyang.util.app.ActivityUtils;
import com.flyang.view.progress.CircularAnim;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void onBackPressed() {
        finish();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.test:

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
            case R.id.refreshBtn8:
                CircularAnim.fullActivity(MainActivity.this, view)
                        .colorOrImageRes(R.color.color_2E8B57)
                        .go(new CircularAnim.OnAnimationEndListener() {
                            @Override
                            public void onAnimationEnd() {
                                ActivityUtils.startActivity(PicekerActivity.class);
                            }
                        });
                break;
        }
    }


}

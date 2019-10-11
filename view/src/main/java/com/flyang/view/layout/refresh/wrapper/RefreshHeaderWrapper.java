package com.flyang.view.layout.refresh.wrapper;

import android.annotation.SuppressLint;
import android.view.View;

import com.flyang.view.layout.refresh.inter.RefreshHeader;
import com.flyang.view.layout.refresh.simple.SimpleComponent;

/**
 * @author caoyangfei
 * @ClassName RefreshHeaderWrapper
 * @date 2019/10/11
 * ------------- Description -------------
 * 刷新头部包装
 */
@SuppressLint("ViewConstructor")
public class RefreshHeaderWrapper extends SimpleComponent implements RefreshHeader {

    public RefreshHeaderWrapper(View wrapper) {
        super(wrapper);
    }

}

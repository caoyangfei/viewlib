package com.flyang.view.layout.refresh.impl;

import android.annotation.SuppressLint;
import android.view.View;

import com.flyang.view.layout.refresh.inter.RefreshHeader;
import com.flyang.view.layout.refresh.internal.InternalAbstract;


/**
 * 刷新头部包装
 * Created by SCWANG on 2017/5/26.
 */
@SuppressLint("ViewConstructor")
public class RefreshHeaderWrapper extends InternalAbstract implements RefreshHeader/*, InvocationHandler*/ {

    public RefreshHeaderWrapper(View wrapper) {
        super(wrapper);
    }

}

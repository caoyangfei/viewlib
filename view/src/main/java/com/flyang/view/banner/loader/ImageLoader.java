package com.flyang.view.banner.loader;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;


public abstract class ImageLoader<T extends View> implements Serializable {


    public View getImageView(Context context) {
        T imageView = createImageView(context);
        return imageView == null ? new ImageView(context) : imageView;
    }

    /**
     * 创建ImageView
     *
     * @param context
     * @return
     */
    public T createImageView(Context context) {
        return null;
    }

    /**
     * 加载图片
     *
     * @param context
     * @param path
     * @param imageView
     */
    public abstract void displayImage(Context context, Object path, T imageView);
}

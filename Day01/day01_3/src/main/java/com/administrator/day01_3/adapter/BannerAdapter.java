package com.administrator.day01_3.adapter;


import android.content.Context;
import android.widget.ImageView;

import com.administrator.day01_3.bean.BannerBean;
import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Administrator on 2019/5/27.
 */

public class BannerAdapter extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        BannerBean.DataBean bansrc= (BannerBean.DataBean) path;
        Glide.with(context).load(bansrc.getImagePath()).into(imageView);
    }
}

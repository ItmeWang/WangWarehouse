package com.administrator.day01_3.view;


import com.administrator.day01_3.bean.BannerBean;

/**
 * Created by Administrator on 2019/5/27.
 */

public interface BannerView {
    void onSuccess(BannerBean bannerBean);
    void onFail(String fail);
}

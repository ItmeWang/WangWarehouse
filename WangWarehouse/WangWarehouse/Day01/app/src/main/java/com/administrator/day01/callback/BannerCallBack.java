package com.administrator.day01.callback;

import com.administrator.day01.bean.BannerBean;

/**
 * Created by Administrator on 2019/5/27.
 */

public interface BannerCallBack {
    void onSuccess(BannerBean bannerBean);
    void onFail(String fail);
}

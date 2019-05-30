package com.administrator.day01.api;

import com.administrator.day01.bean.BannerBean;
import com.administrator.day01.bean.StoryBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2019/5/27.
 */

public interface MyServer {

    String Story = " http://gank.io/";
    String Banner = " http://www.wanandroid.com/";

    @GET("banner/json")
    Observable<BannerBean> getData();

    @GET("api/data/%E7%A6%8F%E5%88%A9/10/42")
    Observable<StoryBean> gerData();
}

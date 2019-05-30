package com.administrator.day01_3.api;

import com.administrator.day01_3.bean.BannerBean;
import com.administrator.day01_3.bean.WelfareBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2019/5/28.
 */

public interface MyServer {
    String Banner = " http://www.wanandroid.com/";
    String WelfareUrl = " http://gank.io/";

    @GET("banner/json")
    Observable<BannerBean> getData();

    @GET("api/data/%E7%A6%8F%E5%88%A9/20/{page}")
    Observable<WelfareBean> getData(@Path("page") int page);
}

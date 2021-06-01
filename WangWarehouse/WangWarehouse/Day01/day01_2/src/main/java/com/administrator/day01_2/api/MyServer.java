package com.administrator.day01_2.api;

import com.administrator.day01_2.bean.StoryBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2019/5/28.
 */

public interface MyServer {

    String Story=" http://gank.io/";


    @GET("api/data/%E7%A6%8F%E5%88%A9/10/42")
    Observable<StoryBean> gerData();
}

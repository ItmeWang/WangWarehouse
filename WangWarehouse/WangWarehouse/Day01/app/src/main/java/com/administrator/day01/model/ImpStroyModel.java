package com.administrator.day01.model;


import com.administrator.day01.api.MyServer;
import com.administrator.day01.bean.StoryBean;
import com.administrator.day01.callback.StoryCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2019/5/27.
 */

public class ImpStroyModel implements StoryModel {
    @Override
    public void getData(final StoryCallBack storyCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.Story)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<StoryBean> data = myServer.gerData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StoryBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StoryBean storyBean) {
                        storyCallBack.onSuccess(storyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        storyCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}

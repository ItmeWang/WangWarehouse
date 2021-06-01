package com.administrator.day01.model;

import com.administrator.day01.api.MyServer;
import com.administrator.day01.bean.BannerBean;
import com.administrator.day01.callback.BannerCallBack;

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

public class ImpBannerModel implements BannerModel{

    @Override
    public void getData(final BannerCallBack bannerCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.Banner)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<BannerBean> data = myServer.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        bannerCallBack.onSuccess(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        bannerCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

package com.administrator.day01_3.model;

import com.administrator.day01_3.api.MyServer;
import com.administrator.day01_3.bean.WelfareBean;
import com.administrator.day01_3.callback.CallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2019/5/28.
 */

public class ImpWelfareModel implements WelfareModel {
    @Override
    public void getData(final int page, final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.WelfareUrl)
                .build();
        MyServer server = retrofit.create(MyServer.class);
        Observable<WelfareBean> data = server.getData(page);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WelfareBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WelfareBean welfareBean) {
                        callBack.onSuccess(page,welfareBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

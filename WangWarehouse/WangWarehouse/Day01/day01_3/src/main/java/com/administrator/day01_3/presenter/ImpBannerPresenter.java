package com.administrator.day01_3.presenter;


import com.administrator.day01_3.bean.BannerBean;
import com.administrator.day01_3.callback.BannerCallBack;
import com.administrator.day01_3.model.ImpBannerModel;
import com.administrator.day01_3.view.BannerView;

/**
 * Created by Administrator on 2019/5/27.
 */

public class ImpBannerPresenter implements BannerPresenter, BannerCallBack {
    private ImpBannerModel impBannerModel;
    private BannerView bannerView;

    public ImpBannerPresenter(ImpBannerModel impBannerModel, BannerView bannerView) {
        this.impBannerModel = impBannerModel;
        this.bannerView = bannerView;
    }

    @Override
    public void getData() {
        impBannerModel.getData(this);
    }

    @Override
    public void onSuccess(BannerBean bannerBean) {
        bannerView.onSuccess(bannerBean);
    }

    @Override
    public void onFail(String fail) {
        bannerView.onFail(fail);
    }
}

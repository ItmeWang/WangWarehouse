package com.administrator.day01_3.presenter;

import com.administrator.day01_3.bean.WelfareBean;
import com.administrator.day01_3.callback.CallBack;
import com.administrator.day01_3.model.ImpWelfareModel;
import com.administrator.day01_3.view.WelfarView;

/**
 * Created by Administrator on 2019/5/28.
 */

public class ImpWelarePresenter implements WelfarePresenter, CallBack {
    private ImpWelfareModel impWelfareModel;
    private WelfarView welfarView;

    public ImpWelarePresenter(ImpWelfareModel impWelfareModel, WelfarView welfarView) {
        this.impWelfareModel = impWelfareModel;
        this.welfarView = welfarView;
    }

    @Override
    public void getData(int page) {
        impWelfareModel.getData(page, this);
    }


    @Override
    public void onSuccess(int page, WelfareBean welfareBean) {
        welfarView.onSuccess(page,welfareBean);
    }

    @Override
    public void onFail(String fail) {
        welfarView.onFail(fail);
    }
}

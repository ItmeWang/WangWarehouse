package com.administrator.day01_2.presenter;

import com.administrator.day01_2.bean.StoryBean;
import com.administrator.day01_2.callback.StoryCallBack;
import com.administrator.day01_2.model.ImpStroyModel;
import com.administrator.day01_2.view.StoryView;

/**
 * Created by Administrator on 2019/5/27.
 */

public class ImpStoryPresenter implements StoryPresenter, StoryCallBack {
    private ImpStroyModel impStroyModel;
    private StoryView storyView;

    public ImpStoryPresenter(ImpStroyModel impStroyModel, StoryView storyView) {
        this.impStroyModel = impStroyModel;
        this.storyView = storyView;
    }

    @Override
    public void getData() {
        impStroyModel.getData(this);
    }

    @Override
    public void onSuccess(StoryBean storyBean) {
        storyView.onSuccess(storyBean);
    }

    @Override
    public void onFail(String fail) {
        storyView.onFail(fail);
    }
}

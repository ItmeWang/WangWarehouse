package com.administrator.day01_2.callback;


import com.administrator.day01_2.bean.StoryBean;

/**
 * Created by Administrator on 2019/5/27.
 */

public interface StoryCallBack {
    void onSuccess(StoryBean storyBean);
    void onFail(String fail);
}

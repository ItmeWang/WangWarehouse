package com.administrator.day01.view;

import com.administrator.day01.bean.BannerBean;
import com.administrator.day01.bean.StoryBean;

/**
 * Created by Administrator on 2019/5/27.
 */

public interface StoryView {
    void onSuccess(StoryBean storyBean);
    void onFail(String fail);
}

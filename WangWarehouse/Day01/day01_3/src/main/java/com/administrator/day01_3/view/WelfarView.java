package com.administrator.day01_3.view;

import com.administrator.day01_3.bean.WelfareBean;

/**
 * Created by Administrator on 2019/5/28.
 */

public interface WelfarView {
    void onSuccess(int page,WelfareBean welfareBean);
    void onFail(String fail);
}

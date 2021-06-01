package com.administrator.day01.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.administrator.day01.R;
import com.administrator.day01.adapter.BannerAdapter;
import com.administrator.day01.adapter.IntegerAdapter;
import com.administrator.day01.adapter.StoryAdapter;
import com.administrator.day01.bean.BannerBean;
import com.administrator.day01.bean.IntergerBean;
import com.administrator.day01.bean.StoryBean;
import com.administrator.day01.model.ImpBannerModel;
import com.administrator.day01.model.ImpStroyModel;
import com.administrator.day01.presenter.ImpBannerPresenter;
import com.administrator.day01.presenter.ImpStoryPresenter;
import com.administrator.day01.view.BannerView;
import com.administrator.day01.view.StoryView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StoryFragment extends Fragment implements BannerView, StoryView {


    private View view;
    private GridView mGv;
    private RecyclerView mRv;
    private ArrayList<IntergerBean> integerList;
    private IntegerAdapter integerAdapter;
    private Banner mBan;
    private ArrayList<StoryBean.ResultsBean> list;
    private StoryAdapter storyAdapter;

    public StoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_story, container, false);
        initView(inflate);
        initDataBanner();
        initData();
        return inflate;
    }

    private void initData() {
        new ImpStoryPresenter(new ImpStroyModel(), this).getData();
    }

    private void initView(View inflate) {
        mGv = (GridView) inflate.findViewById(R.id.gv);
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);
        mBan = (Banner) inflate.findViewById(R.id.ban);

        integerList = new ArrayList<>();
        integerList.add(new IntergerBean(R.mipmap.story_icon_new, "最新"));
        integerList.add(new IntergerBean(R.mipmap.story_icon_morning, "叫早"));
        integerList.add(new IntergerBean(R.mipmap.story_icon_sleep, "哄睡"));
        integerList.add(new IntergerBean(R.mipmap.story_icon_classify, "全部"));
        integerAdapter = new IntegerAdapter(integerList, getActivity());
        mGv.setAdapter(integerAdapter);

        mRv.setLayoutManager(new GridLayoutManager(getContext(),2));
        list = new ArrayList<>();
        storyAdapter = new StoryAdapter(getContext(), list);
        mRv.setAdapter(storyAdapter);
    }

    private void initDataBanner() {
        new ImpBannerPresenter(new ImpBannerModel(),this).getData();
    }

    @Override
    public void onSuccess(BannerBean bannerBean) {
        List<BannerBean.DataBean> data = bannerBean.getData();
        mBan.setImageLoader(new BannerAdapter());
        mBan.setImages(data);
        mBan.start();
    }

    @Override
    public void onSuccess(StoryBean storyBean) {
        List<StoryBean.ResultsBean> results = storyBean.getResults();
        list.addAll(results);
        storyAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String fail) {
        Log.e("--Main--", "onFail: "+fail);
    }
}

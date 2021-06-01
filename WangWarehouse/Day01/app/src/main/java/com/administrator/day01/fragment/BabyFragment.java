package com.administrator.day01.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.administrator.day01.R;
import com.administrator.day01.adapter.BabyAdapter;
import com.administrator.day01.adapter.BannerAdapter;
import com.administrator.day01.bean.BannerBean;
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
public class BabyFragment extends Fragment implements BannerView, StoryView {


    private View view;
    private Banner mBan;
    private RecyclerView mRv;
    private ArrayList<StoryBean.ResultsBean> list;
    private ArrayList<StoryBean.ResultsBean> list2;
    private BabyAdapter adapter;
    private BabyAdapter adapter2;
    private RecyclerView mRv2;

    public BabyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_baby, container, false);
        initView(inflate);
        initDataBanner();
        initData();
        return inflate;
    }


    private void initData() {
        new ImpStoryPresenter(new ImpStroyModel(), this).getData();
    }

    private void initView(View inflate) {
        mBan = (Banner) inflate.findViewById(R.id.ban);
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new BabyAdapter(getContext(), list);
        mRv.setAdapter(adapter);

        mRv2 = (RecyclerView) inflate.findViewById(R.id.rv2);
        mRv2.setLayoutManager(new LinearLayoutManager(getContext()));
        list2 = new ArrayList<>();
        adapter2 = new BabyAdapter(getContext(), list);
        mRv2.setAdapter(adapter);
    }

    private void initDataBanner() {
        new ImpBannerPresenter(new ImpBannerModel(), this).getData();
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
        adapter.notifyDataSetChanged();
        list2.addAll(results);
        adapter2.notifyDataSetChanged();
    }

    @Override
    public void onFail(String fail) {
        Log.e("--Main--", "onFail: " + fail);
    }
}

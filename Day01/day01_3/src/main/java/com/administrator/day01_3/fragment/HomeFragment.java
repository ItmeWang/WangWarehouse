package com.administrator.day01_3.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.administrator.day01_3.R;
import com.administrator.day01_3.adapter.BannerAdapter;
import com.administrator.day01_3.adapter.IntegerAdapter;
import com.administrator.day01_3.adapter.Welfare2Adapter;
import com.administrator.day01_3.adapter.WelfareAdapter;
import com.administrator.day01_3.bean.BannerBean;
import com.administrator.day01_3.bean.IntergerBean;
import com.administrator.day01_3.bean.WelfareBean;
import com.administrator.day01_3.model.ImpBannerModel;
import com.administrator.day01_3.model.ImpWelfareModel;
import com.administrator.day01_3.presenter.ImpBannerPresenter;
import com.administrator.day01_3.presenter.ImpWelarePresenter;
import com.administrator.day01_3.view.BannerView;
import com.administrator.day01_3.view.WelfarView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements BannerView, WelfarView {


    private View view;
    private Banner mBan;
    private GridView mGv;
    private RecyclerView mRv;
    private ArrayList<IntergerBean> integerList;
    private ArrayList<WelfareBean.ResultsBean> list;
    private Welfare2Adapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        initDataBanner();
        return inflate;
    }

    private void initView(View inflate) {
        mBan = (Banner) inflate.findViewById(R.id.ban);
        mGv = (GridView) inflate.findViewById(R.id.gv);
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);

        integerList = new ArrayList<>();
        integerList.add(new IntergerBean(R.mipmap.icon_main_free_travel, "自由行"));
        integerList.add(new IntergerBean(R.mipmap.icon_main_airticket, "机票"));
        integerList.add(new IntergerBean(R.mipmap.icon_main_visa, "签证"));
        integerList.add(new IntergerBean(R.mipmap.icon_main_destination_travel, "目的地参团"));
        integerList.add(new IntergerBean(R.mipmap.icon_main_half_free, "半自由行"));
        integerList.add(new IntergerBean(R.mipmap.icon_main_hotel, "酒店"));
        integerList.add(new IntergerBean(R.mipmap.icon_main_ticket, "门票"));
        integerList.add(new IntergerBean(R.mipmap.icon_main_other_product, "其他"));
        IntegerAdapter integerAdapter = new IntegerAdapter(integerList, getActivity());
        mGv.setAdapter(integerAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRv.setLayoutManager(linearLayoutManager);
        list = new ArrayList<>();
        adapter = new Welfare2Adapter(getContext(), list);
        mRv.setAdapter(adapter);
        initData();

    }

    private void initData() {
        new ImpWelarePresenter(new ImpWelfareModel(),this).getData(3);
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
    public void onSuccess(int page, WelfareBean welfareBean) {
        list.addAll(welfareBean.getResults());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String fail) {
        Log.e("--Main--", "onFail: " + fail);
    }
}

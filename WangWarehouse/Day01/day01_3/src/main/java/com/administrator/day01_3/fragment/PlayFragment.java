package com.administrator.day01_3.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.administrator.day01_3.R;
import com.administrator.day01_3.adapter.Welfare2Adapter;
import com.administrator.day01_3.adapter.WelfareAdapter;
import com.administrator.day01_3.bean.WelfareBean;
import com.administrator.day01_3.model.ImpWelfareModel;
import com.administrator.day01_3.presenter.ImpWelarePresenter;
import com.administrator.day01_3.view.WelfarView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment implements WelfarView {


    private View view;
    private RecyclerView mRv1;
    private RecyclerView mRv2;
    private ArrayList<WelfareBean.ResultsBean> list;
    private WelfareAdapter adapter;
    private Welfare2Adapter adapter1;

    public PlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_play, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRv1 = (RecyclerView) inflate.findViewById(R.id.rv1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRv1.setLayoutManager(linearLayoutManager);
        mRv2 = (RecyclerView) inflate.findViewById(R.id.rv2);
        mRv2.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new WelfareAdapter(getContext(), list);
        adapter1 = new Welfare2Adapter(getContext(), list);
        mRv1.setAdapter(adapter1);
        mRv2.setAdapter(adapter);
        initData();
    }

    private void initData() {
        new ImpWelarePresenter(new ImpWelfareModel(),this).getData(7);
    }

    @Override
    public void onSuccess(int page, WelfareBean welfareBean) {
        list.addAll(welfareBean.getResults());
        adapter.notifyDataSetChanged();
        adapter1.notifyDataSetChanged();
    }

    @Override
    public void onFail(String fail) {
        Log.e("--Main--", "onFail: " + fail);
    }
}

package com.administrator.day01_3.fragment.xfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.administrator.day01_3.R;
import com.administrator.day01_3.adapter.WelfareAdapter;
import com.administrator.day01_3.bean.WelfareBean;
import com.administrator.day01_3.model.ImpWelfareModel;
import com.administrator.day01_3.presenter.ImpWelarePresenter;
import com.administrator.day01_3.view.WelfarView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EuropeFragment extends Fragment implements WelfarView {


    private View view;
    private RecyclerView mRv;
    private ArrayList<WelfareBean.ResultsBean> list;
    private WelfareAdapter adapter;

    public EuropeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_europe, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new WelfareAdapter(getContext(), list);
        mRv.setAdapter(adapter);
        initData();
    }

    private void initData() {
        int page=32;
        new ImpWelarePresenter(new ImpWelfareModel(),this).getData(page);
    }

    @Override
    public void onSuccess(int page, WelfareBean welfareBean) {
        list.addAll(welfareBean.getResults());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String fail) {
        Log.e("--Main--", "onFail: "+fail );
    }
}

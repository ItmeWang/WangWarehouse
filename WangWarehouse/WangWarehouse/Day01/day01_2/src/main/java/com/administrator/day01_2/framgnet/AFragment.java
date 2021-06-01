package com.administrator.day01_2.framgnet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.administrator.day01_2.R;
import com.administrator.day01_2.adapter.StoryAdapter;
import com.administrator.day01_2.bean.StoryBean;
import com.administrator.day01_2.model.ImpStroyModel;
import com.administrator.day01_2.presenter.ImpStoryPresenter;
import com.administrator.day01_2.view.StoryView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements StoryView {


    private View view;
    private RecyclerView mRv;
    private ArrayList<StoryBean.ResultsBean> list;
    private StoryAdapter adapter;

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new StoryAdapter(getContext(), list);
        mRv.setAdapter(adapter);
        initData();
    }

    private void initData() {
        new ImpStoryPresenter(new ImpStroyModel(),this).getData();
    }

    @Override
    public void onSuccess(StoryBean storyBean) {
        List<StoryBean.ResultsBean> results = storyBean.getResults();
        list.addAll(results);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String fail) {
        Log.e("--Main", "onFail: "+fail );
    }
}

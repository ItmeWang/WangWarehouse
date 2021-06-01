package com.administrator.day01_2.framgnet;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.administrator.day01_2.R;
import com.administrator.day01_2.adapter.FragmentAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GrowFragment extends Fragment {


    private View view;
    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> list;
    private FragmentAdapter adapter;

    public GrowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_grow, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mTab = (TabLayout) inflate.findViewById(R.id.tab);
        mVp = (ViewPager) inflate.findViewById(R.id.vp);

        mTab.addTab(mTab.newTab().setText("专题活动"));
        mTab.addTab(mTab.newTab().setText("人气宝贝"));

        list = new ArrayList<>();
        list.add(new AFragment());
        list.add(new BFragment());
        adapter = new FragmentAdapter(getChildFragmentManager(), list);
        mVp.setAdapter(adapter);
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
    }
}

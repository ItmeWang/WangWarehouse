package com.administrator.day01_3.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.administrator.day01_3.R;
import com.administrator.day01_3.adapter.FragmentAdapter;
import com.administrator.day01_3.fragment.xfragment.AsiaFragment;
import com.administrator.day01_3.fragment.xfragment.EuropeFragment;
import com.administrator.day01_3.fragment.xfragment.IslandFragment;
import com.administrator.day01_3.fragment.xfragment.KoreaFragment;
import com.administrator.day01_3.fragment.xfragment.OtherFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomFragment extends Fragment {


    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> list;
    private FragmentAdapter adapter;

    public CustomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_custom, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mTab = (TabLayout) inflate.findViewById(R.id.tab);
        mVp = (ViewPager) inflate.findViewById(R.id.vp);
        mTab.addTab(mTab.newTab().setText("欧美"));
        mTab.addTab(mTab.newTab().setText("东南亚"));
        mTab.addTab(mTab.newTab().setText("海岛"));
        mTab.addTab(mTab.newTab().setText("日韩"));
        mTab.addTab(mTab.newTab().setText("其他"));

        list = new ArrayList<>();
        list.add(new EuropeFragment());
        list.add(new AsiaFragment());
        list.add(new IslandFragment());
        list.add(new KoreaFragment());
        list.add(new OtherFragment());

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

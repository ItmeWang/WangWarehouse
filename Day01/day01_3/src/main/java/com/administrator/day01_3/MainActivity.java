package com.administrator.day01_3;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.administrator.day01_3.adapter.FragmentAdapter;
import com.administrator.day01_3.fragment.CustomFragment;
import com.administrator.day01_3.fragment.HomeFragment;
import com.administrator.day01_3.fragment.MyFragment;
import com.administrator.day01_3.fragment.PlayFragment;

import java.util.ArrayList;

//wangtainqi
public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment> list;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        mTab.addTab(mTab.newTab().setText("首页").setIcon(R.drawable.home_selector));
        mTab.addTab(mTab.newTab().setText("定制").setIcon(R.drawable.custom_selector));
        mTab.addTab(mTab.newTab().setText("当地玩乐").setIcon(R.drawable.play_selector));
        mTab.addTab(mTab.newTab().setText("我的").setIcon(R.drawable.my_selector));

        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new CustomFragment());
        list.add(new PlayFragment());
        list.add(new MyFragment());

        adapter = new FragmentAdapter(getSupportFragmentManager(), list);
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

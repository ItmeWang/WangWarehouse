package com.administrator.day01;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.administrator.day01.adapter.FragmentAdapter;
import com.administrator.day01.fragment.BabyFragment;
import com.administrator.day01.fragment.StoryFragment;

import java.util.ArrayList;



//王天奇
public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> list;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        mTab.addTab(mTab.newTab().setText("故事").setIcon(R.drawable.stoty_selector));
        mTab.addTab(mTab.newTab().setText("亲子").setIcon(R.drawable.baby_selector));

        list = new ArrayList<>();
        list.add(new StoryFragment());
        list.add(new BabyFragment());
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

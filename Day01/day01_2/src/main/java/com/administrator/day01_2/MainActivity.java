package com.administrator.day01_2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.administrator.day01_2.adapter.FragmentAdapter;
import com.administrator.day01_2.framgnet.DiscoverFragment;
import com.administrator.day01_2.framgnet.GrowFragment;
import com.administrator.day01_2.framgnet.HomeFragment;
import com.administrator.day01_2.framgnet.MyFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    /**
     * 主页
     */
    private RadioButton mRb1;
    /**
     * 发现
     */
    private RadioButton mRb2;
    /**
     * 成长
     */
    private RadioButton mRb3;
    /**
     * 我的
     */
    private RadioButton mRb4;
    private ArrayList<Fragment> list;
    private ViewPager mVp;
    private RadioGroup mLl;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mLl = (RadioGroup) findViewById(R.id.ll);
        mRb1 = (RadioButton) findViewById(R.id.rb1);
        mRb2 = (RadioButton) findViewById(R.id.rb2);
        mRb3 = (RadioButton) findViewById(R.id.rb3);
        mRb4 = (RadioButton) findViewById(R.id.rb4);
        mLl.setOnCheckedChangeListener(new myCheckChangeListener());

        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new GrowFragment());
        list.add(new DiscoverFragment());
        list.add(new MyFragment());
        adapter = new FragmentAdapter(getSupportFragmentManager(), list);
        mVp.setAdapter(adapter);
        mVp.setCurrentItem(0);
        mVp.setOnPageChangeListener(new myOnPageChangeListener());
    }
    private class myCheckChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb1:
                    mVp.setCurrentItem(0);
                    break;
                case R.id.rb2:
                    mVp.setCurrentItem(1);
                    break;
                case R.id.rb3:
                    mVp.setCurrentItem(2);
                    break;
                case R.id.rb4:
                    mVp.setCurrentItem(3);
                    break;
            }
        }
    }
    private class myOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            switch (position){
                case 0:
                    mLl.check(R.id.rb1);
                    break;
                case 1:
                    mLl.check(R.id.rb2);
                    break;
                case 2:
                    mLl.check(R.id.rb3);
                    break;
                case 3:
                    mLl.check(R.id.rb4);
                    break;
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}

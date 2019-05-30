package com.administrator.day01_2.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.day01_2.R;
import com.administrator.day01_2.bean.StoryBean;
import com.bumptech.glide.Glide;

import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Created by Administrator on 2019/5/27.
 */

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    private Context context;
    private List<StoryBean.ResultsBean> list;

    public StoryAdapter(Context context, List<StoryBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.story_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoryBean.ResultsBean resultsBean = list.get(position);
        Glide.with(context).load(resultsBean.getUrl()).into(holder.mSrc);
        holder.mTv1.setText(resultsBean.getType());
        holder.mTv2.setText(resultsBean.getWho());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mSrc;
        TextView mTv1;
        TextView mTv2;
        TextView mTv3;
        public ViewHolder(View itemView) {
            super(itemView);
            this.mSrc = (ImageView) itemView.findViewById(R.id.src);
            this.mTv1 = (TextView) itemView.findViewById(R.id.tv1);
            this.mTv2 = (TextView) itemView.findViewById(R.id.tv2);
        }
    }
}

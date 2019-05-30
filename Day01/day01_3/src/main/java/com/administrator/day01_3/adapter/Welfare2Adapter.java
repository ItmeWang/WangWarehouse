package com.administrator.day01_3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.day01_3.R;
import com.administrator.day01_3.bean.WelfareBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2019/5/28.
 */

public class Welfare2Adapter extends RecyclerView.Adapter<Welfare2Adapter.ViewHolder> {
    private Context context;
    private List<WelfareBean.ResultsBean> list;

    public Welfare2Adapter(Context context, List<WelfareBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item2_view, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WelfareBean.ResultsBean resultsBean = list.get(position);
        Glide.with(context).load(resultsBean.getUrl()).into(holder.mSrc);
        holder.mTv1.setText(resultsBean.getWho());
        holder.mTv2.setText(resultsBean.getDesc());
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

        public ViewHolder(View itemView) {
            super(itemView);
            this.mSrc = (ImageView) itemView.findViewById(R.id.src);
            this.mTv1 = (TextView) itemView.findViewById(R.id.tv1);
            this.mTv2 = (TextView) itemView.findViewById(R.id.tv2);

        }
    }
}

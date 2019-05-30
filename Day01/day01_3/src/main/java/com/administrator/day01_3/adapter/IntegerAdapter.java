package com.administrator.day01_3.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.day01_3.R;
import com.administrator.day01_3.bean.IntergerBean;

import java.util.List;

/**
 * Created by Administrator on 2019/5/27.
 */

public class IntegerAdapter extends BaseAdapter {
    private List<IntergerBean> list;
    private Context context;

    public IntegerAdapter(List<IntergerBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (holder==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.integer_view, null);
            holder = new ViewHolder();
            holder.mSrv = (ImageView) convertView.findViewById(R.id.srv);
            holder.mTv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        IntergerBean intergerBean = list.get(position);
        holder.mSrv.setImageResource(intergerBean.getSrc());
        holder.mTv.setText(intergerBean.getName());
        return convertView;
    }

    class ViewHolder {
        ImageView mSrv;
        TextView mTv;
    }
}

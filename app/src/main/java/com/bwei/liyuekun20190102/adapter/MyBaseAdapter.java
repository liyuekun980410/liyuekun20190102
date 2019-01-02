package com.bwei.liyuekun20190102.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.liyuekun20190102.R;
import com.bwei.liyuekun20190102.bean.User;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class MyBaseAdapter extends BaseAdapter {
    Context context;
    List<User.DataBean> list;
    LayoutInflater inflater;

    public MyBaseAdapter(Context context, List<User.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
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
        ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context,R.layout.item_layout,null);
            holder.image=convertView.findViewById(R.id.image);
            holder.text1=convertView.findViewById(R.id.text1);
            holder.text2=convertView.findViewById(R.id.text2);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(list.get(position).getImages(),holder.image);
        holder.text1.setText(list.get(position).getTitle());
        holder.text2.setText(list.get(position).getPrice()+"");
        return convertView;
    }
    class ViewHolder{
        ImageView image;
        TextView text1,text2;
    }
}

package com.example.wsg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wsg.R;
import com.example.wsg.entity.TodayData;

import java.util.List;

import static com.baidu.location.d.j.R;

/**
 * 项目名：App
 * 包名：com.example.wsg.app.adapter
 * 文件名：TodayAdapter
 * 创建者：wsg
 * 创建时间：2017/3/18  13:45
 * 描述：历史上的今天适配器
 */

public class TodayAdapter extends BaseAdapter {

    private Context mContext;
    private List<TodayData> mList;
    //布局加载器
    private LayoutInflater inflater;
    private TodayData data;



    //    构造器
    public TodayAdapter(Context mContext, List<TodayData> mList) {

        this.mContext = mContext;
        this.mList = mList;
        //获取系统服务
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder1=null;

        //第一次加载
        if ((convertView==null)){

            viewHolder1=new ViewHolder();
            convertView = inflater.inflate(com.example.wsg.R.layout.layout_today_item,null);
            viewHolder1.tv_title=(TextView) convertView.findViewById(com.example.wsg.R.id.tv_title);
            viewHolder1.tv_des=(TextView) convertView.findViewById(com.example.wsg.R.id.tv_des);
            viewHolder1.tv_lunar=(TextView) convertView.findViewById(com.example.wsg.R.id.tv_lunar);
            //设置缓存
            convertView.setTag(viewHolder1);
        }else{
            viewHolder1 = (ViewHolder) convertView.getTag();
        }
        //设置数据
        data=mList.get(position);
        viewHolder1.tv_title.setText(data.getTitle());
        viewHolder1.tv_des.setText(data.getDes());
        viewHolder1.tv_lunar.setText(data.getLunar());








        return convertView;


    }

    class ViewHolder{
        private TextView tv_title;
        private TextView tv_des;
        private TextView tv_lunar;
    }
}



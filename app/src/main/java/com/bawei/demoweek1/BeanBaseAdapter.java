package com.bawei.demoweek1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Time: 2020/2/23
 * Author: 王冠华
 * Description:
 */
public class BeanBaseAdapter extends BaseAdapter {
    Context context;
    List<ListBean.ResultBean.RxxpBean.CommodityListBean> list;

    public BeanBaseAdapter(Context context, List<ListBean.ResultBean.RxxpBean.CommodityListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if(convertView==null){
          convertView=  View.inflate(context,R.layout.item,null);
          holder.iv=convertView.findViewById(R.id.iv);
          holder.tv=convertView.findViewById(R.id.tv);
          convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        ListBean.ResultBean.RxxpBean.CommodityListBean bean = list.get(position);
        String masterPic = bean.getMasterPic();
        String commodityName = bean.getCommodityName();
        holder.tv.setText(commodityName);
        Picasso.get().load(masterPic).into(holder.iv);
        return convertView;
    }
    private class ViewHolder{
        private TextView tv;
        private ImageView iv;
    }
}

package com.bawei.demoweek1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

public class MainActivity extends BaseActivity implements IHomePageContract.IView{


    private XBanner xb;
    private ListView lv;
    private HomePresenter homePresenter;

    @Override
    protected int getLayoult() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        xb = findViewById(R.id.xb);
        lv = findViewById(R.id.lv);
    }

    @Override
    protected void getData() {
        homePresenter = new HomePresenter(this);
        String url="http://mobile.bwstudent.com/small/commodity/v1/bannerShow";
      homePresenter.getBanner(url);
        String urlist="http://mobile.bwstudent.com/small/commodity/v1/commodityList";
        homePresenter.getList(urlist);
    }

    @Override
    public void getBanner(String url) {
        Gson gson = new Gson();
        XBannerBean xBannerBean = gson.fromJson(url, XBannerBean.class);
        final List<XBannerBean.ResultBean> result = xBannerBean.getResult();
        xb.setBannerData(result);
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                XBannerBean.ResultBean resultBean = result.get(position);
                String imageUrl = resultBean.getImageUrl();
                Picasso.get().load(imageUrl).into((ImageView) view);
            }
        });
    }

    @Override
    public void getList(String url) {
        Gson gson = new Gson();
        ListBean listBean = gson.fromJson(url, ListBean.class);
        ListBean.ResultBean result = listBean.getResult();
        ListBean.ResultBean.RxxpBean rxxp = result.getRxxp();
        List<ListBean.ResultBean.RxxpBean.CommodityListBean> list = rxxp.getCommodityList();
        BeanBaseAdapter bba = new BeanBaseAdapter(this, list);
        lv.setAdapter(bba);
    }
}

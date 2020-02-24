package com.bawei.demoweek1;

/**
 * Time: 2020/2/23
 * Author: 王冠华
 * Description:
 */
public class HomePresenter implements IHomePageContract.IPresenter {
    IHomePageContract.IView mView;
    HomePageModel model;
    HomePresenter(IHomePageContract.IView view){
        mView=view;
        model=new HomePageModel();
    }
    @Override
    public void getBanner(String url) {
        model.getBanner(url, new IHomePageContract.IModelCallBack() {
            @Override
            public void onGetBanner(String str) {
                mView.getBanner(str);
            }
        });
    }

    @Override
    public void getList(final String url) {
        model.getList(url, new IHomePageContract.IModelListCallBack() {
            @Override
            public void onGetList(String str) {
                mView.getList(str);
            }
        });
    }
}

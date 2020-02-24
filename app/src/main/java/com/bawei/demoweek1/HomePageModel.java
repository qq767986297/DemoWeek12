package com.bawei.demoweek1;

/**
 * Time: 2020/2/23
 * Author: 王冠华
 * Description:
 */
public class HomePageModel implements IHomePageContract.IModel {
    @Override
    public void getBanner(String url, final IHomePageContract.IModelCallBack iModelCallBack) {
        NetUtils.getInstance().getJson(url, new NetUtils.ICallBack() {
            @Override
            public void onSuccess(String json) {
                iModelCallBack.onGetBanner(json);
            }

            @Override
            public void onFailed(String msg) {

            }
        });
    }

    @Override
    public void getList(String url, final IHomePageContract.IModelListCallBack iModelListCallBack) {
        NetUtils.getInstance().getJson(url, new NetUtils.ICallBack() {
            @Override
            public void onSuccess(String json) {
                iModelListCallBack.onGetList(json);
            }

            @Override
            public void onFailed(String msg) {

            }
        });
    }
}

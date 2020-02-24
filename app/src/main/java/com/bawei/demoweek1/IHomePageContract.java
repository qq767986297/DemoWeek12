package com.bawei.demoweek1;

/**
 * Time: 2020/2/23
 * Author: 王冠华
 * Description:
 */
public interface IHomePageContract {
    interface IView{
        void getBanner(String url);
        void getList(String url);
    }
    interface IPresenter{
        void getBanner(String url);
        void getList(String url);
    }
    interface IModel{
        void getBanner(String url,IModelCallBack iModelCallBack);
        void getList(String url,IModelListCallBack iModelListCallBack);
    }
    interface IModelCallBack{
        void onGetBanner(String str);
    }
    interface  IModelListCallBack{
        void onGetList(String str);
    }
}

package com.bawei.demoweek1;

import android.os.Handler;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Time: 2020/2/22
 * Author: 王冠华
 * Description:
 */
public class NetUtils {
    private static NetUtils netUtils=new NetUtils();
    private NetUtils(){}
    public static NetUtils getInstance(){
        return netUtils;
    }
    private Handler handler=new Handler();
    //接口
   public interface ICallBack{
       void onSuccess(String json);
       void onFailed(String msg);
   }
   ////获取json
    public void getJson(final String path, final ICallBack iCallBack){
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   URL url = new URL(path);
                   HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                   conn.setRequestMethod("GET");
                   int responseCode = conn.getResponseCode();
                   if(responseCode==200){
                       InputStream inputStream = conn.getInputStream();
                       int len = 0;
                       byte[] bytes = new byte[1024];
                       StringBuilder builder = new StringBuilder();
                       //
                       while((len = inputStream.read(bytes))!=-1){
                           builder.append(new String(bytes,0,len));
                       }
                       final String json = builder.toString();
                       inputStream.close();
                       handler.post(new Runnable() {
                           @Override
                           public void run() {
                               iCallBack.onSuccess(json);
                           }
                       });
                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }).start();
    }
}

package com.itheima.test_mvp.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.itheima.test_mvp.view.MainActivityView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Apple on 2016/11/30.
 * Presenter的实现类
 */

public class MainAtivityPresenterImpl implements MainActivityPresenter {

    MainActivityView mainActivityView;

    public MainAtivityPresenterImpl(MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
    }

    @Override
    public void loadBitmap(final String path) {
            new Thread(new Runnable() {
                private HttpURLConnection conn;

                @Override
                public void run() {
                    try {
                        URL url = new URL(path);
                        HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setConnectTimeout(5000);
                        conn.connect();
                        int responseCode = conn.getResponseCode();
                        if(responseCode == 200){
                            InputStream inputStream = conn.getInputStream();
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            mainActivityView.afterLoadBitmap(bitmap);
                        }else{
                            mainActivityView.afterLoadBitmap(null);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        mainActivityView.afterLoadBitmap(null);
                    }finally {
                        if(conn != null){
                            conn.disconnect();
                        }
                    }
                }
            }).start();
    }
}

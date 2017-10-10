package com.itheima.test_mvp.view;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.itheima.test_mvp.R;
import com.itheima.test_mvp.presenter.MainActivityPresenter;
import com.itheima.test_mvp.presenter.MainAtivityPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainActivityView{

    private ImageView iv;
    private MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        mainActivityPresenter = new MainAtivityPresenterImpl(this);
    }

    public void show(View view){
        //联网加载图片（业务操作）  http://www.itheima.com/uploads/2016/08/logo.png
        String path = "http://www.itheima.com/uploads/2016/08/logo.png";
        mainActivityPresenter.loadBitmap(path);
    }

    //回调回来是在子线程
    @Override
    public void afterLoadBitmap(final Bitmap bitmap) {
        if(bitmap != null){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    iv.setImageBitmap(bitmap);
                }
            });
        }else{
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "加载图片失败", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

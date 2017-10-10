package com.itheima.test_glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
    }

    public void show(View view){
        String url = "http://www.itheima.com/uploads/2016/08/logo.png";
        Glide
                .with(this)
                .load(url)//指定图片路径
//                .centerCrop()//图片中间裁剪
                .placeholder(R.mipmap.ic_launcher)//指定默认图片(没有加载成功)
                .crossFade()//渐变效果
                .into(iv);//把加载的图片给ImageView
    }
}

package com.itheima.test_mvp.view;

import android.graphics.Bitmap;

/**
 * Created by Apple on 2016/11/30.
 * Presentercen实现层处理完业务后回调的方法
 */

public interface MainActivityView {
    void afterLoadBitmap(Bitmap bitmap);
}

package com.itheima.test_eventbus;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;

import org.greenrobot.eventbus.EventBus;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //开始干活了
                SystemClock.sleep(2000);
                //活干完了  -->告诉MainActivity

                //发送事件
                EventBus.getDefault().post(new MessageEvent("请给我卫生纸"));

            }
        }).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

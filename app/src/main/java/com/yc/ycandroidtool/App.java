package com.yc.ycandroidtool;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Printer;

import com.yc.toollib.crash.CrashHandler;
import com.yc.toollib.crash.CrashListener;
import com.yc.toollib.crash.CrashTestDemo;
import com.yc.toollib.crash.CrashToolUtils;
import com.yc.toollib.network.utils.NetworkTool;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initCrash();
        NetworkTool.getInstance().init(this);
        //test();
    }

    private void initCrash() {
        //ThreadHandler.getInstance().init(this);
        CrashHandler.getInstance().init(this, new CrashListener() {
            /**
             * 重启app
             */
            @Override
            public void againStartApp() {
                System.out.println("崩溃重启----------againStartApp------");
                CrashToolUtils.reStartApp1(App.this,2000);
                //CrashToolUtils.reStartApp2(App.this,2000, MainActivity.class);
                //CrashToolUtils.reStartApp3(App.this);
            }

            /**
             * 自定义上传crash，支持开发者上传自己捕获的crash数据
             * @param ex                        ex
             */
            @Override
            public void recordException(Throwable ex) {
                System.out.println("崩溃重启----------recordException------");
                //自定义上传crash，支持开发者上传自己捕获的crash数据
                //StatService.recordException(getApplication(), ex);
            }
        });
    }

    private void test(){
        CrashTestDemo.test();
    }


}

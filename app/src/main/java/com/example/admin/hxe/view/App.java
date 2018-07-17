package com.example.admin.hxe.view;

import android.app.Application;

import com.mob.MobSDK;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * author:anqi    Q 1677564461 2018-7-12.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "436bee984d", true);
        MobSDK.init(this);
    }
}

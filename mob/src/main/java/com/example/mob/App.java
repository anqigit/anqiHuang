package com.example.mob;

import android.app.Application;

import com.mob.MobSDK;

/**
 * author:anqi    Q 1677564461 2018-7-13.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        MobSDK.init(this);
    }
}

package com.winding.scrolling;

import android.app.Application;

import org.litepal.LitePal;

/**
 * Created by 刘少帅 on 2017/10/30
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}

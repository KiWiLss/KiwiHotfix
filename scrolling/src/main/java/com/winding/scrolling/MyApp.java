package com.winding.scrolling;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

/**
 * Created by 刘少帅 on 2017/10/30
 */

public class MyApp extends Application {


    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
        context = getApplicationContext();
    }
}

package com.winding.kiwihotfix.utils;

import com.orhanobut.logger.Logger;

public class LL {
    public static String TAG = "MMM";
    public static boolean isLog=true;

    public static void setIsLog(boolean isShow){
        isLog=isShow;
    }
    public static void setTag(String tag){
        TAG=tag;
    }

    public static void d(Object o){
        if (isLog) {
            Logger.t(TAG).d(o.toString());
        }
    }
    public static void i(Object o){
        if (isLog) {
            Logger.t(TAG).i(o.toString());
        }
    }

    public static void e(Object o){
        if (isLog) {
            Logger.t(TAG).e(o.toString());
        }
    }

}
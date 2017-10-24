package com.winding.kiwihotfix.utils;

import android.app.Activity;
import android.content.SharedPreferences;

import com.winding.kiwihotfix.MyApp;

/**
 * Created by 刘少帅 on 2017/10/24
 */

public class SPUtils {

    static final String TAG = "KIWI";

    public static void save(String name, String value) {
        SharedPreferences mySharedPreferences = MyApp.getContext().getSharedPreferences(
                TAG, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString(name, value);
        editor.commit();
    }
    public static String get(String name) {
        SharedPreferences mySharedPreferences = MyApp.getContext().getSharedPreferences(
                TAG, Activity.MODE_PRIVATE);
        return mySharedPreferences.getString(name, "");
    }


}

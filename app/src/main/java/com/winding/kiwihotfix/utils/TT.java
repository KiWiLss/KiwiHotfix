package com.winding.kiwihotfix.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.winding.kiwihotfix.MyApp;

public class TT {

    private TT()//私有化构造方法
    {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**常用的短时间吐司自定义内容方法
     * @param message
     */
    public static void show(CharSequence message)
    {
        Toast.makeText(MyApp.getContext(), message, Toast.LENGTH_SHORT).show();
    }
    /**常用的短时间吐司自定义内容方法,居中展示
     * @param message
     */
    public static void showCenter(CharSequence message)
    {
        Toast toast = Toast.makeText(MyApp.getContext(), message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
    /**常用的短时间吐司自定义内容方法,自定义位置展示
     * @param message
     */
    public static void showCustom(int gravity,CharSequence message)
    {
        Toast toast = Toast.makeText(MyApp.getContext(), message, Toast.LENGTH_SHORT);
        toast.setGravity(gravity,0,0);
        toast.show();
    }
    /**常用的短时间吐司资源内容方法
     * @param message
     */
    public static void showRes(int message)
    {
        String msg = MyApp.getContext().getResources().getString(message);
        Toast.makeText(MyApp.getContext(), msg, Toast.LENGTH_SHORT).show();
    }
    /**常用的长时间吐司自定义内容的方法
     * @param msg
     */
    public static void showL(String msg){
        Toast.makeText(MyApp.getContext(), msg, Toast.LENGTH_LONG).show();
    }
    public static void showLRes(int message)
    {
        String msg = MyApp.getContext().getResources().getString(message);
        Toast.makeText(MyApp.getContext(), msg, Toast.LENGTH_LONG).show();
    }

}
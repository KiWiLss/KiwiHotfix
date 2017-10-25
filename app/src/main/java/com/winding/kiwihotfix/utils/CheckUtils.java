package com.winding.kiwihotfix.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by 刘少帅 on 2017/10/25
 */

public class CheckUtils {

    /*
    * check the app is installed
    */
    public static boolean isAppInstalled(Context context,String packagename)
    {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packagename, 0);
        }catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        if(packageInfo ==null){
            //System.out.println("没有安装");
            return false;
        }else{
            //System.out.println("已经安装");
            return true;
        }
    }
    /**
     * 判断 APP 是否安装
     * @param context 活动对应的上下文对象
     * @param packageName 需要检查的应用包名
     * @return
     */
    public static boolean isInstalled(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();//获取packagemanager
        List<PackageInfo> pInfo = packageManager.getInstalledPackages(0);//获取所有已安装程序的包信息
        List<String> pName = new ArrayList<>();//用于存储所有已安装程序的包名
        //从pinfo中将包名字逐一取出，压入pName list中
        if (pInfo != null) {
            for (int i = 0; i < pInfo.size(); i++) {
                String pn = pInfo.get(i).packageName;
                pName.add(pn);
            }
        }
        return pName.contains(packageName);//判断pName中是否有目标程序的包名，有TRUE，没有FALSE
    }

    /**
     *打开或者去下载应用
     * @param context 活动对应上下文对象
     * @param packageName 需要打开的应用包名
     */
    public static void openApp(Activity context, String packageName) {
        if (isInstalled(context, packageName)) { //已安装，打开程序，需传入参数包名：packageName
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
            context.startActivityForResult(intent, RESULT_OK);
        } else {//未安装，跳转至market下载该程序
            Uri uri = Uri.parse("market://details?id="+packageName);//id为包名
            Intent it = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(it);
        }
    }



}

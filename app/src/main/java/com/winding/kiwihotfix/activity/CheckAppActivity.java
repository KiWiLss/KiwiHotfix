package com.winding.kiwihotfix.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.winding.kiwihotfix.R;
import com.winding.kiwihotfix.utils.CheckUtils;

/**
 * Created by 刘少帅 on 2017/10/25
 */

public class CheckAppActivity extends AppCompatActivity {
    public static final String TAG = "MMM";
    String wechat1="com.tencent.mm";
    String qq="com.tencent.mobileqq";
    String zfb="com.eg.android.AlipayGphone";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);


    }

    public void checkZfb(View view) {

        Log.e(TAG, "checkZfb: "+CheckUtils.isInstalled(this, wechat1)+
        "||"+CheckUtils.isAppInstalled(this,wechat1));
        Log.e(TAG, "checkZfb: "+CheckUtils.isInstalled(this, zfb)+
                "||"+CheckUtils.isAppInstalled(this,zfb));

    }

    public void wechat(View view) {
        CheckUtils.openApp(this,zfb);
    }
}

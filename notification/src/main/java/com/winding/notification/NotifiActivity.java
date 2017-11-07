package com.winding.notification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by 刘少帅 on 2017/11/7
 */

public class NotifiActivity extends AppCompatActivity {

    public static final String TAG = "MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifi);

        //接收通知传入数据
        String key = getIntent().getStringExtra("key");
        Log.e(TAG, "onCreate: "+key );
    }
}

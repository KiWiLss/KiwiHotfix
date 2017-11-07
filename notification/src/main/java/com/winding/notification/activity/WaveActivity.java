package com.winding.notification.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.winding.notification.R;

import r21nomi.com.glrippleview.GLRippleView;

/**
 * Created by 刘少帅 on 2017/11/7
 */

public class WaveActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave);
        GLRippleView glRippleView = (GLRippleView) findViewById(R.id.glv);
        glRippleView.setRippleOffset(0.005f);//设置波纹波动频率
    }
}

package com.winding.kiwihotfix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.winding.kiwihotfix.R;

/**
 * Created by 刘少帅 on 2017/10/20
 */

public class ZxingActivity extends AppCompatActivity {

    private String TAG="MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);



    }

    public void scanListener(View view) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }


    public void customScanListener(View view) {
        startActivity(new Intent(this,ScanActivity.class));
    }
}

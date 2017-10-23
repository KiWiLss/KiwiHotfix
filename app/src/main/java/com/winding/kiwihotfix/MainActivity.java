package com.winding.kiwihotfix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.winding.kiwihotfix.activity.ZxingActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // queryAndLoadNewPatch不可放在attachBaseContext 中，否则无网络权限，建议放在后面任意时刻，如onCreate中
        //SophixManager.getInstance().queryAndLoadNewPatch();

    }

    public void toFaceListener(View view) {

    }

    public void zxingListener(View view) {
        startActivity(new Intent(this, ZxingActivity.class));
    }
}

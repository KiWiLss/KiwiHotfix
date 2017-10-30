package com.winding.collesing;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.winding.collesing.activity.MemoryActivity;

/**
 * Created by 刘少帅 on 2017/10/30
 */

public class TransitionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

    }
    public void goTo(Class<?> clz){
        startActivity(new Intent(this,clz));
    }

    public void simpleMemory(View view) {
        goTo(MemoryActivity.class);
    }
}

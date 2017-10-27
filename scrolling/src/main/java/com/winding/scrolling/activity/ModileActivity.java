package com.winding.scrolling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.winding.scrolling.R;

/**
 * Created by 刘少帅 on 2017/10/26
 */

public class ModileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modille);

    }

    public void bottomListener(View view) {
        startActivity(new Intent(ModileActivity.this, BottomActivity.class));
    }


    public void complexListener(View view) {
        startActivity(new Intent(ModileActivity.this, ComplexCoordinatorActivity.class));
    }

    public void appbarListener(View view) {
        startActivity(new Intent(ModileActivity.this, AppBarActivity.class));
    }

    public void superListener(View view) {
        startActivity(new Intent(ModileActivity.this, SuperTextActivity.class));
    }
}

package com.winding.kiwihotfix.activity.coordinator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.winding.kiwihotfix.R;
import com.winding.kiwihotfix.widget.SearchBarView;

/**
 * Created by 刘少帅 on 2017/10/27
 */

public class HWSearchActivity extends AppCompatActivity {

    private SearchBarView mSbv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hwsearch);
        mSbv = (SearchBarView) findViewById(R.id.sbv_hw_search);


    }

    public void closeListener(View view) {
        mSbv.startClose();
    }

    public void openListener(View view) {
        mSbv.startOpen();
    }
}

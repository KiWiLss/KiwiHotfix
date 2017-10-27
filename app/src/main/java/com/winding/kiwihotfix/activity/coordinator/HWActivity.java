package com.winding.kiwihotfix.activity.coordinator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.winding.kiwihotfix.R;
import com.winding.kiwihotfix.widget.SearchBarView;

/**
 * Created by 刘少帅 on 2017/10/27
 */

public class HWActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private SearchBarView searchbarview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw);

        initView();

    }

    private void initView() {
//        ActionBar supportActionBar = getSupportActionBar();
//        if (supportActionBar != null) {
//            supportActionBar.hide();
//        }
        toolbar = (Toolbar) findViewById(R.id.tb_hw_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        searchbarview = (SearchBarView) findViewById(R.id.sbv_hw_searchView);
        searchbarview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // enter search activity
                Toast.makeText(HWActivity.this, "enter search activity", Toast.LENGTH_SHORT).show();
            }
        });
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.abl_hw_appbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float alpha = Math.abs((float) verticalOffset / appBarLayout.getTotalScrollRange());
                toolbar.setAlpha(alpha);
                if (alpha >= 1) {
                    searchbarview.startOpen();
                } else {
                    searchbarview.startClose();
                }
            }
        });

    }
}

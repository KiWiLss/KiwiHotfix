package com.winding.kiwihotfix.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.winding.kiwihotfix.R;

/**
 * Created by 刘少帅 on 2017/10/23
 */

public class CoordinatorLayoutActivity extends AppCompatActivity {

    private LinearLayout mLin1;
    private LinearLayout mLin2;

    private String TAG="MMM";
    private AppBarLayout mAppBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);


        mLin1 = (LinearLayout) findViewById(R.id.lin1);
        mLin2 = (LinearLayout) findViewById(R.id.lin2);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int height = appBarLayout.getTotalScrollRange();
                int offSetAbs = Math.abs(verticalOffset);
                float p = (float) offSetAbs / (float) height;
                Log.e(TAG, "onOffsetChanged: "+height+"vertical"+verticalOffset
                +"||"+offSetAbs+"|||"+p);

                mLin1.setAlpha(1 - p);
                if ((1 - p) > 0.5) {
                    mLin2.setAlpha(1 - p);
                    mAppBarLayout.setAlpha(1 - p);
                } else {
                    mLin2.setAlpha(p);
                    mAppBarLayout.setAlpha(p);
                }
            }
        });
    }
}

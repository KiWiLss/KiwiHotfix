package com.winding.kiwihotfix.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ScrollView;

import com.winding.kiwihotfix.R;
import com.winding.kiwihotfix.widget.TranslucentScrollView;



/**
 * Created by 刘少帅 on 2017/10/23
 */

public class CLActivity2 extends AppCompatActivity {
    private TranslucentScrollView scrollView;
    private Toolbar toolbar;
    private float headerHeight;
    private float minHeaderHeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cl_bottom);

       initView();
    }

    private void initView() {
        scrollView = (TranslucentScrollView) findViewById(R.id.scrollview);
        scrollView.setOnScrollChangedListener(new TranslucentScrollView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
                //Y轴偏移量
                float scrollY = who.getScrollY();

                //变化率
                float headerBarOffsetY = headerHeight - minHeaderHeight;//Toolbar与header高度的差值
                 headerBarOffsetY =getResources().getDimension(R.dimen.title_margin_header);//Toolbar与header高度的差值
                float offset = 1 - Math.max((headerBarOffsetY - scrollY) / headerBarOffsetY, 0f);

                Log.e("MMM", "onScrollChanged: "+offset );
                //Toolbar背景色透明度
                toolbar.setBackgroundColor(Color.argb((int) (offset * 255), 18, 176, 242));

                //toolbar.getBackground().mutate().setAlpha((int) (offset*255));

//        //header背景图Y轴偏移
//        imgHead.setTranslationY(scrollY / 2);


            }
        });
        toolbar = (Toolbar) findViewById(R.id.tb_tb);
        toolbar.setBackgroundColor(Color.argb(0, 18, 176, 242));
        //toolbar.getBackground().setAlpha(0);
        initMeasure();
    }
    private void initMeasure() {
        headerHeight = getResources().getDimension(R.dimen.dimen_300);
        minHeaderHeight = getResources().getDimension(R.dimen.abc_action_bar_default_height_material);
    }
}

package com.winding.scrolling.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.winding.scrolling.R;

/**
 * Created by 刘少帅 on 2017/10/27
 */

public class SuperTextActivity extends AppCompatActivity {

    private SuperTextView mStvOne;
    private SuperTextView mStvTwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super);

        initView();


        mStvOne.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
            @Override
            public void onClickListener(SuperTextView superTextView) {//整个的点击事件
                Toast.makeText(SuperTextActivity.this, "第一行", Toast.LENGTH_SHORT).show();
            }
        }).setLeftImageViewClickListener(new SuperTextView.OnLeftImageViewClickListener() {
            @Override
            public void onClickListener(ImageView imageView) {//左侧图片点击
                Toast.makeText(SuperTextActivity.this, "图片", Toast.LENGTH_SHORT).show();
            }
        }).setRightTvClickListener(new SuperTextView.OnRightTvClickListener() {
            @Override
            public void onClickListener() {//右侧文字点击
                Toast.makeText(SuperTextActivity.this, "右侧文字", Toast.LENGTH_SHORT).show();
            }
        });

        //获取各个控件
//        mStvOne.getRightTextView().setText("右边随便改");
//        mStvOne.getLeftIconIV().setImageResource(R.mipmap.bg);


    }

    private void initView() {
        mStvOne = (SuperTextView) findViewById(R.id.stv_super_one);
        mStvTwo = (SuperTextView) findViewById(R.id.stv_super_two);

    }
}

package com.winding.password.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.daimajia.numberprogressbar.OnProgressBarListener;
import com.winding.password.R;
import com.winding.password.widget.RoundProgressBar;

/**
 * Created by 刘少帅 on 2017/11/6
 */

public class BarActivity extends AppCompatActivity {
    NumberProgressBar npbOne;
    private CountDownTimer mCrt;
    private RoundProgressBar mRpb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

         npbOne = (NumberProgressBar) findViewById(R.id.npb_bar_one);
        NumberProgressBar npbTwo = (NumberProgressBar) findViewById(R.id.npb_bar_two);
        mRpb = (RoundProgressBar) findViewById(R.id.rpb_bar_bar);

        npbOne.setOnProgressBarListener(new OnProgressBarListener() {
            @Override
            public void onProgressChange(int current, int max) {
                Toast.makeText(BarActivity.this, "current="+current+"max="+max, Toast.LENGTH_SHORT).show();
            }
        });
        npbTwo.setPrefix("csdn");
        npbOne.setProgress(0);

        //定时任务
        mCrt = new CountDownTimer(50*5, 50) {//执行4次
            @Override
            public void onTick(long l) {
                mPb+=10;
                npbOne.setProgress(mPb);
            }

            @Override
            public void onFinish() {

            }
        };

        mRpb.setMax(100);
        mRpb.setTextSize(40f);
    }
    int mPb;
    public void addListener(View view) {
        mCrt.start();
        mRpb.setProgress(80);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCrt.cancel();
    }
}

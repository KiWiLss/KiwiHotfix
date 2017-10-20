package com.winding.kiwihotfix.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.vise.face.ICameraCheckListener;
import com.vise.face.IFaceDetector;
import com.vise.face.NormalFaceDetector;
import com.vise.log.ViseLog;
import com.winding.kiwihotfix.R;

/**
 * Created by 刘少帅 on 2017/10/20
 */

public class FaceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);

        IFaceDetector mFaceDetector = new NormalFaceDetector();

        ICameraCheckListener mCameraCheckListener = new ICameraCheckListener() {
            @Override
            public void checkPermission(boolean isAllow) {
                //权限是否允许
                ViseLog.i("MMM" + isAllow);
            }

            @Override
            public void checkPixels(long pixels, boolean isSupport) {
                //手机像素是否满足要求
                ViseLog.i("MMM" + pixels);
            }
        };

    }
}

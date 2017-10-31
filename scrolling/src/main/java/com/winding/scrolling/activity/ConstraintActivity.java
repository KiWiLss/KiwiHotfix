package com.winding.scrolling.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.winding.scrolling.R;
import com.winding.scrolling.utils.FingerprintUtil;

/**
 * Created by 刘少帅 on 2017/10/31
 */

public class ConstraintActivity extends AppCompatActivity {

    public static final String TAG = "MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);


    }

    public void fingerprintListener(View view) {
        FingerprintUtil.callFingerPrint(new FingerprintUtil.OnCallBackListenr() {
            @Override
            public void onSupportFailed() {
                Log.e(TAG, "onSupportFailed: " );
            }

            @Override
            public void onInsecurity() {
                Log.e(TAG, "onInsecurity: ");
            }

            @Override
            public void onEnrollFailed() {
                Log.e(TAG, "onEnrollFailed: ");
            }

            @Override
            public void onAuthenticationStart() {

            }

            @Override
            public void onAuthenticationError(int errMsgId, CharSequence errString) {

            }

            @Override
            public void onAuthenticationFailed() {

            }

            @Override
            public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {

            }

            @Override
            public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {

            }
        });
    }
}

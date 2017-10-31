package com.winding.scrolling.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.wei.android.lib.fingerprintidentify.FingerprintIdentify;
import com.wei.android.lib.fingerprintidentify.base.BaseFingerprint;
import com.winding.scrolling.R;

/**
 * Created by 刘少帅 on 2017/10/31
 */

public class FingerprintActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
    private FingerprintIdentify fingerprintIdentify;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint);

        fingerprintIdentify = new FingerprintIdentify(this, new BaseFingerprint.FingerprintIdentifyExceptionListener() {
            @Override
            public void onCatchException(Throwable exception) {
                Log.e(TAG, "onCatchException: "+exception.getLocalizedMessage() );
            }
        });

    }

    public void fingerprintClick(View view) {

        fingerprintIdentify.startIdentify(3, new BaseFingerprint.FingerprintIdentifyListener() {
            @Override
            public void onSucceed() {
                Log.e(TAG, "onSucceed: ");
            }

            @Override
            public void onNotMatch(int availableTimes) {
                Log.e(TAG, "onNotMatch: "+availableTimes );
            }

            @Override
            public void onFailed(boolean isDeviceLocked) {
                Log.e(TAG, "onFailed: ");
            }

            @Override
            public void onStartFailedByDeviceLocked() {
                Log.e(TAG, "onStartFailedByDeviceLocked: " );
            }
        });

    }
}

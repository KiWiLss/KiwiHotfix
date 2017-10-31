package com.winding.scrolling.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v7.app.AlertDialog;
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
    private AlertDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);


    }

    public void fingerprintListener(View view) {
        FingerprintUtil.callFingerPrint(new FingerprintUtil.OnCallBackListenr() {
            @Override
            public void onSupportFailed() {
                log("不支持");
                Log.e(TAG, "onSupportFailed: " );
            }

            @Override
            public void onInsecurity() {
                log("安全保护中");
                Log.e(TAG, "onInsecurity: ");
            }

            @Override
            public void onEnrollFailed() {
                log("到设置中设置");
                Log.e(TAG, "onEnrollFailed: ");
            }

            @Override
            public void onAuthenticationStart() {
                AlertDialog.Builder builder = new AlertDialog.Builder(ConstraintActivity.this);
//                View view = LayoutInflater.from(ConstraintActivity.this).inflate(R.layout.layout_fingerprint,null);
//                initView(view);
//                builder.setView(view);
                builder.setCancelable(false);
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.removeMessages(0);
                        FingerprintUtil.cancel();
                    }
                });
                dialog = builder.create();
                dialog.show();
            }

            @Override
            public void onAuthenticationError(int errMsgId, CharSequence errString) {
                log(""+errMsgId+"||"+errString);
                if (dialog != null  &&dialog.isShowing()){
                    dialog.dismiss();
                    handler.removeMessages(0);
                }
            }

            @Override
            public void onAuthenticationFailed() {
                log("解锁失败");
            }

            @Override
            public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
            log(helpString.toString());
            }

            @Override
            public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {
                log("success");
                if (dialog != null  &&dialog.isShowing()){
                    dialog.dismiss();
                    handler.removeMessages(0);
                }
            }
        });
    }

    public void log(String msg){
        Log.e(TAG, "log: "+msg );
    }
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
//                int i = postion % 5;
//                if (i == 0){
//                    tv[4].setBackground(null);
//                    tv[i].setBackgroundColor(getResources().getColor(R.color.colorAccent));
//                }
//                else{
//                    tv[i].setBackgroundColor(getResources().getColor(R.color.colorAccent));
//                    tv[i-1].setBackground(null);
//                }
//                postion++;
//                handler.sendEmptyMessageDelayed(0,100);
            }
        }
    };
}

package com.winding.kiwihotfix.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.winding.kiwihotfix.R;
import com.winding.kiwihotfix.utils.CheckUtils;

/**
 * Created by 刘少帅 on 2017/10/25
 */

public class CheckAppActivity extends AppCompatActivity {
    public static final String TAG = "MMM";
    String wechat1="com.tencent.mm";
    String qq="com.tencent.mobileqq";
    String zfb="com.eg.android.AlipayGphone";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);


        final TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.til_pwd);

        EditText editText = textInputLayout.getEditText();
        textInputLayout.setHint("Password");

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.length() > 4) {
                    textInputLayout.setError("Password error");
                    textInputLayout.setErrorEnabled(true);
                } else {
                    textInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });



    }

    public void checkZfb(View view) {

        Log.e(TAG, "checkZfb: "+CheckUtils.isInstalled(this, wechat1)+
        "||"+CheckUtils.isAppInstalled(this,wechat1));
        Log.e(TAG, "checkZfb: "+CheckUtils.isInstalled(this, zfb)+
                "||"+CheckUtils.isAppInstalled(this,zfb));

    }

    public void wechat(View view) {
        CheckUtils.openApp(this,zfb);
    }
}

package com.winding.password.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.jungly.gridpasswordview.GridPasswordView;
import com.winding.password.R;

/**
 * Created by 刘少帅 on 2017/11/6
 */

public class PswActivity extends AppCompatActivity {
    GridPasswordView gpvNum;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd);
         gpvNum = (GridPasswordView) findViewById(R.id.gpv_pwd_number);
        GridPasswordView gpvTpwd = (GridPasswordView) findViewById(R.id.gpv_pwd_textpassword);

    gpvTpwd.setPassword("123456");
        gpvNum.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener() {
            @Override
            public void onTextChanged(String psw) {
                Toast.makeText(PswActivity.this, psw, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInputFinish(String psw) {
                Toast.makeText(PswActivity.this, "Finish"+psw, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void clearPwd(View view) {
        gpvNum.clearPassword();
    }
}

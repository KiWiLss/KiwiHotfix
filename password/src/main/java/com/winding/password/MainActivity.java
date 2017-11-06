package com.winding.password;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.winding.password.activity.BarActivity;
import com.winding.password.activity.PswActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        TextView tv = (TextView) findViewById(R.id.tv_main_test);
        tv.setText("hello kitty");
    }

    public void gotoPwd(View view) {
        goTo(PswActivity.class);
    }
    public void goTo(Class clz){
        startActivity(new Intent(this,clz));
    }

    public void numberBar(View view) {
        goTo(BarActivity.class);
    }
}

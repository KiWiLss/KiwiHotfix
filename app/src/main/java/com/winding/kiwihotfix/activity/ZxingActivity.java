package com.winding.kiwihotfix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.maning.library.zxing.CaptureActivity;
import com.maning.library.zxing.ZXingConstants;
import com.winding.kiwihotfix.R;
import com.winding.kiwihotfix.activity.coordinator.HWActivity;
import com.winding.kiwihotfix.activity.coordinator.HWSearchActivity;
import com.winding.kiwihotfix.activity.coordinator.SwipeDeleteActivity;

/**
 * Created by 刘少帅 on 2017/10/20
 */

public class ZxingActivity extends AppCompatActivity {

    private String TAG="MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zxing);




    }

    //进入使用coordinatorlayout
    public void scanListener(View view) {
//        Intent intent = new Intent(this, CaptureActivity.class);
//        //是不是显示历史记录按钮
//        //intent.putExtra(ZXingConstants.ScanIsShowHistory,true);
//        startActivityForResult(intent, ZXingConstants.ScanRequltCode);

        startActivity(new Intent(this,CoordinatorLayoutActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (resultCode == ZXingConstants.ScanRequltCode) {
            /**
             * 拿到解析完成的字符串
             */
            Log.e(TAG, "onActivityReenter: " );
            String result = data.getStringExtra(ZXingConstants.ScanResult);
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            Log.e(TAG, "onActivityReenter: "+result );
        }

    }


    public void customScanListener(View view) {
        //1.跳转：
        Intent intent = new Intent(this, CaptureActivity.class);
        //是不是显示历史记录按钮
        //intent.putExtra(ZXingConstants.ScanIsShowHistory,true);
        startActivityForResult(intent, ZXingConstants.ScanRequltCode);
    }


    public void coordinatorListener(View view) {
        startActivity(new Intent(this,CLActivity.class));
    }

    public void coordinatorListener2(View view) {
        startActivity(new Intent(this,CLActivity2.class));
    }

    public void snakbarListener(View view) {
        startActivity(new Intent(this,SnackbarActivity.class));
    }

    public void searchViewListener(View view) {
        startActivity(new Intent(this,SearchViewActivity.class));
    }

    public void searchViewListener2(View view) {
        startActivity(new Intent(this,SearchViewActivity2.class));
    }



    public void tablayoutListener(View view) {
        startActivity(new Intent(this,TablayoutActivity.class));
    }

    public void swipeListener(View view) {
        startActivity(new Intent(this,SwipeDeleteActivity.class));
    }

    public void clickSearchListener(View view) {
        startActivity(new Intent(this,HWSearchActivity.class));
    }

    public void coordinatorSearchListener(View view) {
        startActivity(new Intent(this,HWActivity.class));
    }


    public void textviewListener(View view) {
        startActivity(new Intent(this,TextViewActvitiy.class));
    }
}

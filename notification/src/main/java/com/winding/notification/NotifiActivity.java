package com.winding.notification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.winding.notification.widget.PaletteImageView;

import r21nomi.com.glrippleview.GLRippleView;

/**
 * Created by 刘少帅 on 2017/11/7
 */

public class NotifiActivity extends AppCompatActivity {

    public static final String TAG = "MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifi);

        //接收通知传入数据
        String key = getIntent().getStringExtra("key");
        Log.e(TAG, "onCreate: "+key );


        PaletteImageView mPaletteImageView = (PaletteImageView) findViewById(R.id.palette);

        /*mPaletteImageView.setOnParseColorListener(new PaletteImageView.OnParseColorListener() {
            @Override//解析图片的颜色完毕
            public void onComplete(PaletteImageView paletteImageView) {
                int[] vibrant = paletteImageView.getVibrantColor();
                int[] vibrantDark = paletteImageView.getDarkVibrantColor();
                int[] vibrantLight = paletteImageView.getLightVibrantColor();
                int[] muted = paletteImageView.getMutedColor();
                int[] mutedDark = paletteImageView.getDarkMutedColor();
                int[] mutedLight = paletteImageView.getLightMutedColor();
            }

            @Override//解析图片的颜色失败
            public void onFail() {

            }
        });*/


//        glRippleView.run {
//            addBackgroundImages(listOf(
//                    BitmapFactory.decodeResource(resources, R.drawable.bg2),
//                    BitmapFactory.decodeResource(resources, R.drawable.bg3)
//            ));
//            setRippleOffset(0.01f);
//            setFadeInterval(5000);
//            startCrossFadeAnimation();
//        }

    }
}

package com.winding.notification.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.winding.notification.R;
import com.winding.notification.adapter.VpAdapter;
import com.winding.notification.transform.GallyPageTransformer;

import java.util.ArrayList;

/**
 * Created by 刘少帅 on 2017/11/7
 */

public class VpActivity extends AppCompatActivity {

    private ViewPager mVp;
    private int [] mImg=new int[]{R.mipmap.android0,R.mipmap.sunset,R.mipmap.sea,R.mipmap.lotus,R.mipmap.red};
    private ArrayList<ImageView> mImgList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp);
        mVp = (ViewPager) findViewById(R.id.vp_vp);

        mImgList = new ArrayList<>();
        for (int i = 0; i < mImg.length; i++) {

            ImageView imageView = new ImageView(this);
            imageView.setImageResource(mImg[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImgList.add(imageView);
        }
        int deviceWidth = getResources().getDisplayMetrics().widthPixels;
        Log.e("MMM", "onCreate: "+deviceWidth );
        VpAdapter adapter = new VpAdapter(mImgList);
       // mVp.setPageTransformer(true,new StereoPagerTransformer(deviceWidth));
        mVp.setPageTransformer(true,new GallyPageTransformer());
        mVp.setAdapter(adapter);

    }
}

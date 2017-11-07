package com.winding.notification.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by 刘少帅 on 2017/11/7
 */

public class VpAdapter extends PagerAdapter {
    private List<ImageView>mImg;


    public VpAdapter(List<ImageView> mImg) {
        this.mImg = mImg;
    }

    @Override
    public int getCount() {
        return mImg.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = mImg.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mImg.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}

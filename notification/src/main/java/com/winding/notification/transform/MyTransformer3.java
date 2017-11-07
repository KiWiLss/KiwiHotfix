package com.winding.notification.transform;

import android.support.v4.view.ViewPager;
import android.view.View;

public class MyTransformer3 implements ViewPager.PageTransformer {

    int screenWidth;

    public MyTransformer3(int width) {
        screenWidth = width;
    }

    @Override
    public void transformPage(View view, float position) {
        float absPosition = Math.abs(position);
        if (absPosition == 0)
            view.setRotationY(0);
        if (absPosition < 0.2) {
            view.setScaleX(0.5f + (1 - absPosition) * 0.5f);
            view.setScaleY(0.5f + (1 - absPosition) * 0.5f);
        } else if (absPosition < 0.5) {
            if (position < 0)
                view.setRotationY(-90 * (position + 0.2f));
            else
                view.setRotationY(-90 * (position - 0.2f));
            view.setScaleX(0.9f - (absPosition - 0.2f) * 0.8f);
            view.setScaleY(0.9f - (absPosition - 0.2f) * 0.8f);

        } else if (absPosition < 1) {
            if (position < 0)
                view.setRotationY(27);
            else
                view.setRotationY(-27);
            view.setScaleX(0.9f - (absPosition - 0.2f) * 0.8f);
            view.setScaleY(0.9f - (absPosition - 0.2f) * 0.8f);
        }
        if (absPosition < 1) {
            view.setAlpha(0.6f + 0.4f * (1 - absPosition));
            view.setTranslationX(-screenWidth / 3 * absPosition);
        }


    }

}
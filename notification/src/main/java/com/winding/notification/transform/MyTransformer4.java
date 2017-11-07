package com.winding.notification.transform;

import android.support.v4.view.ViewPager;
import android.view.View;

public class MyTransformer4 implements ViewPager.PageTransformer {

ViewPager viewPager;

@Override
public void transformPage(View view, float position) {
if (position > -1 && position < 1) {

view.setTranslationX(-position * view.getWidth());
float scaleFactor;
float aPostion = Math.abs(position);
if (aPostion < 0.5) {
scaleFactor = 1 - aPostion;
} else {
scaleFactor = aPostion;
}
view.setScaleX(0.75f + 0.25f * scaleFactor);
view.setScaleY(0.7f + 0.3f * scaleFactor);

view.setRotationY(180 * position);

if (Math.abs(position) < 0.5) {
view.setVisibility(View.VISIBLE);
} else {
view.setVisibility(View.INVISIBLE);
}
}

}
}
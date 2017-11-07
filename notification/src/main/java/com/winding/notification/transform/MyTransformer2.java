package com.winding.notification.transform;

import android.support.v4.view.ViewPager;
import android.view.View;

public class MyTransformer2 implements ViewPager.PageTransformer{

private static float MIN_SCALE=0.8f;
@Override
public void transformPage(View view, float postion) {
if(postion>0&&postion<1){
float scaleFactor=MIN_SCALE+(1-MIN_SCALE)*(1-postion);
view.setScaleX(scaleFactor);
view.setScaleY(scaleFactor);
view.setTranslationX(view.getWidth()*-postion);
view.setAlpha(1-postion);
}
}

}
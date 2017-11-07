package com.winding.notification.transform;

import android.support.v4.view.ViewPager;
import android.view.View;

public class MyTransformer1 implements ViewPager.PageTransformer{

private static float MIN_SCALE=0.85f;
@Override
public void transformPage(View view, float position) {
if(position>-1&&position<1){
float scaleFactor=Math.max(MIN_SCALE, 1-Math.abs(position));
float margin=view.getWidth()*(1-scaleFactor)/3;
if(position<0)
view.setTranslationX(margin);
else 
view.setTranslationX(-margin);
view.setScaleX(scaleFactor);
view.setScaleY(scaleFactor);
view.setAlpha(scaleFactor);
}
}

}
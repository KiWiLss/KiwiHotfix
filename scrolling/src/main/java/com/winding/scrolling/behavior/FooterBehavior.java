package com.winding.scrolling.behavior;

import android.animation.Animator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

//Behavior这个类就是用来协调我们的行为的。
public class FooterBehavior extends CoordinatorLayout.Behavior<View> {
    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();
    private float viewY;//控件距离coordinatorLayout底部距离
    private boolean isAnimate;//动画是否在进行
    public FooterBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
//coordinatorLayout中有滚动发生的时候会回调该方法。我们可以在该方法中获取到滚动的方向，可以获取到注册该行为的view，也就是child。大家一定要Ctrl+q看看英文的文档介绍。
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        //在第一次进入的时候获取到控件距离父布局（coordinatorLayout）底部距离。根据这个控件到底部的距离，使用插值器，来做显示隐藏的动画。
        if(child.getVisibility() == View.VISIBLE && viewY==0){
            viewY=coordinatorLayout.getHeight()-child.getY();
        } 
       return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;//判断是否竖直滚动
    }
   @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {

        //手指向上移动,屏幕内容上移dy>0,手指下移dy<0
        if (dy >=0 && !isAnimate && child.getVisibility()==View.VISIBLE) {
            //hide和show的代码我就不写了，无非就是调用动画来显示隐藏控件（虽然我感觉动画的代码才是最难的··）
            hide(child);
        } else if (dy <0 && !isAnimate && child.getVisibility()==View.GONE) {
            show(child);
        }
       Log.e("MMM", "onNestedPreScroll: "+dy +"|||"+isAnimate+"|||"+child.getVisibility());
    }

    private void hide(final View view) {
        ViewPropertyAnimator animator = view.animate().translationY(view.getHeight()).setInterpolator(INTERPOLATOR).setDuration(200);
        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                show(view);
            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();
    }


    private void show(final View view) {
        ViewPropertyAnimator animator = view.animate().translationY(0).setInterpolator(INTERPOLATOR).setDuration(200);
        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                hide(view);
            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.start();

    }
}


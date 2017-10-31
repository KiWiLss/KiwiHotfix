package com.winding.scrolling.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.TextView;

import com.winding.scrolling.R;

import java.util.ArrayList;
import java.util.List;

public class Week extends ViewGroup {

    public interface NodeInterFace {
        String getDate();
        boolean isSelected();
    }

    public interface OnWeekClickListener {
        void  onClick(String text);
    }

    OnWeekClickListener mListener;//用户点击时的回调接口
    private Scroller mScroller;//用于完成滚动操作的实例

    private int mTouchSlop; //判定为拖动的最小移动像素数


    List<NodeInterFace> mDatas=new ArrayList<>();//显示的数据
    int selectIndex=2;//默认选中第三个
    int itemWidth;
    private int view_margin_left_or_right;//view两边的的margin
    private int leftBorder;//左边界
    private int rightBorder;//右边界

    public Week(Context context) {
        this(context,null);
    }

    public Week(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Week(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 第一步，创建Scroller的实例
        mScroller = new Scroller(context);
        ViewConfiguration configuration = ViewConfiguration.get(context);
        // 获取TouchSlop值
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        int defaultHeight=0, childHeight=0;
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if(heightSpecMode == MeasureSpec.AT_MOST){//高设置为wrap_content
            for (int i=0;i<getChildCount();i++){ //由于只有一行  所以随便取一个的高度即可
                childHeight= (int) (getChildAt(0).getMeasuredHeight()*1.5);
            }
            setMeasuredDimension(widthSpecSize,childHeight); //无论用户将宽设置为何种模式  都与match_parent相同
        } else{//宽高都设置为match_parenth或具体的dp值
            setMeasuredDimension(widthSpecSize, heightSpecSize);
        }
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        itemWidth=getWidth()/5; //每行显示五个
        int right,bottom,left;
        bottom=getHeight()-(getHeight()-getChildAt(0).getMeasuredHeight())/2;
        //itemWidth的宽度一定是大于 实际的每个子view的宽度的
        view_margin_left_or_right=(itemWidth-getChildAt(0).getMeasuredWidth())/2;//相当于左右边距

        int left_X=getWidth()-itemWidth*3;//中间一个的左边界坐标
        for (int j=selectIndex-1;j >= 0;j--){ //中间那个view左边的那些view
            View view=getChildAt(j);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            right=left_X-view_margin_left_or_right-itemWidth*(selectIndex-1-j);
            view.layout(right-getChildAt(j).getMeasuredWidth(),bottom-getChildAt(j).getMeasuredHeight(),right,bottom);
        }

        int right_X=itemWidth*3;;//中间一个的右边界坐标
        for (int m=selectIndex+1;m<getChildCount();m++){ //中间那个view右边的那些view
            View view=getChildAt(m);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            left=right_X+view_margin_left_or_right+itemWidth*(m-(selectIndex+1));
            view.layout(left,bottom-getChildAt(m).getMeasuredHeight(),left+getChildAt(m).getMeasuredWidth(),bottom);
        }

        //中间一个view
        left=itemWidth*2+view_margin_left_or_right;
        getChildAt(selectIndex).layout(left,bottom-getChildAt(selectIndex).getMeasuredHeight(),left+getChildAt(selectIndex).getMeasuredWidth(),bottom);
        getChildAt(selectIndex).setScaleX(1.2f);
        getChildAt(selectIndex).setScaleY(1.2f);

        // 初始化左右边界值
        leftBorder = getChildAt(0).getLeft();
        rightBorder = getChildAt(getChildCount() - 1).getRight();
    }

    /**
     * 手机按下时的屏幕坐标
     */
    private float mXDown;

    /**
     * 手机当时所处的屏幕坐标
     */
    private float mXMove;

    /**
     * 上次触发ACTION_MOVE事件时的屏幕坐标
     */
    private float mXLastMove;
//    float lastDown;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
//                lastDown=mXDown;
                Log.e("ACTION_DOWN","mXDown:"+mXMove);
                Log.e("ACTION_DOWN","mXLastMove:"+mXLastMove);

                break;
            case MotionEvent.ACTION_MOVE:
                mXMove = event.getRawX();
                int scrolledX = (int) (mXLastMove - mXMove);//计算本次view的移动距离

                if (getScrollX() + scrolledX < leftBorder) { //以前滑动的距离加上本次滑动的距离比左边第一个view的lfet小 既为滑出左边界了 滑出左边界是向右滑动所以getScrollX()为负值
                    scrollTo(leftBorder-view_margin_left_or_right, 0);
                    return true;
                } else if (getScrollX() + scrolledX > rightBorder-getWidth()) {//以前滑动的距离加上本次滑动的距离比右边最后一个view的right减去viewGroup的宽度大 既为滑出右边界了 滑出右边界是向左滑动所以getScrollX()为正值
                    scrollTo(rightBorder+view_margin_left_or_right - getWidth(), 0);
                    return true;
                }
                scrollBy(scrolledX, 0);
                mXLastMove = mXMove;

                break;
            case MotionEvent.ACTION_UP:
//                float scrollX = (float) (lastDown - event.getRawX());
//                float dx= scrollX/(float)(itemWidth+view_margin_left_or_right);
//                int mLastSelectIndex=selectIndex;
//                int tmpIndex=0;
//
////                Log.e("ACTION_UP","lastDown:"+lastDown);
////                Log.e("ACTION_UP","event.getRawX():"+event.getRawX());
//                Log.e("ACTION_UP","scrollX:"+scrollX);
//                Log.e("ACTION_UP","dx:"+dx);
//                Log.e("ACTION_UP","mLastSelectIndex:"+mLastSelectIndex);
//
//                if (dx>0) {
//                    float xs = dx - (int) (dx);
//                    Log.e("ACTION_UP","xs:"+xs);
//                    tmpIndex = (int) dx + (xs > 0.5 ? 1 : 0)+mLastSelectIndex;
//                }else {
//                    float xs = dx - (int) (dx);
//                    Log.e("ACTION_UP","xs:"+xs);
//                    tmpIndex = (int) dx + (xs > -0.5 ? 0 : -1)+mLastSelectIndex;
//                }
//                Log.e("ACTION_UP","tmpIndex:"+tmpIndex);
//
//                if (tmpIndex>1 && tmpIndex< mDatas.size()-2){
//                    selectIndex=tmpIndex;
//                }else if (tmpIndex<=1){
//                    selectIndex=2;
//                }else {
//                    selectIndex=mDatas.size()-3;
//                }
//
//                Log.e("ACTION_UP","selectIndex:"+selectIndex);

//                invalidate();
                break;
        }

        return true;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:
                mXDown = ev.getRawX();
                mXLastMove = mXDown;

                break;
            case MotionEvent.ACTION_MOVE:
                mXMove = ev.getRawX();
                float dx=Math.abs(mXMove-mXDown);

                if (dx>mTouchSlop){
                    return true;
                }
                break;

        }
        return super.onInterceptTouchEvent(ev);
    }


    public void setData(List<NodeInterFace>  mList,  OnWeekClickListener listener){
        mListener=listener;
        mDatas=mList;
        if (mDatas!=null){
            for (int i=0;i<mDatas.size();i++){
                TextView tv=(TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_view,this,false);
                tv.setText(mDatas.get(i).getDate());
                tv.setTag(i);
                tv.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos=(int)view.getTag();
                        startAnim(pos, selectIndex);
                        selectIndex=pos;
                        mListener.onClick( mDatas.get(pos).getDate());
                    }
                });
                if (i>1 && mDatas.get(i).isSelected() && i< mDatas.size()-2 ){
                    selectIndex=i;
                }
                addView(tv);
            }
        }
    }

    private int getDeletaX(int current, int last){  //偏移的x量
         int dx=0;
         View view= getChildAt(current);
         dx= (view.getLeft()-getScrollX()+view.getMeasuredWidth()/2)-getWidth()/2;
        return dx;
    }

    private void startAnim(int current, int last){

        if (current==last) return;

        ObjectAnimator anim1_current = ObjectAnimator.ofFloat(getChildAt(current), "scaleX", 1.0f, 1.2f);
        ObjectAnimator anim2_current = ObjectAnimator.ofFloat(getChildAt(current), "scaleY", 1.0f, 1.2f);

        ObjectAnimator anim1_last = ObjectAnimator.ofFloat(getChildAt(last), "scaleX", 1.2f, 1.0f);
        ObjectAnimator anim2_last = ObjectAnimator.ofFloat(getChildAt(last), "scaleY", 1.2f, 1.0f);

        AnimatorSet set=new AnimatorSet();
        set.setDuration(500);
        set.playTogether(anim1_current,anim2_current,anim1_last,anim2_last);
        set.start();

       int dx= getDeletaX( current,  last);

        if (getScrollX() + dx < leftBorder) { //以前滑动的距离加上本次滑动的距离比左边第一个view的lfet小 既为滑出左边界了 滑出左边界是向右滑动所以getScrollX()为负值
            scrollTo(leftBorder-view_margin_left_or_right, 0);
            return ;
        } else if (getScrollX() + dx > rightBorder-getWidth()) {//以前滑动的距离加上本次滑动的距离比右边最后一个view的right减去viewGroup的宽度大 既为滑出右边界了 滑出右边界是向左滑动所以getScrollX()为正值
            scrollTo(rightBorder+view_margin_left_or_right - getWidth(), 0);
            return ;
        }
//        scrollBy(dx,0);
        mScroller.startScroll(getScrollX(), 0, dx, 0,500);
        invalidate();
    }


    @Override
    public void computeScroll() {
        // 第三步，重写computeScroll()方法，并在其内部完成平滑滚动的逻辑
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

}

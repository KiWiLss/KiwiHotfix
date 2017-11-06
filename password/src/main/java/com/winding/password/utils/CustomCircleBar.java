package com.winding.password.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class CustomCircleBar extends View {
    private Context context;
    /*进度值*/  
    private int percent;  
    /*颜色值*/  
    private int mProgessColor;  
    /*下边的文字名称*/  
    private String mCustomText;  
    /*外圈圆环的画笔*/  
    private Paint paintBar = new Paint();
    /*下边文字的画笔*/  
    private Paint paintText = new Paint();  
    /*动态获取属性值*/  
    private TypedValue typedValue;
    /*先加速后减速*/  
    DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator();
    /*动画持续时间*/  
    private int duration = 10;  
    private int curTime = 0;  
    public CustomCircleBar(Context context) {  
        super(context);  
        this.context=context;  
        init();  
    }  
  
    public CustomCircleBar(Context context, AttributeSet attrs) {
        super(context, attrs);  
        this.context=context;  
        init();  
    }  
  
    public CustomCircleBar(Context context, AttributeSet attrs, int defStyleAttr) {  
        super(context, attrs, defStyleAttr);  
        this.context=context;  
        init();  
    }  
  
  
  
    public void setPercent(int percent) {  
        this.percent = percent;  
        /*isShown()：Returns the visibility of this view and all of its ancestors*/  
        if (isShown()) {  
            /*设置进度后重新开始一次动画*/  
            curTime=0;  
            this.invalidate();  
        }  
    }  
  
    public void setProgessColor(int mProgessColor) {  
        this.mProgessColor = mProgessColor;  
        if (isShown()) {  
            this.invalidate();  
        }  
    }  
  
  
    public void setCustomText(String mCustomText) {  
        this.mCustomText = mCustomText;  
    }  
  
    private Handler mHandler = new Handler();
    private Runnable mAnimation = new Runnable() {  
        @Override  
        public void run() {  
            if (curTime < duration) {  
                curTime++;  
                /*导致重绘，调用onDraw，onDraw最后调用 
                *  mHandler.postDelayed(mAnimation, 20);更新进度条，界面重绘 
                *  每次20毫秒，绘制10次，因此动画时间200毫秒*/  
                CustomCircleBar.this.invalidate();  
            }  
        }  
    };  
  
    private void init() {  
        /*数据初始化，没有设置属性时候的默认值*/  
        percent = 0;  
        mProgessColor= Color.rgb(95,112,72);
        mCustomText="Home";  
        typedValue=new TypedValue();  
        //context.getTheme().resolveAttribute(R.attr.maintextclor,typedValue,true);
    }  
  
  
  
    @Override  
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);  
        float mWidth = getWidth();  
        float mHeight = getHeight();  
        /*下边是进度条画笔的设置*/  
        /** Restores the paint to its default settings. */  
        paintBar.reset();  
        /*圆环宽度4个像素*/  
        paintBar.setStrokeWidth(4);  
        /*空心圆环而非填充的额扇形*/  
        paintBar.setStyle(Paint.Style.STROKE);  
        paintBar.setAntiAlias(true);  
        paintBar.setColor(mProgessColor);  
        /*调整下不透明度，使边框弧和进度条区分开*/  
        paintBar.setAlpha(80);  
        /*接下来是文字画笔的设置*/  
        paintText.setTextSize(20);  
        paintText.setColor(getResources().getColor(typedValue.resourceId));  
        paintText.setStyle(Paint.Style.STROKE);  
        paintText.setAntiAlias(true);  
        /*从中间开始绘制文本*/  
        paintText.setTextAlign(Paint.Align.CENTER);  
        /*测量文字大小*/  
        Paint.FontMetrics fontMetrics = paintText.getFontMetrics();  
        /*计算文字高度*/  
        float textHeight = fontMetrics.bottom - fontMetrics.top;  
        /*计算圆的半径*/  
        float radius = Math.min(mWidth, mHeight) / 2 - 10;  
        /*  ❑ save：用来保存Canvas的状态。save之后，可以调用Canvas的平移、放缩、旋转、错切、裁剪等操作。 
            ❑ restore：用来恢复Canvas之前保存的状态。防止save后对Canvas执行的操作对后续的绘制有影响。*/  
        /*保存画布，绘制进度条*/  
        canvas.save();  
        /*clipRect：该方法用于裁剪画布，也就是设置画布的显示区域 
        调用clipRect()方法后，只会显示被裁剪的区域，之外的区域将不会显示 */  
        canvas.clipRect(0, 0, mWidth, mHeight / 2 + radius - textHeight * 3 / 4);  
        /*因为clipRect的原因，外边的圆环下边留个缺口绘制文字*/  
        canvas.drawCircle(mWidth / 2, mHeight / 2, radius, paintBar);  
  
        /*三角函数计算，下方缺口扇形的角度的一半*/  
        float theta_offset = (float) Math.acos((radius - textHeight / 2) / radius);  
        /*大弧围成的扇形的角度*/  
        float theta_full = 360 - 2 * theta_offset;  
        /*进度值围成的弧对应的角度*/  
        float thetaProcess = mDecelerateInterpolator.getInterpolation(1.0f * curTime / duration) * percent * theta_full / 100;  
        /*设置进度值颜色完全不透明*/  
        paintBar.setAlpha(255);  
        paintBar.setColor(mProgessColor);  
        /*注意弧形的起始角度，下边因显示文字导致圆环断开成一条弧，弧有左右两个端点，从左端点开始画弧*/  
        canvas.drawArc(new RectF(mWidth / 2 - radius, mHeight / 2 - radius, mWidth / 2 + radius, mHeight / 2 + radius), theta_offset+90, thetaProcess, false, paintBar);
        /*恢复画布*/  
        canvas.restore();  
        /*开始绘制文字*/  
        paintText.setTextSize(20);  
        fontMetrics = paintText.getFontMetrics();  
        float textBaseLineOffset = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom;  
        canvas.drawText(mCustomText, mWidth / 2, mHeight / 2 + radius - textHeight / 2 + textBaseLineOffset, paintText);  
  
        /*绘制百分号*/  
        paintText.setTextSize(mHeight * 1 / 8);  
        fontMetrics = paintText.getFontMetrics();  
        textBaseLineOffset = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom;  
        canvas.drawText("%", mWidth / 2, mHeight / 2 + radius / 3 + textBaseLineOffset, paintText);  
  
        /*绘制百分比*/  
        paintText.setTextSize(mHeight * 3 / 8);  
        canvas.drawText("" + (int)(percent*mDecelerateInterpolator.getInterpolation(1.0f * curTime / duration)), mWidth / 2, mHeight / 2, paintText);  
        /*20毫秒后执行动画*/  
        mHandler.postDelayed(mAnimation, 20);  
    }  
}  
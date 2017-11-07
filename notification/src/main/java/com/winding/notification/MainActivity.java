package com.winding.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.winding.notification.activity.VpActivity;
import com.winding.notification.activity.WaveActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
    private NotificationManager mNcm;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.tv_main_text);
        //获取系统提供的通知管理器
        mNcm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationColor = Utils.getNotificationColor(this);
        mTv.setTextColor(notificationColor);
        Log.e(TAG, "onCreate: "+notificationColor );


    }

    public void defaultClick(View view) {
        startActivity(new Intent(this,NotifiActivity.class));
        //createNotifi();
    }
    public void createNotifi(){//一般的通知
        //获取通知的构造器
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("标题")//设置通知的标题
        .setContentText("通知的内容")//设置通知的内容
        .setSmallIcon(R.mipmap.face)
        .setWhen(System.currentTimeMillis())//设置时间
        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.logo))
        .setContentInfo("设置附带信息")
        .setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE)//设置声音和振动
        .setTicker("设置滚动提示的文字")
        .setOngoing(true);//是否可以手动移除

        Notification notification = builder.build();
        mNcm.notify(1,notification);//发送通知


    }


    public void intentClick(View view) {//带意图的通知
        Intent intent = new Intent();
        intent.setAction("android.intent.action.Notifi");
        intent.putExtra("key","values");
        //获得一个延时意图
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder.setContentTitle("标题")//设置通知的标题
                .setContentText("通知的内容")//设置通知的内容
                .setSmallIcon(R.mipmap.face)
                //.setWhen(System.currentTimeMillis())//设置时间
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.face))
                //.setContentInfo("设置附带信息")
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)//设置声音和振动
                //.setTicker("设置滚动提示的文字")
                .setOngoing(false)//是否可以手动移除
                .setContentIntent(pendingIntent).build();//传递intent     PendingIntent intent 延时意图
        mNcm.notify(2,notification);//发送通知
    }

    public void cancelClick(View view) {
        //        //根据id取消对应的通知
                mNcm.cancel(1);
                //mNcm.cancelAll();//取消所有
    }

    public void bigReviewClick(View view) {//大视图通知
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder.setTicker("设置滚动提示的文字")
                .setContentTitle("标题")//设置通知的标题
                .setContentText("通知的内容")//设置通知的内容
                .setSmallIcon(R.mipmap.face)
                //.setWhen(System.currentTimeMillis())//设置时间
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.face))
                //.setContentInfo("设置附带信息")
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)//设置声音和振动
                //.setTicker("设置滚动提示的文字")
                //.setOngoing(false)//是否可以手动移除
               .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("白费劲啊飞机的飞机啊房间爱疯没法讲方法诶" +
                                "白费劲啊飞机的飞机啊房间爱疯没法讲方法诶" +
                                "白费劲啊飞机的飞机啊房间爱疯没法讲方法诶" +
                                "白费劲啊飞机的飞机啊房间爱疯没法讲方法诶"))
                .setPriority(1)//设置优先级
                .build();
        mNcm.notify(3,notification);//发送通知
    }

    public void customReviewClick(View view) {//自定义通知
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setTicker("状态栏通知");//状态栏通知内容

        builder.setSmallIcon(R.mipmap.logo);// 设置通知小图标,在下拉之前显示的图标
        //builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));// 落下后显示的图标
        //builder.setWhen(System.currentTimeMillis());
        builder.setOngoing(true);// 不能被用户x掉，会一直显示，如音乐播放等
        builder.setAutoCancel(true);// 自动取消
        builder.setOnlyAlertOnce(true);// 只alert一次
        builder.setDefaults(Notification.DEFAULT_ALL);

        RemoteViews mRemoteViews = new RemoteViews(getPackageName(), R.layout.notice);//设置自定义的布局
//        mRemoteViews.setImageViewResource(R.id.iv_icon, R.mipmap.ali_pey);
//        mRemoteViews.setTextViewText(R.id.tv_text1, "自定义标题");
//        mRemoteViews.setTextViewText(R.id.tv_text2, "自定义内容");
//        mRemoteViews.setTextViewText(R.id.tv_text3,"21:58");
        builder.setContent(mRemoteViews);
//        Intent intent = new Intent(this, RightFinishActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
//        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;

        mNcm.notify(0, notification);
    }


    public void waveReviewClick(View view) {
        startActivity(new Intent(this,WaveActivity.class));
    }

    public void viewPagerReviewClick(View view) {
        startActivity(new Intent(this,VpActivity.class));
    }
}

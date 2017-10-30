package com.winding.scrolling.activity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.winding.scrolling.R;
import com.winding.scrolling.model.News;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.Date;
import java.util.List;

/**
 * Created by 刘少帅 on 2017/10/30
 */

public class DataActivity extends AppCompatActivity {

    public static final String TAG = "MMM";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);


        //SQLiteDatabase db = Connector.getDatabase();
        //便于操作sq语句

        SQLiteDatabase database = LitePal.getDatabase();


    }

    public void updateListener(View view) {
        //把表中id为4的destId改为"1"
        ContentValues contentValues = new ContentValues();
        contentValues.put("title","没有第几");
        DataSupport.update(News.class,contentValues,60);
        //或者
        News news = new News();
        news.setTitle("kitty");
        news.update(58);
    }

    public void deleteListener(View view) {
        //删除某一条记录
        DataSupport.delete(News.class,2);
        //删除某一条件下的数据
        DataSupport.deleteAll(News.class," title = ? ","第6个");



    }

    public void queryListener(View view) {
        News news = DataSupport.find(News.class, 1);//查询第一个数据
        //查询第一条数据
        //News news1 = DataSupport.findFirst(News.class);
        if (news!=null)
        Log.e(TAG, "queryListener: 1--->"+news.toString());
        //查询所有数据

        List<News> all = DataSupport.findAll(News.class);
        for (News n :
                all) {
            Log.e(TAG, "queryListener: all--->"+n.toString());
        }
        //查询最后一条
        News last = DataSupport.findLast(News.class);
        if (news!=null)
        Log.e(TAG, "queryListener: all--->"+last.toString());
        //查询某几条
        //List<News> all1 = DataSupport.findAll(News.class, 1, 2);


    }

    public void addListener(View view) {
        for (int i = 0; i < 10; i++) {
            News news = new News();
            news.setId((i+1));
            news.setTitle("第"+i+"个");
            news.setContent("content"+i);
            news.setCommentCount(i);
            news.setPublishDate(new Date());
            boolean save = news.save();
            Log.e(TAG, "addListener: "+save );
        }
    }

    public void deleteAllListener(View view) {
        DataSupport.deleteAll(News.class);
    }
}

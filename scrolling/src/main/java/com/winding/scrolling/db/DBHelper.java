package com.winding.scrolling.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 刘少帅 on 2017/10/30
 */

public class DBHelper extends SQLiteOpenHelper {

    //数据库版本
    private static final int VERSION = 1;
    //新建一个表
    String sql = "create table if not exists TestUsers"+
            "(id int primary key,name varchar,sex varchar)";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //创建表时调用
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);//创建一个表
    }
    //更新表时调用
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}

package com.winding.scrolling.activity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.winding.scrolling.R;
import com.winding.scrolling.db.DBHelper;

/**
 * Created by 刘少帅 on 2017/10/30
 */

public class SqDataActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqdata);


        OpenDb();

    }

    private void OpenDb() {
        dbHelper = new DBHelper(this, "test.db", null, 1);
        mDb = dbHelper.getWritableDatabase();
    }

    public void addListener(View view) {
        String sql = "insert into TestUsers (id,name,sex) values (2,'hongguang','men')";
        try {
            mDb.execSQL(sql);
        } catch (SQLException e) {
            Log.i("err", "insert failed");
        }
    }


   /* public String queryData(MySQLiteHelper myHelper) {
        String result = "";
        // 获得数据库对象
        SQLiteDatabase db = myHelper.getReadableDatabase();
        // 查询表中的数据
        Cursor cursor = db.query("hero_info", null, null, null, null, null,
                "id asc");
        // 获取name列的索引
        int nameIndex = cursor.getColumnIndex("name");
        // 获取level列的索引
        int levelIndex = cursor.getColumnIndex("level");
        for (cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()) {
            result = result + cursor.getString(nameIndex) + "\t\t";
            result = result + cursor.getInt(levelIndex) + "\n";
        }
        cursor.close();// 关闭结果集
        db.close();// 关闭数据库对象
        return result;
    }*/
    public void queryListener(View view) {
//        String sql = "select from * TestUsers";
//        try {
//            mDb.execSQL(sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Cursor c=mDb.rawQuery( "SELECT name FROM TestUsers", null);
        c.moveToFirst();
        Log.e("MMM", "queryListener: "+c.getColumnCount());
        Log.e("MMM", "queryListener: "+c.getColumnIndex("name"));
        Log.e("MMM", "queryListener: "+c.getColumnIndex("sex"));
        while (!c.isAfterLast()) {
            int id=c.getInt(0);
            String name=c.getString(0);
            Log.e("MMM", "queryListener: "+name );

            // do something useful with these
            c.moveToNext();
        }
        c.close();
    }

    public void deleteListener(View view) {
        String sql = "delete from TestUsers where id = 2";
        mDb.execSQL(sql);
    }

    public void updateListener(View view) {


        String sql = "Update TestUsers set name = 'anhong',sex = 'men' where id = 2";
        try {
            mDb.execSQL(sql);
        } catch (SQLException e) {
            Log.i("err", "update failed");
        }

    }

    public void deleteAllListener(View view) {
        String sql = "delete from TestUsers ";
        mDb.execSQL(sql);
    }


    /**
     * 关闭数据库
     */
    public void CloseDb(){
        mDb.close();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mDb!=null){
            mDb.close();
        }
        if(dbHelper!=null){
            dbHelper.close();
        }
    }
}

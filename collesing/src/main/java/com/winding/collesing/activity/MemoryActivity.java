package com.winding.collesing.activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.winding.collesing.MyApp;
import com.winding.collesing.R;
import com.winding.collesing.entity.User;
import com.winding.collesing.gen.UserDao;

import java.io.File;
import java.util.List;

import static android.os.Environment.DIRECTORY_MUSIC;

/**
 * Created by 刘少帅 on 2017/10/30
 */

public class MemoryActivity extends AppCompatActivity {
    public static final String TAG = "MMM";
    private UserDao mUserDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        File file = Environment.getExternalStorageDirectory();
        File file1 = Environment.getExternalStoragePublicDirectory(DIRECTORY_MUSIC);

        File file2 = getExternalCacheDir();
        File[] files = getExternalCacheDirs();

        Log.e("MMM", "onCreate: "+file+"|||"+file1
        +"|||"+file2+"|||"+files);
        mUserDao = MyApp.getInstances().getDaoSession().getUserDao();
    }


    public void queryListener(View view) {
        List<User> users = mUserDao.loadAll();
        String userName = "";
        for (int i = 0; i < users.size(); i++) {
            userName += users.get(i).getName()+",";
        }
        Log.e(TAG, "queryListener: "+userName);


    }

    public void updateListener(View view) {
        User mUser = new User((long) 2, "Two");
        mUserDao.update(mUser);
    }

    public void deleteOneListener(View view) {
        //根据主键删除
        //mUserDao.deleteByKey((long)3);
        //根据条件删除

        List<User> list = mUserDao.queryBuilder().where(UserDao.Properties.Id.between(2, 4)).build().list();
        for (int i = 0; i < list.size(); i++) {
            Log.e(TAG, "deleteOneListener: "+list.get(i).getName());
        }
    }

    public void addListener(View view) {
        for (int i = 0; i < 5; i++) {
            User mUser = new User(null, "anye"+i);
            mUserDao.insert(mUser);//添加一个
        }



//        User mUser3 = new User(null, "kitty");
//        mUserDao.insert(mUser3);//添加一个

    }

    public void createListener(View view) {

    }

    public void deleteDbListener(View view) {
        mUserDao.deleteAll();
    }
}

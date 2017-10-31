package com.winding.scrolling.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.winding.scrolling.R;
import com.winding.scrolling.model.DataBean;
import com.winding.scrolling.widget.Week;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘少帅 on 2017/10/31
 */

public class WeekActivity extends AppCompatActivity {
    private Week weekView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        weekView=(Week)findViewById(R.id.weekView);

        List<Week.NodeInterFace> mList=new ArrayList<>();
        DataBean dataBean1=new DataBean();
        dataBean1.setDate("星期一");
        dataBean1.setIsSelected(false);
        mList.add(dataBean1);

        DataBean dataBean2=new DataBean();
        dataBean2.setDate("星期二");
        dataBean2.setIsSelected(false);
        mList.add(dataBean2);

        DataBean dataBean3=new DataBean();
        dataBean3.setDate("星期三");
        dataBean3.setIsSelected(false);
        mList.add(dataBean3);

        DataBean dataBean4=new DataBean();
        dataBean4.setDate("星期四");
        dataBean4.setIsSelected(false);
        mList.add(dataBean4);

        DataBean dataBean5=new DataBean();
        dataBean5.setDate("星期五");
        dataBean5.setIsSelected(true);
        mList.add(dataBean5);

        DataBean dataBean6=new DataBean();
        dataBean6.setDate("星期六");
        dataBean6.setIsSelected(false);
        mList.add(dataBean6);

        DataBean dataBean7=new DataBean();
        dataBean7.setDate("星期日");
        dataBean7.setIsSelected(false);
        mList.add(dataBean7);

        DataBean dataBean8=new DataBean();
        dataBean8.setDate("下周一");
        dataBean8.setIsSelected(false);
        mList.add(dataBean8);

        DataBean dataBean9=new DataBean();
        dataBean9.setDate("下周二");
        dataBean9.setIsSelected(false);
        mList.add(dataBean9);

        DataBean dataBean10=new DataBean();
        dataBean10.setDate("下周三");
        dataBean10.setIsSelected(false);
        mList.add(dataBean10);

        DataBean dataBean11=new DataBean();
        dataBean11.setDate("下周四");
        dataBean11.setIsSelected(false);
        mList.add(dataBean11);

        DataBean dataBean12=new DataBean();
        dataBean12.setDate("下周五");
        dataBean12.setIsSelected(false);
        mList.add(dataBean12);

        DataBean dataBean13=new DataBean();
        dataBean13.setDate("下周六");
        dataBean13.setIsSelected(false);
        mList.add(dataBean13);

        DataBean dataBean14=new DataBean();
        dataBean14.setDate("下周日");
        dataBean14.setIsSelected(false);
        mList.add(dataBean14);

        weekView.setData(mList, new Week.OnWeekClickListener() {
            @Override
            public void onClick(String text) {
                Toast.makeText(WeekActivity.this,text,Toast.LENGTH_SHORT).show();
            }
        });

    }
}

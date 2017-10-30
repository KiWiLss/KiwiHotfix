package com.winding.scrolling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

import com.winding.scrolling.R;

/**
 * Created by 刘少帅 on 2017/10/26
 */

public class UpDownActivity extends AppCompatActivity {

    private RecyclerView mRv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_down);

        FloatingActionButton viewById = (FloatingActionButton) findViewById(R.id.fab_updown_test);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpDownActivity.this, ModileActivity.class));
            }
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

//        SwipeRefreshLayout viewById = (SwipeRefreshLayout) findViewById(R.id.behavior_demo_swipe_refresh);
//        viewById.setEnabled(false);
      /*  mRv = (RecyclerView) findViewById(R.id.behavior_demo_recycler);
        mRv.setHasFixedSize(true);
        mRv.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> list = new ArrayList<>();
        for (int i = 50; i > 0; i--) {
            list.add("fjie");
        }
        UpDowmAdapter upDowmAdapter = new UpDowmAdapter(this, list);
        mRv.setAdapter(upDowmAdapter);*/

    }



}

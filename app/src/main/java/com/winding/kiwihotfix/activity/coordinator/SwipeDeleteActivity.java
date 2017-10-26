package com.winding.kiwihotfix.activity.coordinator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.winding.kiwihotfix.R;

/**
 * Created by 刘少帅 on 2017/10/26
 */

public class SwipeDeleteActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_delete);

        tv = (TextView) findViewById(R.id.tv_swipe_test);

        final SwipeDismissBehavior<View> swipe
                = new SwipeDismissBehavior();

        swipe.setSwipeDirection(
                SwipeDismissBehavior.SWIPE_DIRECTION_ANY);

        swipe.setListener(
                new SwipeDismissBehavior.OnDismissListener() {
                    @Override public void onDismiss(View view) {
                        Toast.makeText(SwipeDeleteActivity.this,
                                "Card swiped !!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDragStateChanged(int state) {
                        Log.e(TAG, "onDragStateChanged: "+state);
                    }
                });

        CoordinatorLayout.LayoutParams coordinatorParams =
                (CoordinatorLayout.LayoutParams) tv.getLayoutParams();


        coordinatorParams.setBehavior(swipe);


    }
}

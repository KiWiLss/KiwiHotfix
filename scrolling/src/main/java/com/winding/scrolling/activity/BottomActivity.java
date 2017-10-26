package com.winding.scrolling.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.winding.scrolling.R;
import com.winding.scrolling.adapter.UpDowmAdapter;

import java.util.ArrayList;

/**
 * Created by 刘少帅 on 2017/10/26
 * 仿百度,底部拉出
 */

public class BottomActivity extends AppCompatActivity {
    private RelativeLayout design_bottom_sheet_bar;
    private RelativeLayout design_bottom_sheet;
    private ImageView bottom_sheet_iv;
    private TextView bottom_sheet_tv;
    private boolean isSetBottomSheetHeight=false;
    private CoordinatorLayout coordinatorLayout;
    private RecyclerView mRv;

     BottomSheetBehavior behavior;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cl_bottom_outer);
        design_bottom_sheet_bar=(RelativeLayout) findViewById(R.id.design_bottom_sheet_bar);
        design_bottom_sheet=(RelativeLayout) findViewById(R.id.design_bottom_sheet);
        bottom_sheet_iv=(ImageView) findViewById(R.id.bottom_sheet_iv);
        bottom_sheet_tv=(TextView) findViewById(R.id.bottom_sheet_tv);

         findViewById(R.id.srl_bottom_refresh).setEnabled(false);
        mRv = (RecyclerView) findViewById(R.id.rv_bottom_list);

         behavior = BottomSheetBehavior.from(design_bottom_sheet);


        mRv = (RecyclerView) findViewById(R.id.rv_bottom_list);
        mRv.setHasFixedSize(true);
        mRv.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> list = new ArrayList<>();
        for (int i = 50; i > 0; i--) {
            list.add("fjie");
        }
        UpDowmAdapter upDowmAdapter = new UpDowmAdapter(this, list);
        mRv.setAdapter(upDowmAdapter);


//        design_bottom_sheet_bar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//            }
//        });

        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {

            //BottomSheet状态改变时的回调
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                if(newState!=BottomSheetBehavior.STATE_COLLAPSED&&bottom_sheet_tv.getVisibility()==View.VISIBLE){
                    bottom_sheet_tv.setVisibility(View.GONE);
                    bottom_sheet_iv.setVisibility(View.VISIBLE);
                }else if(newState==BottomSheetBehavior.STATE_COLLAPSED&&bottom_sheet_tv.getVisibility()==View.GONE){
                    bottom_sheet_tv.setVisibility(View.VISIBLE);
                    bottom_sheet_iv.setVisibility(View.GONE);
                }
            }

            //BottomSheet滑动时的回调
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

//                if(bottomSheet.getTop()<2*design_bottom_sheet_bar.getHeight()){
//                    design_bottom_sheet_bar.setVisibility(View.VISIBLE);
//                    design_bottom_sheet_bar.setAlpha(slideOffset);
//                    design_bottom_sheet_bar.setTranslationY(bottomSheet.getTop()-2*design_bottom_sheet_bar.getHeight());
//                }
//                else{
//                    design_bottom_sheet_bar.setVisibility(View.INVISIBLE);
//                }
            }
        });


        mRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

//                if(behavior.getState()!=BottomSheetBehavior.STATE_COLLAPSED){
//                    //recyclerview滚动时  如果BottomSheetBehavior不是折叠状态就置为折叠
//                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//                }
            }
        });

    }

  /*  public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);

        //修改SetBottomSheet的高度 留出顶部工具栏的位置
        if(!isSetBottomSheetHeight){
            CoordinatorLayout.LayoutParams linearParams =(CoordinatorLayout.LayoutParams) design_bottom_sheet.getLayoutParams();
            linearParams.height=coordinatorLayout.getHeight()-design_bottom_sheet_bar.getHeight();
            design_bottom_sheet.setLayoutParams(linearParams);
            isSetBottomSheetHeight=true;//设置标记 只执行一次
            Log.e("MMM", "onWindowFocusChanged: "+isSetBottomSheetHeight);
        }

    }*/


    public void collospingListener(View view) {
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }
}

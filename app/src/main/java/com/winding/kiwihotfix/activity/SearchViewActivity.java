package com.winding.kiwihotfix.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.winding.kiwihotfix.R;
import com.winding.kiwihotfix.utils.ImeUtils;
import com.winding.kiwihotfix.widget.DribSearchView;

/**
 * Created by 刘少帅 on 2017/10/25
 */

public class SearchViewActivity extends AppCompatActivity {
    private DribSearchView dribSearchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchview);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText editview = (EditText) findViewById(R.id.editview);

        dribSearchView = (DribSearchView) findViewById(R.id.dribSearchView);
        dribSearchView.setOnClickSearchListener(new DribSearchView.OnClickSearchListener() {
            @Override
            public void onClickSearch() {
                dribSearchView.changeLine();
                //ImeUtils.showInput(dribSearchView);
                ImeUtils.showSoftKeyboard(dribSearchView);
                //materialMenu.animateIconState(MaterialMenuDrawable.IconState.ARROW, true);
            }
        });
        dribSearchView.setOnChangeListener(new DribSearchView.OnChangeListener() {
            @Override
            public void onChange(DribSearchView.State state) {
                switch (state) {
                    case LINE:
                        editview.setVisibility(View.VISIBLE);
                        editview.setFocusable(true);
                        editview.setFocusableInTouchMode(true);
                        editview.requestFocus();
                        ImeUtils.showInput(dribSearchView);
                        break;
                    case SEARCH:
                        editview.setVisibility(View.GONE);
                        ImeUtils.hideInputForce(SearchViewActivity.this);
                        break;
                }
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                dribSearchView.changeSearch();
                //materialMenu.animateIconState(MaterialMenuDrawable.IconState.BURGER, true);
            }
        });

//        materialMenu = new MaterialMenuDrawable(this, Color.WHITE, MaterialMenuDrawable.Stroke.EXTRA_THIN);
//        toolbar.setNavigationIcon(materialMenu);
//        materialMenu.setNeverDrawTouch(true);
    }

    public void closeListener(View view) {
        dribSearchView.changeSearch();
        ImeUtils.hideInputForce(SearchViewActivity.this);
    }
}

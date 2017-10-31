package com.winding.scrolling.model;

import com.winding.scrolling.widget.Week;

/**
 * Created by hzm on 2017/10/13  in chongqing.
 */

public class DataBean implements Week.NodeInterFace {

    String date;
    boolean isSelected;

    public void setDate(String date) {
        this.date = date;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }
}

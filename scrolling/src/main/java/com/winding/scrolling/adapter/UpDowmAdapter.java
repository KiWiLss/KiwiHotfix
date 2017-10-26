package com.winding.scrolling.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winding.scrolling.R;

import java.util.List;

/**
 * Created by 刘少帅 on 2017/10/26
 */

public class UpDowmAdapter extends RecyclerView.Adapter<UpDowmAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private Context context;
    private List<String>mData;

    public UpDowmAdapter(Context context, List<String> mData) {
        this.context = context;
        this.mData = mData;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_up_dowm, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}

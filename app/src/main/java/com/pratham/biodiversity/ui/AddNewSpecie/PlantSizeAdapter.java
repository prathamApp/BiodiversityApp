package com.pratham.biodiversity.ui.AddNewSpecie;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.pratham.biodiversity.custom.GridItemView;

import java.util.ArrayList;
import java.util.List;

public class PlantSizeAdapter extends BaseAdapter {
    private Context mContext;
    int[] mThumbIds;
    public List selectedPositions;
    String[] strOptions;

    // Constructor
    public PlantSizeAdapter(Context mContext, int[] mThumbIds, String[] strOptions) {
        this.mContext=mContext;
        this.mThumbIds=mThumbIds;
        this.strOptions=strOptions;
        selectedPositions = new ArrayList<>();
    }

    public PlantSizeAdapter(Context mContext, int[] mThumbIds) {
        this.mContext=mContext;
        this.mThumbIds=mThumbIds;
        selectedPositions = new ArrayList<>();
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return mThumbIds[position];
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
/*        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(20, 20, 20, 20);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;*/
        GridItemView customView = (convertView == null) ? new GridItemView(mContext) : (GridItemView) convertView;
        customView.display(mThumbIds[position], selectedPositions.contains(position));

        return customView;

    }

    // Keep all Images in array
/*    public Integer[] mThumbIds = {
            R.drawable.ic_arrow_back_white_24dp, R.drawable.ic_arrow_forward_white_24dp,
            R.drawable.ic_close_green_24dp, R.drawable.ic_explore_grey_24dp
    };*/
}


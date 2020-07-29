package com.pratham.biodiversity.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.pratham.biodiversity.R;

public class GridItemView extends FrameLayout {

    private ImageView imageView;

    public GridItemView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.item_grid, this);
        imageView = (ImageView) getRootView().findViewById(R.id.text);
    }

    public void display(int res, boolean isSelected) {
        imageView.setImageResource(res);
        display(isSelected);
    }

    public void display(boolean isSelected) {
        imageView.setBackgroundResource(isSelected ? R.drawable.roundblackborder : R.color.transparent);
    }
}
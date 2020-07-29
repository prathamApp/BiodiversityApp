package com.pratham.biodiversity.ui.AddNewSpecie;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class PageTransform implements ViewPager.PageTransformer {

    private static final float ROT_MOD = -15f;
    public void transformPage(@NonNull View view, float position) {
                final float normalizedposition = Math.abs(Math.abs(position) - 1);
                view.setScaleX(normalizedposition / 2 + 0.5f);
                view.setScaleY(normalizedposition / 2 + 0.5f);
    }

}

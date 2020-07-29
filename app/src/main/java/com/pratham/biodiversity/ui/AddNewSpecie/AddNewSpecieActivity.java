package com.pratham.biodiversity.ui.AddNewSpecie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pratham.biodiversity.R;
import com.pratham.biodiversity.custom.StepperIndicator;
import com.pratham.biodiversity.custom.ViewPagerCustomDuration;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_add_new_specie)
public class AddNewSpecieActivity extends AppCompatActivity{

    @ViewById(R.id.view_pager)
    ViewPagerCustomDuration viewPager;
    @ViewById(R.id.tv_prev)
    TextView tv_prev;
    @ViewById(R.id.tv_next)
    TextView tv_next;
    @ViewById(R.id.stepper_indicator)
    StepperIndicator stepperIndicator;

    NewSpecieAdapter newSpecieAdapter;
    int current;

    private int[] layouts;
    @AfterViews
    public void initialize() {

        layouts = new int[]{
                R.layout.fragment_one,
                R.layout.fragment_two,
                R.layout.fragment__three,
                R.layout.fragment__four,
                R.layout.fragment_five,
                R.layout.fragment_six,
                R.layout.fragment_seven};
        newSpecieAdapter = new NewSpecieAdapter(getSupportFragmentManager());

        viewPager.setScrollDurationFactor(2);
        viewPager.setPageTransformer(true, new PageTransform());
        viewPager.setAdapter(newSpecieAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        stepperIndicator.setViewPager(viewPager);
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {

            if (position > 0) {
                tv_prev.setVisibility(View.VISIBLE);
                tv_next.setVisibility(View.VISIBLE);
            } else {
                tv_prev.setVisibility(View.GONE);
                tv_next.setVisibility(View.VISIBLE);
            }
            current = getItem(+1);
            Log.e("CurrentPageOnSelected: ", String.valueOf(current));
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    @Click(R.id.tv_next)
    public void next() {
        int current = getItem(+1);
        if (current < layouts.length) {
            // move to next screen
            viewPager.setScrollDurationFactor(4);
            viewPager.setPageTransformer(true, new PageTransform());
            viewPager.setCurrentItem(current);
        } else {
            //launchSplashScreen();
        }
    }

    @Click(R.id.tv_prev)
    public void prev() {
        int current = getItem(-1);
        if (current < layouts.length) {
            // move to prev screen
            viewPager.setCurrentItem(current);
        } else {
         }
    }
}

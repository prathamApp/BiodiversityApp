package com.pratham.biodiversity.ui.SpeciesDetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.pratham.biodiversity.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_species_details)
public class SpeciesDetails extends AppCompatActivity {

    @ViewById(R.id.tv_title)
    TextView tv_title;
    @ViewById(R.id.tv_specieType)
    TextView tv_specieType;
    @ViewById(R.id.tv_specieDetail)
    TextView tv_specieDetail;
    @ViewById(R.id.iv_specie)
    ImageView iv_specie;
    @ViewById(R.id.iv_back)
    ImageView iv_back;
    //@ViewById(R.id.rl_mainBackground)
    //RelativeLayout rl_mainBg;

    private BottomSheetBehavior mBottomSheetBehavior;

    @AfterViews
    public void initialize(){

        String sp_name =getIntent().getStringExtra("title");
        String sp_type =getIntent().getStringExtra("type");
        String sp_detail =getIntent().getStringExtra("detail");
        int sp_img = Integer.parseInt(getIntent().getStringExtra("image"));

        View bottomSheet = findViewById(R.id.bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        //rl_mainBg.setBackgroundColor(bg_color);
        tv_title.setText(sp_name);
        tv_specieType.setText(sp_type);
        tv_specieDetail.setText(sp_detail);
        iv_specie.setImageDrawable(getResources().getDrawable(sp_img));

        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        tv_specieDetail.setLines(4);
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        tv_specieDetail.setMaxLines(10);
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
//                        tv_specieDetail.setMaxLines(10);
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
    }

    @Click(R.id.iv_back)
    public void back(){
        finish();
    }
}

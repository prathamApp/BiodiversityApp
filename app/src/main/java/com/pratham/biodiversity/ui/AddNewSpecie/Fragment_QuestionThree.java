package com.pratham.biodiversity.ui.AddNewSpecie;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.pratham.biodiversity.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment__three)
public class Fragment_QuestionThree extends Fragment {

    @ViewById(R.id.tv_Yes)
    TextView tv_Yes;
    @ViewById(R.id.tv_No)
    TextView tv_No;
    @ViewById(R.id.cardYes)
    CardView cardYes;
    @ViewById(R.id.cardNo)
    CardView cardNo;

    public Fragment_QuestionThree() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize(){
    }

    @Click(R.id.cardYes)
    public void yesSelect(){
        tv_Yes.setTextColor(getResources().getColor(R.color.colorPrimary));
        tv_Yes.setVisibility(View.VISIBLE);
        tv_No.setVisibility(View.GONE);        cardYes.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        cardNo.setCardBackgroundColor(Color.TRANSPARENT);
    }

    @Click(R.id.cardNo)
    public void noSelect(){
        tv_No.setTextColor(getResources().getColor(R.color.lightred));
        tv_No.setVisibility(View.VISIBLE);
        tv_Yes.setVisibility(View.GONE);
        cardNo.setCardBackgroundColor(getResources().getColor(R.color.lightred));
        cardYes.setCardBackgroundColor(Color.TRANSPARENT);
    }

}

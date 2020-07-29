package com.pratham.biodiversity.ui.AddNewSpecie;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pratham.biodiversity.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_one)
public class Fragment_QuestionOne extends Fragment{

    @ViewById(R.id.tv_selectedOption)
    TextView tv_selectedOption;
    @ViewById(R.id.cardPlant)
    CardView cardPlant;
    @ViewById(R.id.cardAnim)
    CardView cardAnim;

    public Fragment_QuestionOne() {
        // Required empty public constructor
    }
    @AfterViews
    public void initialize(){

    }

    @Click(R.id.cardPlant)
    public void plantSelect(){
        tv_selectedOption.setText("Plant");
        tv_selectedOption.setTextColor(getResources().getColor(R.color.colorPrimary));
        tv_selectedOption.setVisibility(View.VISIBLE);
        cardPlant.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
        cardAnim.setCardBackgroundColor(Color.TRANSPARENT);
    }

    @Click(R.id.cardAnim)
    public void animalSelect(){
        tv_selectedOption.setText("Animal");
        tv_selectedOption.setTextColor(getResources().getColor(R.color.orange));
        tv_selectedOption.setVisibility(View.VISIBLE);
        cardAnim.setCardBackgroundColor(getResources().getColor(R.color.orange));
        cardPlant.setCardBackgroundColor(Color.TRANSPARENT);
    }
}

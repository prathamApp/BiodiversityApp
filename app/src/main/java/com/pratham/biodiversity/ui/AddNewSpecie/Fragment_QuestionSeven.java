package com.pratham.biodiversity.ui.AddNewSpecie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.pratham.biodiversity.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_seven)
public class Fragment_QuestionSeven extends Fragment {

    @ViewById(R.id.tv_selectedItem)
    TextView tv_selectedItem;
    @ViewById(R.id.gridviewColor)
    GridView gridViewColor;
    public int[] mThumbIds = {
            R.color.black, R.color.white, R.color.grey,
            R.color.yellow, R.color.brown, R.color.lightred,
            R.color.orange, R.color.green, R.color.blue
    };
    private String[] strOptions={"Black","White","Grey","Yellow","Brown","Red","Orange","Green","Blue"};

    public Fragment_QuestionSeven() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialze(){
        gridViewColor.setAdapter(new PlantSizeAdapter(getActivity(), mThumbIds));
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.grid_item_anim);
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation, .2f, .2f);
        gridViewColor.setLayoutAnimation(controller);

        gridViewColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id){
                // Send intent to SingleViewActivity
                tv_selectedItem.setText(strOptions[position]);
                tv_selectedItem.setVisibility(View.VISIBLE);
            }
        });
    }
}

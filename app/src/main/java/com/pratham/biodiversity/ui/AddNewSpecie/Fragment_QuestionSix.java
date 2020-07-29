package com.pratham.biodiversity.ui.AddNewSpecie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pratham.biodiversity.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_six)
public class Fragment_QuestionSix extends Fragment {

    @ViewById(R.id.tv_selectedItem)
    TextView tv_selectedItem;
    @ViewById(R.id.gridviewSize)
    GridView gridViewSize;
    public int[] mThumbIds = {
            R.drawable.sparrow, R.drawable.myna,
            R.drawable.crow, R.drawable.kite,
            R.drawable.duck, R.drawable.wader
    };
    private String[] strOptions={"Sparrow","Myna","Crow","Kite","Duck","Wader"};
    public Fragment_QuestionSix() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialze(){
        gridViewSize.setAdapter(new PlantSizeAdapter(getActivity(), mThumbIds));
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.grid_item_anim);
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation, .2f, .2f);
        gridViewSize.setLayoutAnimation(controller);

        gridViewSize.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id){
                // Send intent to SingleViewActivity
                tv_selectedItem.setText(strOptions[position]);
                tv_selectedItem.setVisibility(View.VISIBLE);
            }
        });
    }

}

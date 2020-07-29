package com.pratham.biodiversity.ui.AddNewSpecie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.pratham.biodiversity.R;
import com.pratham.biodiversity.custom.GridItemView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Arrays;

@EFragment(R.layout.fragment_five)
public class Fragment_QuestionFive extends Fragment {

    @ViewById(R.id.tv_selectedItem)
    TextView tv_selectedItem;
    @ViewById(R.id.gridviewArea)
    GridView gridViewArea;
    public int[] mThumbIds = {
            R.drawable.icon_forest, R.drawable.icon_grass,
            R.drawable.icon_lake, R.drawable.icon_field,
            R.drawable.icon_humanhabitat
    };
    private String[] strOptions={"Area with Many Trees","Open Area Grassland-Scrubland"
            ,"Wetland","Fields","Human Habitation"};

    private ArrayList<String> selectedStrings;
    private ArrayList<String> selectedOptions;
    private PlantSizeAdapter plantSizeAdapter;

    public Fragment_QuestionFive() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialze(){
        selectedStrings = new ArrayList<>();
        selectedOptions = new ArrayList<>();
        plantSizeAdapter = new PlantSizeAdapter(getActivity(), mThumbIds, strOptions);
        gridViewArea.setAdapter(plantSizeAdapter);
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.grid_item_anim);
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation, .2f, .2f);
        gridViewArea.setLayoutAnimation(controller);

        gridViewArea.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id){
                // Send intent to SingleViewActivity
                int selectedIndex = plantSizeAdapter.selectedPositions.indexOf(position);
                if (selectedIndex > -1) {
                    plantSizeAdapter.selectedPositions.remove(selectedIndex);
                    ((GridItemView) v).display(false);
                    selectedStrings.remove(String.valueOf(parent.getItemAtPosition(position)));
                    selectedOptions.remove(strOptions[position]);
                    tv_selectedItem.setText(String.valueOf(selectedOptions).replaceAll("\\[|\\]", ""));
                    if(selectedOptions.size()==0)
                        tv_selectedItem.setText("No Area Choosen");
                    Log.e(String.valueOf(selectedOptions.size())+" : ",String.valueOf(selectedOptions));
                } else {
                    plantSizeAdapter.selectedPositions.add(position);
                    ((GridItemView) v).display(true);
                    selectedStrings.add(String.valueOf(parent.getItemAtPosition(position)));
                    selectedOptions.add(strOptions[position]);
                    tv_selectedItem.setText(Arrays.toString(new ArrayList[]{selectedOptions}).replaceAll("\\[|\\]", ""));
                    Log.e("Array List : ",String.valueOf(selectedOptions));
                }
            }
        });
    }
}

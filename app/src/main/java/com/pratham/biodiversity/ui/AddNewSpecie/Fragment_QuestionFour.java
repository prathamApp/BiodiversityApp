package com.pratham.biodiversity.ui.AddNewSpecie;

import androidx.fragment.app.Fragment;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.pratham.biodiversity.R;
import com.pratham.biodiversity.custom.GridItemView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EFragment(R.layout.fragment__four)
public class Fragment_QuestionFour extends Fragment {

    @ViewById(R.id.stateSpinner)
    Spinner stateSpinner;
    @ViewById(R.id.tv_selectedItem)
    TextView tv_selectedItem;
    @ViewById(R.id.gridviewFlower)
    GridView gridViewFlower;

    public int[] mThumbIds = {
            R.drawable.icon_tree, R.drawable.icon_sky,
            R.drawable.icon_grass, R.drawable.icon_ground,
            R.drawable.icon_water, R.drawable.icon_mud
    };
    private String[] strOptions={"On a tree","Soaring in sky","On smalltree/shrub/grass","On Ground","In Water","In Mud"};
    private ArrayList<String> selectedStrings;
    private PlantSizeAdapter plantSizeAdapter;

    public Fragment_QuestionFour() {
        // Required empty public constructor
    }

    @AfterViews
    public void initialize(){
        selectedStrings = new ArrayList<>();
        String[] states=getResources().getStringArray(R.array.india_states);
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, states);
        stateSpinner.setAdapter(dataAdapter);

        plantSizeAdapter = new PlantSizeAdapter(getActivity(),mThumbIds);
        gridViewFlower.setAdapter(plantSizeAdapter);
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.grid_item_anim);
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation, .2f, .2f);
        gridViewFlower.setLayoutAnimation(controller);


        gridViewFlower.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id){
                // Send intent to SingleViewActivity
/*
                Toast.makeText(getActivity(), strOptions[position], Toast.LENGTH_SHORT).show();
                tv_selectedItem.setText(strOptions[position]);
                tv_selectedItem.setVisibility(View.VISIBLE);
*/
                int selectedIndex = plantSizeAdapter.selectedPositions.indexOf(position);
                if (selectedIndex > -1) {
                    plantSizeAdapter.selectedPositions.remove(selectedIndex);
                    ((GridItemView) v).display(false);
                    selectedStrings.remove(String.valueOf(parent.getItemAtPosition(position)));
                } else {
                    plantSizeAdapter.selectedPositions.add(position);
                    ((GridItemView) v).display(true);
                    selectedStrings.add(String.valueOf(parent.getItemAtPosition(position)));
                }
            }
        });
    }

}

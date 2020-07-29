package com.pratham.biodiversity.ui.home;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.pratham.biodiversity.R;
import com.pratham.biodiversity.models.Modal_Species;
import com.pratham.biodiversity.ui.fragment_leafdisease.Fragment_LeafDisease_;
import com.pratham.biodiversity.ui.fragment_notification.FragmentNotification;
import com.pratham.biodiversity.ui.fragment_notification.FragmentNotification_;
import com.pratham.biodiversity.ui.fragment_profile.FragmentProfile;
import com.pratham.biodiversity.ui.fragment_profile.FragmentProfile_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @ViewById(R.id.rv_species)
    RecyclerView rv_species;
    @ViewById(R.id.menu)
    ImageView menuicon;
    @ViewById(R.id.main_sliding_drawer)
    SlidingPaneLayout main_sliding_drawer;
    @ViewById(R.id.menu_explore)
    TextView menu_explore;
    @ViewById(R.id.menu_leafdisease)
    TextView menu_leafdisease;
    @ViewById(R.id.menu_sync)
    TextView menu_sync;
    @ViewById(R.id.menu_map)
    TextView menu_map;
    @ViewById(R.id.menu_help)
    TextView menu_help;
    @ViewById(R.id.filter)
    ImageView filterMenu;


    private List<Modal_Species> speciesList = new ArrayList<>();
    private SpeciesAdapter speciesAdapter;
    private boolean isChecked;

    @AfterViews
    public void initialize() {
        BottomNavigationView bottom_navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        addSpecies();
        initializeAdapter();
    }

    @UiThread
    public void initializeAdapter() {
        if (speciesAdapter == null) {
            speciesAdapter = new SpeciesAdapter(this, speciesList);
            rv_species.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            rv_species.setHasFixedSize(true);
            rv_species.setItemViewCacheSize(10);
            rv_species.setItemAnimator(new DefaultItemAnimator());
            rv_species.setAdapter(speciesAdapter);
        }
        else {
            speciesAdapter.notifyDataSetChanged();
        }
    }

    //temporary dummy data
    public void addSpecies(){
        Modal_Species modal_species = new Modal_Species("","","",R.drawable.specieone);
        speciesList.add(modal_species);

        modal_species = new Modal_Species("Plant One","abc","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",R.drawable.specieone);
        speciesList.add(modal_species);

        modal_species = new Modal_Species("Plant Two","def","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",R.drawable.specietwo);
        speciesList.add(modal_species);

        modal_species = new Modal_Species("Plant Three","pqr","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",R.drawable.speciethree);
        speciesList.add(modal_species);

        modal_species = new Modal_Species("Plant Four","xyz","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",R.drawable.speciefour);
        speciesList.add(modal_species);

        modal_species = new Modal_Species("Plant Five","lmn","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",R.drawable.speciefice);
        speciesList.add(modal_species);

        modal_species = new Modal_Species("Plant Six","jkl","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",R.drawable.speciefice);
        speciesList.add(modal_species);

        modal_species = new Modal_Species("Plant Seven","uvw","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",R.drawable.speciefice);
        speciesList.add(modal_species);

        modal_species = new Modal_Species("Plant Eight","ppp","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",R.drawable.speciefice);
        speciesList.add(modal_species);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                Intent i= new Intent(MainActivity.this,MainActivity_.class);
                startActivity(i);
                finish();
                Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.navigation_sms:
                fragment = new FragmentProfile_();
                showFragment(fragment);
                Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.navigation_notifications:
                fragment = new FragmentNotification_();
                showFragment(fragment);
                Toast.makeText(MainActivity.this, "Notification", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    };

    public void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Click(R.id.menu)
    public void setMenuClicked() {
        if (!isChecked)
            if (main_sliding_drawer.isOpen()) main_sliding_drawer.closePane();
            else main_sliding_drawer.openPane();
        else
            onBackPressed();
    }

    @Click(R.id.filter)
    public void filterMenuClicked(View view){
        PopupMenu popup = new PopupMenu(MainActivity.this, view);
        popup.setOnMenuItemClickListener(MainActivity.this);
        popup.inflate(R.menu.filter_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.option1:
                // do your code
                return true;
            case R.id.option2:
                // do your code
                return true;
            case R.id.option3:
                // do your code
                return true;
            default:
                return false;
        }
    }

    @Click(R.id.menu_explore)
    public void exploreMenuClicked(){
        main_sliding_drawer.closePane();
/*
        Intent intent = new Intent(MainActivity.this, MainActivity_.class);
        startActivity(intent);
        finish();
*/
        Toast.makeText(MainActivity.this, "Explore", Toast.LENGTH_SHORT).show();
    }

    @Click(R.id.menu_leafdisease)
    public void leafDiseaseMenuClicked(){
        main_sliding_drawer.closePane();
        Fragment fragment;
        fragment = new Fragment_LeafDisease_();
        showFragment(fragment);
        Toast.makeText(MainActivity.this, "Leaf Disaese", Toast.LENGTH_SHORT).show();
    }

    @Click(R.id.menu_sync)
    public void syncMenuClicked(){
        main_sliding_drawer.closePane();
/*
        Intent intent = new Intent(MainActivity.this, MainActivity_.class);
        startActivity(intent);
        finish();
*/
        Toast.makeText(MainActivity.this, "Sync", Toast.LENGTH_SHORT).show();
    }

    @Click(R.id.menu_map)
    public void mapMenuClicked(){
        main_sliding_drawer.closePane();
/*
        Intent intent = new Intent(MainActivity.this, MainActivity_.class);
        startActivity(intent);
        finish();
*/
        Toast.makeText(MainActivity.this, "Map", Toast.LENGTH_SHORT).show();
    }

    @Click(R.id.menu_help)
    public void helpMenuClicked(){
        main_sliding_drawer.closePane();
/*
        Intent intent = new Intent(MainActivity.this, MainActivity_.class);
        startActivity(intent);
        finish();
*/
        Toast.makeText(MainActivity.this, "Help", Toast.LENGTH_SHORT).show();
    }
}

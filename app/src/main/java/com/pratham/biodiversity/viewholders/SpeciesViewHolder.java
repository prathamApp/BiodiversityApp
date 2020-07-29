package com.pratham.biodiversity.viewholders;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pratham.biodiversity.R;
import com.pratham.biodiversity.models.Modal_Species;
import com.pratham.biodiversity.ui.AddNewSpecie.AddNewSpecieActivity;
import com.pratham.biodiversity.ui.AddNewSpecie.AddNewSpecieActivity_;
import com.pratham.biodiversity.ui.SpeciesDetails.SpeciesDetails_;
//import com.pratham.biodiversity.ui.fragment_addNewSpecie.FragmentAddNewSpecie_;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class SpeciesViewHolder extends RecyclerView.ViewHolder {

    public TextView specie_title, specie_type, addspecie;
    public ImageView specie_image;
    public RelativeLayout rl_specie, rl_addspecie;

    public SpeciesViewHolder(@NonNull View itemView) {
        super(itemView);
        specie_title = itemView.findViewById(R.id.specie_title);
        specie_type = itemView.findViewById(R.id.specie_type);
        specie_image = itemView.findViewById(R.id.specie_img);
        rl_specie = itemView.findViewById(R.id.rl_specie);
        rl_addspecie = itemView.findViewById(R.id.rl_addSpecie);
        addspecie = itemView.findViewById(R.id.tv_addSpecie);
    }

    public void setProfileView(Context context, Modal_Species species, int position){
        int[] androidColors = context.getResources().getIntArray(R.array.androidcolors);
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        rl_specie.setBackgroundColor(randomAndroidColor);
        specie_title.setText(species.getSpeciesName());
        specie_type.setText(species.getSpeciesType());
        specie_image.getLayoutParams().height=getRandomIntInRange(300, 200);
        specie_image.setImageDrawable(context.getResources().getDrawable(species.getSpeciesImage()));

        rl_addspecie.setVisibility(View.GONE);
        rl_specie.setVisibility(View.VISIBLE);

        if (position == 0) {
            rl_addspecie.setVisibility(View.VISIBLE);
            rl_specie.setVisibility(View.GONE);
        }

        specie_image.setOnClickListener(v -> {
            Intent intent = new Intent(context, SpeciesDetails_.class);
            intent.putExtra("title", species.getSpeciesName());
            intent.putExtra("type", species.getSpeciesType());
            intent.putExtra("detail", species.getSpeciesDetails());
            intent.putExtra("image", String.valueOf(species.getSpeciesImage()));
            context.startActivity(intent);
        });

        addspecie.setOnClickListener(v -> {

            Intent intent = new Intent(context, AddNewSpecieActivity_.class);
            context.startActivity(intent);

/*            Fragment fragment;
            fragment = new FragmentAddNewSpecie_();
            FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();*/
        });
    }

    private int getRandomIntInRange(int max, int min) {
        return new Random().nextInt(max - min + min) + min;
    }
}

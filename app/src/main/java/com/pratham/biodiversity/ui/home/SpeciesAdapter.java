package com.pratham.biodiversity.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pratham.biodiversity.R;
import com.pratham.biodiversity.models.Modal_Species;
import com.pratham.biodiversity.viewholders.SpeciesViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpeciesAdapter extends RecyclerView.Adapter<SpeciesViewHolder>{
    private List<Modal_Species> speciesList;
    private Context context;

    public SpeciesAdapter(Context context, List<Modal_Species> speciesList) {
        this.context=context;
        this.speciesList = speciesList;
    }

    @NonNull
    @Override
    public SpeciesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_species_list, parent, false);

        return new SpeciesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeciesViewHolder holder, int position) {
        Modal_Species species = speciesList.get(position);
        int specielistsize = speciesList.size();
        holder.setProfileView(context,species,position);
    }
    @Override
    public int getItemCount() {
        return speciesList.size();
    }
}

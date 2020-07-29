package com.pratham.biodiversity.models;

public class Modal_Species {
    private String SpeciesName, SpeciesType, SpeciesDetails;
    private int SpeciesImage;

    public Modal_Species(String speciesName, String speciesType, String speciesDetails, int speciesImage) {
        SpeciesName = speciesName;
        SpeciesType = speciesType;
        SpeciesDetails = speciesDetails;
        SpeciesImage = speciesImage;
    }

    public String getSpeciesName() {
        return SpeciesName;
    }

    public void setSpeciesName(String speciesName) {
        SpeciesName = speciesName;
    }

    public String getSpeciesType() {
        return SpeciesType;
    }

    public void setSpeciesType(String speciesType) {
        SpeciesType = speciesType;
    }

    public String getSpeciesDetails() {
        return SpeciesDetails;
    }

    public void setSpeciesDetails(String speciesDetails) {
        SpeciesDetails = speciesDetails;
    }

    public int getSpeciesImage() {
        return SpeciesImage;
    }

    public void setSpeciesImage(int speciesImage) {
        SpeciesImage = speciesImage;
    }
}

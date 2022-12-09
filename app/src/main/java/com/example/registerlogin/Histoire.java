package com.example.registerlogin;

public class Histoire {
    private String name ;
    private String Description;
    private String rating;
    private String categorie;
    private String auteur ;
    private String image;

    public Histoire() {
    }

    public Histoire(String name, String description, String rating, String categorie, String auteur, String image) {
        this.name = name;
        Description = description;
        this.rating = rating;
        this.categorie = categorie;
        this.auteur = auteur;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public String getRating() {
        return rating;
    }


    public String getCategorie() {
        return categorie;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getImage() {
        return image;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }



    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setImage(String image) {
        this.image = image;
    }



}

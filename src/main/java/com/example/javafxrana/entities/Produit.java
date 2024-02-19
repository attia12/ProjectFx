package com.example.javafxrana.entities;

import javafx.beans.property.IntegerProperty;

public class Produit {
    private int ref_produit;
    private String nom;
    private String categorie;
    private float prix;
    private String description;
    private int qte;




    public Produit() {
    }

    public Produit(int ref_produit, String nom, String categorie, float prix, String description, int qte) {
        this.ref_produit = ref_produit;
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.description = description;
        this.qte = qte;
    }

    public Produit(String nom, String categorie, float prix, String description, int qte) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.description = description;
        this.qte = qte;
    }

    public int getRef_produit() {
        return ref_produit;
    }

    public void setRef_produit(int ref_produit) {
        this.ref_produit = ref_produit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "ref_produit=" + ref_produit +
                ", nom='" + nom + '\'' +
                ", categorie='" + categorie + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", qte=" + qte +
                '}';
    }
}

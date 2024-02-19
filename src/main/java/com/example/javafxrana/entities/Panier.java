package com.example.javafxrana.entities;

public class Panier {
    private int idPanier;
    private int qtePanier;
    private float somme;
    private Produit ref_produit;
    private User idUser;

    public Panier(int idPanier, int qtePanier, float somme, Produit ref_produit, User idUser) {
        this.idPanier = idPanier;
        this.qtePanier = qtePanier;
        this.somme = somme;
        this.ref_produit = ref_produit;
        this.idUser = idUser;
    }

    public Panier(int qtePanier, float somme, Produit ref_produit, User idUser) {
        this.qtePanier = qtePanier;
        this.somme = somme;
        this.ref_produit = ref_produit;
        this.idUser = idUser;
    }

    public Panier() {
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public int getQtePanier() {
        return qtePanier;
    }

    public void setQtePanier(int qtePanier) {
        this.qtePanier = qtePanier;
    }

    public float getSomme() {
        return somme;
    }

    public void setSomme(float somme) {
        this.somme = somme;
    }

    public Produit getRef_produit() {
        return ref_produit;
    }

    public void setRef_produit(Produit ref_produit) {
        this.ref_produit = ref_produit;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}

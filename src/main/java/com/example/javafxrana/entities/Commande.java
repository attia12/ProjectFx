package com.example.javafxrana.entities;

public class Commande {
    private int idCom;
    private float prixTotal;
    private String modePaiement;
    private Panier idPanier;

    public Commande(int idCom, float prixTotal, String modePaiement, Panier idPanier) {
        this.idCom = idCom;
        this.prixTotal = prixTotal;
        this.modePaiement = modePaiement;
        this.idPanier = idPanier;
    }

    public Commande(float prixTotal, String modePaiement, Panier idPanier) {
        this.prixTotal = prixTotal;
        this.modePaiement = modePaiement;
        this.idPanier = idPanier;
    }

    public Commande() {
    }

    public int getIdCom() {
        return idCom;
    }

    public void setIdCom(int idCom) {
        this.idCom = idCom;
    }

    public float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public Panier getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(Panier idPanier) {
        this.idPanier = idPanier;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "idCom=" + idCom +
                ", prixTotal=" + prixTotal +
                ", modePaiement='" + modePaiement + '\'' +
                '}';
    }

    public Commande(float prixTotal, String modePaiement) {
        this.prixTotal = prixTotal;
        this.modePaiement = modePaiement;
    }


}

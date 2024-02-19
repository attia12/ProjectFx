package com.example.javafxrana;

import com.example.javafxrana.entities.Categorie;
import com.example.javafxrana.entities.Produit;
import com.example.javafxrana.services.ProduitC;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class AjoutProduitController {
    public Produit li=new Produit();
    public JFXTextField nom;

    public JFXTextField prix;
    public JFXTextField qte;
    public JFXTextField description;
    public JFXButton add;
    public JFXButton Annuler;
    public JFXButton retour;
    public ProduitC pc=new ProduitC();
    public JFXTextField categorie;
    Produit prod = new Produit();

    public void AddProduct(ActionEvent actionEvent) {
        Produit P =new Produit();
        Boolean valid=true;
        nom.resetValidation();
        prix.resetValidation();
        qte.resetValidation();
        categorie.resetValidation();

        description.resetValidation();
        if(nom.getText().isEmpty()||prix.getText().isEmpty()||qte.getText().isEmpty()||categorie.getText().isEmpty()||description.getText().isEmpty())

        {
            nom.validate();prix.validate();qte.validate();categorie.validate();description.validate();
            valid=false;
        }
        else {
            if(!qte.getText().matches("^[1-9]\\d*$")){
                qte.validate();
                valid=false;

            }
            if(!prix.getText().matches("^[1-9]\\d+[.]?[\\d]*")){
                prix.validate();
                valid=false;

            }

        }
        if(add.getText()!="Modifier"&&valid) {

            Produit p = new Produit();
            p.setNom(nom.getText());
            p.setQte(Integer.parseInt(qte.getText()));
            p.setPrix(Float.parseFloat(prix.getText()));
//            Categorie c = categorie.getSelectionModel().getSelectedItem();
//            p.setCategorie(c.getId());
            p.setCategorie(categorie.getText());
            p.setDescription(description.getText());
            pc.ajouter(p);
            vider();
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);alert1.setHeaderText(null);
            alert1.setContentText("Product Ajouté avec réussite");
            alert1.showAndWait();

        } else if (add.getText()=="Modifier"&&valid) {
//            Categorie cat=Category.getSelectionModel().getSelectedItem();
            Produit updated=new Produit(this.li.getRef_produit(),nom.getText(),categorie.getText(),Float.parseFloat(prix.getText()),description.getText(),Integer.parseInt(qte.getText()));
            pc.modifier(updated);
            vider();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);alert.setHeaderText(null);
            alert.setContentText("produit Modifiée Avec réussite  ");alert.showAndWait();

        }
    }

    public void vider() {
        nom.clear();qte.clear();prix.clear();categorie.clear();description.clear();
        nom.resetValidation();
        prix.resetValidation();
        qte.resetValidation();
        description.resetValidation();
        categorie.resetValidation();
    }

    public void Retour(ActionEvent actionEvent) {
        retour.getScene().getWindow().hide();
    }

    public void setUpdate(String modifier) {
        add.setText(modifier.toString());
    }

    public void setcommd(Produit c) {
        this.li=c;
//        Categorie catego= new Categorie();
//        int ids=0,i=0;
//        // Category.setItems(catego.SelectCate(li.id_cat));
//        Category.setItems(catego.showCategorie());
//        ObservableList<Categorie> items = Category.getItems();
//        for(Categorie item: items){
//
//            if(item.getId()==li.id_cat){
//                ids=i;
//            }
//            i++;
//        }
//        Category.getSelectionModel().select(ids);//par defaut selectionner la ctaégorie trouveé
        //Category.setDisable(true); //!
        qte.setText(li.getQte()+"");
        prix.setText(li.getPrix()+"");
        nom.setText(li.getNom());
        categorie.setText(li.getCategorie());
        description.setText(li.getDescription());
    }

    public void setVisibilite(boolean b) {
        Annuler.setVisible(b);
    }
}

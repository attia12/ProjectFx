package com.example.javafxrana;

import com.example.javafxrana.entities.Commande;
import com.example.javafxrana.entities.Produit;
import com.example.javafxrana.services.CommandeC;
import com.example.javafxrana.services.ProduitC;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AjouterCommandeController {
    public JFXButton add;
    public JFXButton Annuler;
    public JFXButton retour;
    public JFXTextField prixTotal;
    public JFXTextField modePaiement;
    public ProduitC pc=new ProduitC();
    public CommandeC commandeC=new CommandeC();
    public Commande li=new Commande();

    public void AddCommand(ActionEvent actionEvent) {

        Commande C = new Commande();
        prixTotal.resetValidation();
        modePaiement.resetValidation();

        boolean v=true;
        if(prixTotal.getText().isEmpty()||modePaiement.getText().isEmpty()){
            v=false;
            modePaiement.validate();
            prixTotal.validate();
        }else{
            if (!prixTotal.getText().matches("^[1-9]\\d*$")) {
                prixTotal.validate();
                v=false;
            }
        }
        if(add.getText()!="Modifier"&& v){
//            Produit p =allproduit.getSelectionModel().getSelectedItem();

//            if(pc.SelectQunt(p.getId(),Integer.parseInt(.getText()))) {
               C.setPrixTotal(Float.parseFloat(prixTotal.getText()));
               C.setModePaiement(modePaiement.getText());
                commandeC.ajouter(C);
                vider();
                Annuler.setVisible(true);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Commande Ajouté avec réussite  ");
                alert.showAndWait();
//            }else {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setHeaderText(null);
//                alert.setContentText("Stock Epuisé ");
//                alert.showAndWait();
//            }

        }else if(add.getText()=="Modifier"&& v) {
//            Produit p =allproduit.getSelectionModel().getSelectedItem();
//            Client c =allClient.getSelectionModel().getSelectedItem();
//            if(p.SelectQunt(p.getId(),Integer.parseInt(quantity.getText()))) {
//                C.Upadate(this.li.id,Integer.parseInt(quantity.getText()),adresse.getText(),status.getValue(),datech.getValue().toString());
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);alert.setHeaderText(null);
//                alert.setContentText("Commande Modifieé avec réussite ");alert.showAndWait();}
//            else {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setHeaderText(null);
//                alert.setContentText("Stock Epuisé ");
//                alert.showAndWait();
//            }
        }
    }

    public void vider() {
        prixTotal.clear();
        modePaiement.clear();
        prixTotal.resetValidation();
        modePaiement.resetValidation();
    }

    public void Retour(ActionEvent actionEvent) {
        add.getScene().getWindow().hide();
    }

    public void SetVisibilite(boolean b) {
        Annuler.setVisible(b);
    }

    public void setcommd(Commande c1) {
        this.li=c1;



       prixTotal.setText(li.getPrixTotal()+"");
        modePaiement.setText(li.getModePaiement());


    }

    public void setUpdate(String modifier) {
        add.setText(modifier.toString());
    }
}

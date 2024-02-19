package com.example.javafxrana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Masterpage implements Initializable {
    

    public BorderPane Parent;
    public VBox nav;
    public Button produit;
    public Button Setting;
    public Button commande;
    public Text bon;
    public Button searchclient;
    Helper navl=new Helper();

   

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navl.NavRouter("Commande", Parent);
    }

    public void RecherClient(ActionEvent actionEvent) {
    }

    public void categorie(ActionEvent actionEvent) {
    }

    public void Produit(ActionEvent actionEvent) {
        navl.NavRouter("Produit", Parent);
    }

    public void Statistique(ActionEvent actionEvent) {
    }

    public void Info(ActionEvent actionEvent) {
    }

    public void Settings(ActionEvent actionEvent) {
    }

    public void Logout(ActionEvent actionEvent) {
    }

    public void Commande(ActionEvent actionEvent) {
        navl.NavRouter("Commande",Parent);
    }
}

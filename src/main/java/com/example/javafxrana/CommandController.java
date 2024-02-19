package com.example.javafxrana;

import com.example.javafxrana.entities.Commande;
import com.example.javafxrana.services.CommandeC;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class CommandController implements Initializable {
    public TableView tab_Commandes;
    public TableColumn id_commande;
    public TableColumn mode_paiement;
    public TableColumn prix_total;
    private Commande c =new Commande();
    public CommandeC commandeC=new CommandeC();


    public void searchB(ActionEvent actionEvent) {
    }

    public void Refresh(ActionEvent actionEvent) {
        tab_Commandes.setItems(commandeC.getAll());
        //Total.setText("Total Commandes : "+total(C.ShowAllcommand())+" DH");
        //search.clear();
    }

    public void newcommandes(ActionEvent actionEvent) throws IOException {
        Stage master=new Stage();
        FXMLLoader loder=new FXMLLoader();
        loder.setLocation(getClass().getResource("ajoutercommande.fxml"));
        loder.load();
        Parent root =loder.getRoot();
        Scene secene=new Scene(root, 800, 550);
        master.setTitle("Gestion Des Commandes");
        master.setScene(secene);
        master.setResizable(false);
        master.show();
    }

    public void modicomm(ActionEvent actionEvent) throws IOException {
        int cont=0;
        ArrayList<Commande> l=new ArrayList<>(tab_Commandes.getSelectionModel().getSelectedItems());
        for (Commande res : l) {
            cont++;
        }

        if(tab_Commandes.getSelectionModel().isEmpty()||cont>1){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);alert1.setHeaderText(null);
            alert1.setContentText("Veuillez Selectionner Une Commande a Modifier !!");
            alert1.showAndWait();
        }
        else{
            FXMLLoader loder=new FXMLLoader();
            Stage master=new Stage();
            loder.setLocation(getClass().getResource(  "ajoutercommande.fxml"));
            loder.load();
            Parent root =loder.getRoot();
            Scene secene=new Scene(root, 800, 550);
            master.setTitle("Modifier Commande");
            AjouterCommandeController m=loder.getController();
            Commande c1 = (Commande) tab_Commandes.getSelectionModel().getSelectedItem();
            c1=commandeC.getTbyId(c1.getIdCom());
            System.out.println(c1);
            m.setUpdate("Modifier");
            m.setcommd(c1);
            tab_Commandes.getSelectionModel().getSelectedItem();

            m.SetVisibilite(false);
            master.centerOnScreen();
            master.setResizable(false);
            master.show();
            master.setScene(secene);
        }
    }

    public void supcom(ActionEvent actionEvent) {
        if(tab_Commandes.getSelectionModel().isEmpty()){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);alert1.setHeaderText(null);
            alert1.setContentText("Veuillez Selectionner la Commande a supprimer !!");
            alert1.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Vous voullez Supprimer  ??");
            Optional<ButtonType> result = alert.showAndWait();
            Commande c1=new Commande();
            if (result.get() == ButtonType.OK) {
                ArrayList<Commande> l=new ArrayList<>(tab_Commandes.getSelectionModel().getSelectedItems());
                for (Commande res : l) {
                    commandeC.supprimer(res.getIdCom());
                }
                tab_Commandes.setItems(commandeC.getAll());
                //Total.setText("Total Commandes : "+total(C.ShowAllcommand())+" DH");


            }
        }
    }

    public void exportcsv(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tab_Commandes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        h.validator(search,"Veuillez Entrer Un Critère A Rechercher");
        id_commande.setCellValueFactory(new PropertyValueFactory<>("idCom"));
        prix_total.setCellValueFactory(new PropertyValueFactory<>("prixTotal"));
        mode_paiement.setCellValueFactory(new PropertyValueFactory<>("modePaiement"));

        try { tab_Commandes.setItems(commandeC.getAll());
           // Total.setText("Total Commandes : "+total(C.ShowAllcommand())+" DH");
        }
        catch (Exception ex){ System.out.println(ex.toString()); }
    }
//    private String total(ObservableList<Commande> list){
//        AtomicReference<Double> t= new AtomicReference<>(0.0);
//        list.forEach((tab) -> {
//            t.updateAndGet(v -> v + tab.getTotal());
//        });
//        return t+"";
//    }

    }



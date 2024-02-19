package com.example.javafxrana;

import com.example.javafxrana.entities.Produit;
import com.example.javafxrana.services.ProduitC;
import javafx.collections.FXCollections;
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

public class ProduitController implements Initializable {
    ProduitC prod = new ProduitC();
    private ObservableList<Produit> cartItems;
    public TableView Display;
    public TableColumn ID_Produit;
    public TableColumn Quantite;
    public TableColumn Categories;
    public TableColumn Prix;
    public TableColumn Description;
    public TableColumn Nom;
    public ObservableList<Produit> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ObservableList<Produit> cartItems) {
        this.cartItems = cartItems;
    }

    public void SearchMulti(ActionEvent actionEvent) {
    }

    public void Refresh(ActionEvent actionEvent) {
        Display.setItems(prod.getAll());
    }

    public void AddProd(ActionEvent actionEvent) throws IOException {
        Stage master=new Stage();
        FXMLLoader loder=new FXMLLoader();
        loder.setLocation(getClass().getResource("AjoutProduit.fxml"));
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
        ArrayList<Produit> l=new ArrayList<>(Display.getSelectionModel().getSelectedItems());
        for (Produit res : l) {
            cont++;
        }

        if(Display.getSelectionModel().isEmpty()|| cont>1){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);alert1.setHeaderText(null);
            alert1.setContentText("Veuillez Selectionner Un Produit a Modifier !!");
            alert1.showAndWait();
        }
        else {
            FXMLLoader loder=new FXMLLoader();
            Stage master=new Stage();
            loder.setLocation(getClass().getResource("AjoutProduit.fxml"));
            loder.load();
            Parent root =loder.getRoot();
            Scene secene=new Scene(root, 1150, 550);
            master.setTitle("Modifier Produit");
            AjoutProduitController m=loder.getController();
            Produit c1 = (Produit) Display.getSelectionModel().getSelectedItem();//Recuperer le produit selectionneé apartir tableview
            System.out.println(c1);
            c1=prod.getTbyId(c1.getRef_produit());//Recuperer l'Objet
            m.setUpdate("Modifier");//changement de button Enregister vers UPdate
            m.setcommd(c1);//passer l'objet trouvé vers la mehode setcommd
            m.setVisibilite(false);
            master.centerOnScreen();
            master.show();
            master.setResizable(false);
            master.setScene(secene);

        }
    }

    public void DeleteProduct(ActionEvent actionEvent) {


        if(Display.getSelectionModel().isEmpty()){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);alert1.setHeaderText(null);
            alert1.setContentText("Veuillez Selectionner le Produit a supprimer !!");
            alert1.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Vous voullez Supprimer  ??");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Produit P1 = new Produit();
                //Display.getSelectionModel().getSelectedItem();
                ArrayList<Produit> l=new ArrayList<>(Display.getSelectionModel().getSelectedItems());
                for (Produit res : l) {
                    prod.supprimer(res.getRef_produit());
                }
                Display.setItems(prod.getAll());
            }


        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Display.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ID_Produit.setCellValueFactory(new PropertyValueFactory<>("ref_produit"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Quantite.setCellValueFactory(new PropertyValueFactory<>("qte"));
        Categories.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        Prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
       Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        cartItems = FXCollections.observableArrayList();

        try { Display.setItems(prod.getAll()); }
        catch (Exception ex){ System.out.println(ex.toString()); }

    }

    public void panier(ActionEvent actionEvent) {
    }

    public void addToCart(ActionEvent actionEvent) throws IOException {
       Produit selectedProduct =(Produit) Display.getSelectionModel().getSelectedItem();
       System.out.println(selectedProduct);
       if(selectedProduct != null )
       {
           cartItems.add(selectedProduct);


           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setHeaderText(null);
           alert.setContentText("Product added to cart successfully!");
           alert.showAndWait();
           Stage master=new Stage();
           FXMLLoader loder=new FXMLLoader();
           loder.setLocation(getClass().getResource("Panier.fxml"));
           loder.load();
           PanierController panierController = loder.getController();
           panierController.updateCartItems(cartItems);



           Parent root =loder.getRoot();
           Scene secene=new Scene(root, 800, 550);
           master.setTitle("Panier");
           master.setScene(secene);
           master.setResizable(false);
           master.show();

           System.out.println(cartItems);

       }

       else {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText(null);
           alert.setContentText("Please select a product to add to cart.");
           alert.showAndWait();
       }


    }
}


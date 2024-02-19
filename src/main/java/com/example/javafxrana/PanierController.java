package com.example.javafxrana;

import com.example.javafxrana.entities.Panier;
import com.example.javafxrana.entities.Produit;
import com.example.javafxrana.services.PanierC;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAttribute;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class PanierController implements Initializable {


    public TableView cartTableView;
    public PanierC panierC=new PanierC();

    private JFXTextField quantityPanierTextField = new JFXTextField();


    private ObservableList<Produit> cartItems;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cartItems = FXCollections.observableArrayList();
        TableColumn<Produit, Void> quantityColumn = new TableColumn<>("QuantityPanier");
        quantityColumn.setCellFactory(col -> {
            TableCell<Produit, Void> cell = new TableCell<>() {
                private final JFXTextField textField = new JFXTextField();

                {
                    textField.setOnAction(event -> {
                        Produit produit = getTableView().getItems().get(getIndex());
                        produit.setQte(Integer.parseInt(quantityPanierTextField.getText()));

                    });
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        Produit produit = getTableView().getItems().get(getIndex());
                        quantityPanierTextField.setText(String.valueOf(produit.getQte()));
                        setGraphic(quantityPanierTextField);


                    }
                }
            };
            return cell;
        });
        cartTableView.getColumns().add(quantityColumn);

        cartTableView.setItems(cartItems);


    }

    public void updateCartItems(ObservableList<Produit> items) {

        cartItems.setAll(items);
    }

    public void removeItem(ActionEvent actionEvent) {
        Produit selctedtedItem=(Produit) cartTableView.getSelectionModel().getSelectedItem();
        if(selctedtedItem != null)
        {
            cartItems.remove(selctedtedItem);
        }
        else {
            
        }
    }

    public void AddPanier(ActionEvent actionEvent) {
        Panier panier = new Panier();

        String quantityPanierText = quantityPanierTextField.getText();
        Produit selectedProduit = (Produit) cartTableView.getSelectionModel().getSelectedItem();

        if (selectedProduit != null) { // Check if an item is selected
            if (!quantityPanierText.isEmpty()) {
                int quantityPanier = Integer.parseInt(quantityPanierText);
                panier.setQtePanier(quantityPanier);
                panier.setSomme(selectedProduit.getPrix() * quantityPanier);
                panier.setRef_produit(selectedProduit);
                panierC.ajouter(panier);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Panier added successfully!");
                alert.showAndWait();

                System.out.println("QuantityPanier: " + quantityPanier);
            } else {
                System.out.println("QuantityPanier is empty");
            }
        } else {
            System.out.println("No item selected");
        }


    }
}

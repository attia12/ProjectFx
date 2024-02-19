package com.example.javafxrana.services;


import com.example.javafxrana.entities.Commande;
import com.example.javafxrana.entities.Panier;
import com.example.javafxrana.entities.Produit;
import com.example.javafxrana.utils.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandeC implements IService<Commande>{
    public Connection cnx= MyConnection.getInstance().getCnx() ;
    @Override
    public void ajouter(Commande p) {
        try {
//            String req = "INSERT INTO `commande` ( `prixTotal`,`modePaiement`,`idPanier `) VALUES (?,?,?)";
            String req = "INSERT INTO `commande` ( `prixTotal`,`modePaiement`) VALUES (?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setFloat(1,p.getPrixTotal());
            ps.setString(2, p.getModePaiement());
           // ps.setInt(3,p.getIdPanier().getIdPanier());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `commande` WHERE idCom = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("commande deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifier(Commande p) {
        try {
            String req = "UPDATE `commande` SET `prixTotal` = '" + p.getPrixTotal() + "', `modePaiement` = '" + p.getModePaiement() + "',`idPanier `='"+ p.getIdPanier()+"' WHERE `commande`.`idCom` = " + p.getIdCom();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Commande updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public ObservableList<Commande> getAll() {
        PanierC panierC=new PanierC();
        ObservableList<Commande> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from commande";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Commande commande=new Commande();
                commande.setIdCom(rs.getInt("idCom"));

                commande.setPrixTotal(rs.getFloat("prixTotal"));
                commande.setModePaiement(rs.getString("modePaiement"));


                Panier panier=panierC.getTbyId(rs.getInt("idPanier"));

                commande.setIdPanier(panier);

                list.add(commande);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Commande getTbyId(int id) {
        try {
            String req = "Select * from commande where idCom = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Commande commande = new Commande();
                commande.setIdCom(rs.getInt("idCom"));
                commande.setModePaiement(rs.getString("modePaiement"));
                commande.setPrixTotal(rs.getFloat("prixTotal"));


                return commande;




            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
}

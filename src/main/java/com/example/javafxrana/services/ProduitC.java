package com.example.javafxrana.services;



import com.example.javafxrana.entities.Produit;
import com.example.javafxrana.utils.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitC implements IService<Produit>{
    public Connection cnx= MyConnection.getInstance().getCnx() ;
    @Override
    public void ajouter(Produit p) {
        try {
            String req = "INSERT INTO `produits` ( `nom`,`categorie`,`prix`,`description`,`qte`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,p.getNom());
            ps.setString(2,p.getCategorie());
            ps.setFloat(3,p.getPrix());
            ps.setString(4,p.getDescription());
            ps.setInt(5,p.getQte());



            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `produits` WHERE ref_produit = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("produit deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifier(Produit p) {
        try {
            String req = "UPDATE `produits` SET `nom` = '" + p.getNom() + "', `categorie` = '" + p.getCategorie() + "',`prix`='"+ p.getPrix() + "',`description`='"+ p.getDescription()+ "',`qte`='"+ p.getQte()+"' WHERE `produits`.`ref_produit` = " + p.getRef_produit();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Produit updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public ObservableList<Produit> getAll() {

        ObservableList<Produit> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from produits";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Produit p = new Produit(rs.getInt("ref_produit"), rs.getString("nom"), rs.getString("categorie"),rs.getFloat("prix"),rs.getString(5),rs.getInt(6));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Produit getTbyId(int id) {

        try {
            String req = "Select * from produits where ref_produit = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Produit produit = new Produit();
                produit.setRef_produit(rs.getInt("ref_produit"));
                produit.setNom(rs.getString("nom"));
               produit.setCategorie(rs.getString("categorie"));
                produit.setPrix(rs.getFloat("prix"));
                produit.setDescription(rs.getString("description"));
                produit.setQte(rs.getInt("qte"));

                return produit;




            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }





}

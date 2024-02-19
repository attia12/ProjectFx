package com.example.javafxrana.services;


import com.example.javafxrana.entities.Panier;
import com.example.javafxrana.utils.MyConnection;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PanierC implements IService<Panier>{
    public Connection cnx= MyConnection.getInstance().getCnx() ;
    @Override
    public void ajouter(Panier p) {
        try {
            String req = "INSERT INTO `panier` ( `qtePanier`,`somme`,`ref_produit`) VALUES (?,?,?)";
//            String req = "INSERT INTO `panier` ( `qtePanier`,`somme`,`ref_produit  `,`idUser`) VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,p.getQtePanier());
            ps.setFloat(2, p.getSomme());
            ps.setInt(3,p.getRef_produit().getRef_produit());
           // ps.setInt(4,p.getIdUser().getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `panier` WHERE idPanier = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("panier deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifier(Panier p) {

    }

    @Override
    public ObservableList<Panier> getAll() {
        return null;
    }

    @Override
    public Panier getTbyId(int id) {
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Employes;
import com.esprit.IService.IServiceEmployes;
import com.esprit.Utils.DataBase;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ferie
 */
public class ServiceEmployes implements IServiceEmployes<Employes> {

    private static ServiceEmployes instance;

    private Connection con;
    private Statement ste;

    public ServiceEmployes() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouter(Employes t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`employe` (`id_employe`,`nom_employe`,`prenom_employe`,`age_employe`,`role`, `salaire` ,`prime`,`nbr_heure`) VALUES (NULL, '" + t.getId_employe() + "', '" + t.getNom_employe() + "', '" + t.getPrenom_employe() + "' , '" + t.getAge_employe() + "', '" + t.getRole() + "','" + t.getSalaire() + "','" + t.getPrime() + "','" + t.getNbr_heure() + "');";
        try {
            ste.executeUpdate(requeteInsert);
            System.out.println("spons bien ajouter");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmployes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ajouter1(Employes e) throws SQLException {

        System.out.println("employé bien ajouter");
        PreparedStatement pre = con.prepareStatement("INSERT INTO `esprit`.`employe` (`id_employe`,`nom_employe`,`prenom_employe`,`age_employe`, `role`, `salaire`, `prime`,`nbr_heure`)  VALUES ( ?,?,?,?,?,?,?,?);");
        pre.setInt(1, e.getId_employe());
        pre.setString(2, e.getNom_employe());
        pre.setString(3, e.getPrenom_employe());
        pre.setInt(4, e.getAge_employe());
        pre.setString(5, e.getRole());
        pre.setFloat(6, e.getSalaire());
        pre.setFloat(7, e.getPrime());
        pre.setInt(8, e.getNbr_heure());

        pre.executeUpdate();
        // pre1.executeUpdate();
    }

    public void delete(Employes t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`employe` where (id_employe =" + t.getId_employe() + ");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";

        try {
            Statement stl = con.createStatement();
            int rs = stl.executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

    }

    public void update(Employes t) {
       String sql ="UPDATE `esprit`.`employe` SET `nom_employe`='"+t.getNom_employe() + "',`prenom_employe`='"+t.getPrenom_employe() + "' ,`age_employe`='"+t.getAge_employe() + "',`role`='"+t.getRole() + "',`salaire`='"+t.getSalaire() + "',`prime`='"+t.getPrime() + "',`nbr_heure`='"+t.getNbr_heure() + "'  WHERE `nom_employe`='"+t.getNom_employe()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }

    }

    public ObservableList<Employes> readAll() throws SQLException {
        // List<Employes> arr=new ArrayList<>();
        ObservableList<Employes> list = FXCollections.observableArrayList();

        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from employe");
        while (rs.next()) {
            int id_employe = rs.getInt(1);
            String nom_employe = rs.getString("nom_employe");
            String prenom_employe = rs.getString(3);
            int age_employe = rs.getInt("age_employe");
            String role = rs.getString("role");
            int salaire = rs.getInt("salaire");
            int prime = rs.getInt("prime");
            int nbr_heure = rs.getInt("nbr_heure");

            Employes e = new Employes(id_employe, nom_employe, prenom_employe, age_employe, role, salaire, prime, nbr_heure);
            list.add(e);
        }
        return list;
    }

    public static ServiceEmployes getInstance() {
        if (instance == null) {
            instance = new ServiceEmployes();
        }
        return instance;
    }

    public void update(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

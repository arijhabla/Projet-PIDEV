/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.Paiement;
import com.esprit.IService.IServicePaiement;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc
 */
public class ServicePaiement implements IServicePaiement<Paiement> {
    private Connection con;
    private Statement ste;

    public ServicePaiement() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Paiement t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`paiement` (`id_eleve`,`frais_scolarite`,`type_paiement`,`date_paiement`) VALUES ( '" + t.getId_eleve() + "', '" + t.getFrais_scolarite()+ "','" + t.getType_paiement() + "', '" + t.getDate_paiement()+ "');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Paiement e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`paiement` (`id_eleve`,`frais_scolaite`,`type_paiement`,`date_paiement`) VALUES (?,?,?,?);");
       pre.setInt(1, e.getId_eleve());
       pre.setInt(2,e.getFrais_scolarite());
       pre.setString(3, e.getType_paiement());
       pre.setDate(4,e.getDate_paiement());

   
    pre.executeUpdate();
    }
            


    public void delete(Paiement  t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`paiement` where (id_eleve ="+t.getId_eleve()+");";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(Paiement t) throws SQLException {
  
          String sql ="UPDATE `esprit`.`candidat` SET `id_eleve`='"+t.getId_eleve() + "',`frais_scolarite`='"+t.getFrais_scolarite() + "' ,`type_paiement`='"+t.getType_paiement() + "',`date_paiement`='"+t.getDate_paiement() + "'  WHERE `id_eleve`='"+t.getId_eleve()+"' ";
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    public List<Paiement> readAll() throws SQLException {
    List<Paiement> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from paiement");
     while (rs.next()) {                
               int id_eleve=rs.getInt(1);
               int frais_scolarite=rs.getInt(2);
               String type_paiement=rs.getString("type_paiement");
               Date date_paiement=rs.getDate(4);
           
             Paiement p=new Paiement(id_eleve,frais_scolarite,type_paiement,date_paiement);
     arr.add(p);
     }
    return arr;
    }
    
    
}

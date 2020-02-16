/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.Conge;
import com.esprit.Entite.Paiement;
import com.esprit.IService.IServiceConge;
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
public class ServiceConge {
    
    private Connection con;
    private Statement ste;

    public ServiceConge() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouter(Conge t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`conge` (`id_enseignant`,`date_debut`,`date_fin`) VALUES ( '" + t.getId_enseignant()+ "', '" + t.getDate_debut()+ "','" + t.getDate_fin() + "');";
        ste.executeUpdate(requeteInsert);
    }
    
    public void ajouter1(Conge c) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`conge` (`id_enseignant`,`date_debut`,`date_fin`) VALUES (?,?,?);");
       pre.setInt(1, c.getId_enseignant());
       pre.setDate(2,c.getDate_debut());
       pre.setDate(3, c.getDate_fin());
   
    pre.executeUpdate();
    }
            


    public void delete(Conge t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`conge` where (id_enseignant ="+t.getId_enseignant()+");";
  
    try {
            Statement stl = con.createStatement();
            int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(Conge t) throws SQLException {
  
          String sql ="UPDATE `esprit`.`conge` SET `id_enseignant`='"+t.getId_enseignant()+ "',`date_debut`='"+t.getDate_debut()+ "' ,`date_fin`='"+t.getDate_fin() + "'  WHERE `id_enseignant`='"+t.getId_enseignant()+"' ";
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    public List<Conge> readAll() throws SQLException {
    List<Conge> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from conge");
     while (rs.next()) {                
               int id_enseignant =rs.getInt(1);
               Date date_debut=rs.getDate(2);
               Date date_fin=rs.getDate(3);
           
             Conge c =new Conge(id_enseignant,date_debut,date_fin);
     arr.add(c);
     }
    return arr;
    }
    
    
    
}

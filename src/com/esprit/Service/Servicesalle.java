/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.salle;
import com.esprit.IService.IServicesalle;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dell
 */
public class Servicesalle {
   private static Servicesalle instance;
    private Connection con;
    private Statement ste;

    public Servicesalle() {
        con = DataBase.getInstance().getConnection();

    }

    
    public void ajouter(salle t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`salle` (`id_salle`,`capacite`) VALUES ( '" + t.getId_salle() + "', '" + t.getCapacite() + "');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(salle e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`salle` (`id_salle`,`capacite`) VALUES ( ?, ?);");
   pre.setInt(1, e.getId_salle());
       pre.setInt(2,e.getCapacite());
   

   
    pre.executeUpdate();
    }
            


    public void delete(salle  t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`salle` where (id_salle ="+t.getId_salle()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(salle t) throws SQLException {
          String sql ="UPDATE `esprit`.`salle` SET `id_salle`='"+t.getId_salle() + "',`capacite`='"+t.getCapacite() + "'  WHERE `id_salle`='"+t.getId_salle()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    public List<salle> readAll() throws SQLException {
    List<salle> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from salle");
     while (rs.next()) {                
               int id_salle=rs.getInt(1);
             int capacite=rs.getInt("capacite");
             
           
             salle c=new salle(id_salle,capacite);
     arr.add(c);
     }
    return arr;
    }
     public static Servicesalle getInstance(){
        if (instance==null)
            instance=new Servicesalle();
        return instance;
    }
      
}

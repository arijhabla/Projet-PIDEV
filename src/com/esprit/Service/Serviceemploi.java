/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;

import com.esprit.Entite.emploidutemps;
import com.esprit.IService.IServiceEmploidutemps;
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
public class Serviceemploi implements IServiceEmploidutemps<emploidutemps>{
    private static Serviceemploi instance; 
    private Connection con;
    private Statement ste;

    public Serviceemploi() {
        con = DataBase.getInstance().getConnection();

    }

  
    public void ajouter(emploidutemps t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`emploidutemps` (`id_emploi`,`nom_emp`) VALUES ( '" + t.getId_emploi() +"','" + t.getNom_emp() +"');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(emploidutemps e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`emploidutemps` (`id_emploi`,`nom_emp`) VALUES ( ?, ?);");
   pre.setInt(1, e.getId_emploi());
   pre.setString(2,e.getNom_emp());  
   

   
    pre.executeUpdate();
    }
            


    public void delete(emploidutemps  t) throws SQLException {
           String sql = "DELETE FROM `esprit`.`emploidutemps` where (id_emploi ="+t.getId_emploi()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(emploidutemps t) throws SQLException {
          String sql ="UPDATE `esprit`.`emploidutemps` SET `id_emploi`='"+t.getId_emploi() + "',`nom_emp`='"+t.getNom_emp() + "'  WHERE `id_emploi`='"+t.getId_emploi()+"' ";
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    public List<emploidutemps> readAll() throws SQLException {
    List<emploidutemps> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from emploidutemps");
     while (rs.next()) {                
               int id_emploi=rs.getInt(1);
               String nom_emp=rs.getString("nom_emp");
            
             
           
            emploidutemps e=new emploidutemps(id_emploi, nom_emp);
     arr.add(e);
     }
    return arr;
    }
     public static Serviceemploi getInstance(){
        if (instance==null)
            instance=new Serviceemploi();
        return instance;
    }
    
}

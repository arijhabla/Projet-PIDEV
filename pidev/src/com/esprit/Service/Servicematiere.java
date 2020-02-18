/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.matiere;
import com.esprit.IService.IServicematiere;
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
public class Servicematiere implements IServicematiere<matiere> {
private static Servicematiere instance;
    private Connection con;
    private Statement ste;

    public Servicematiere() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(matiere t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`matiere` (`id_matiere`,`nom_matiere`,`nbr_heures`) VALUES ( '" + t.getId_matière() + "', '" + t.getNom_matière() + "', '"+t.getNbr_heures()+"');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(matiere m) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`matiere` (`id_matiere`,`nom_matiere`,`nbr_heures`) VALUES ( ?, ?, ?);");
   pre.setInt(1, m.getId_matière());
       pre.setString(2,m.getNom_matière());
        pre.setInt(3, m.getNbr_heures());
   

   
    pre.executeUpdate();
    }
            


    public void delete(matiere  t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`matiere` where (id_matiere ="+t.getId_matière()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(matiere t) throws SQLException {
          String sql ="UPDATE `esprit`.`matiere` SET `id_matiere`='"+t.getId_matière() + "',`nom_matiere`='"+t.getNom_matière() +"', `nbr_heures`='"+t.getNbr_heures() + "'  WHERE `id_matiere`='"+t.getId_matière()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    public List<matiere> readAll() throws SQLException {
    List<matiere> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from matiere");
     while (rs.next()) {                
               int id_matiere=rs.getInt(1);
             String nom_matiere=rs.getString("nom_matiere");
             int nbr_heures=rs.getInt(3);
             
           
             matiere m=new matiere(id_matiere, "nom_matiere", nbr_heures);
     arr.add(m);
     }
    return arr;
    }
     public static Servicematiere getInstance(){
        if (instance==null)
            instance=new Servicematiere();
        return instance;
    }
       
}

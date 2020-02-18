/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.Conge;
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
 * @author ferie
 */
public class ServiceConge implements IServiceConge<Conge> {

    private Connection con;
    private Statement ste;

    public ServiceConge() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Conge t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`conge` (`id_Conge`,`Date_Debut_Conge`,`Date_Fin_Conge`) VALUES ( Null,'" + t.getDate_Debut_Conge() + "', '" + t.getDate_Fin_Conge() + "' );";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Conge e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`conge` (`id_Conge`,`Date_Debut_Conge`,`Date_Fin_Conge`) VALUES ( ?, ?, ?);");
   pre.setInt(1, e.getId_conge());
     
       pre.setDate(2,e.getDate_Debut_Conge());
    pre.setDate(3, e.getDate_Fin_Conge());
  

   
    pre.executeUpdate();
    }
            


    public void delete(Conge t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`conge` where (id_Conge ="+t.getId_conge()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(Conge t) throws SQLException {
          String sql ="UPDATE `esprit`.`conge` SET `id_Conge`='"+t.getId_conge() + "' ,`Date_Debut_Conge`='"+t.getDate_Debut_Conge() + "',`Date_Fin_Conge`='"+t.getDate_Fin_Conge() + "'  WHERE `id_Conge`='"+t.getId_conge()+"' ";
  
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
               int id_Conge=rs.getInt(1);
             
              Date Date_Debut_Conge=rs.getDate("Date_Debut_Conge");
                     Date Date_Fin_Conge=rs.getDate("Date_Fin_Conge");
           
             Conge co=new Conge(id_Conge,Date_Debut_Conge,Date_Fin_Conge);
     arr.add(co);
     }
    return arr;
    }
}

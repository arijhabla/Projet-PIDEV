/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;
import com.esprit.Entite.Absence;
import com.esprit.Entite.Inscription;
import com.esprit.IService.IServiceAbsence;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author arij_
 */

    public class ServiceAbsence implements IServiceAbsence<Absence> {

    private Connection con;
    private Statement ste;

    public ServiceAbsence() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Absence e) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`absence` (`id_absence`,`date_absence`,`id_matiere`,`id_eleve`) VALUES ( '" + e.getid_absence() + "', '" + e.getdate_absence() + "', '" + e.getid_matiere() + "' , '" + e.getid_eleve() + "'');" ;
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Absence e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`absence` (`id_absence`,`date_absence`,`id_matiere`,`id_eleve`) VALUES ( ?, ?, ?,?);");
   pre.setInt(1, e.getid_absence());
       pre.setDate(2,e.getdate_absence());
    pre.setInt(3, e.getid_matiere());
    pre.setInt(4, e.getid_eleve());


   
    pre.executeUpdate();
    }
            
    /**
     *
     * @param e
     */
    @Override
    public void delete(Absence e) {
        String sql = "DELETE FROM `esprit`.`absence` where (id_absence ="+e.getid_absence()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    @Override
    public void update(Absence t) throws SQLException {
          String sql ="UPDATE `esprit`.`absence` SET `id_absence`='"+t.getid_absence() + "',`date_absence`='"+t.getdate_absence() + "' ,`id_matiere`='"+t.getid_matiere() + "',`id_eleve`='"+t.getid_eleve()+ "'";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    @Override
    public List<Absence> readAll() throws SQLException {
    List<Absence> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from absence");
     while (rs.next()) {                
               int id_absence=rs.getInt(1);
             Date date_absence=rs.getDate("date_absence");
               int id_matiere=rs.getInt("id_matiere");
                     int id_eleve=rs.getInt("id_eleve");
           
             Absence e=new Absence(id_absence,date_absence,id_matiere,id_eleve);
     arr.add(e);
     }
    return arr;
    }

 
}

    
    
    
    
    



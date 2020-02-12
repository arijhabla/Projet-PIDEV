/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.Inscription;
import com.esprit.IService.IServiceInscription;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author arij
 */

    public class ServiceInscription implements IServiceInscription<Inscription> {

    private Connection con;
    private Statement ste;

    public ServiceInscription() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Inscription i) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`inscription` (`id_inscription`,`date_inscription`,`id_classe`,`id_eleve`) VALUES ( '" + i.getid_inscription()+ "', '" + i.getdate_inscription() + "', '" + i.getid_classe()+ "' , '" + i.getid_eleve() + "');" ;
        ste.executeUpdate(requeteInsert);
    }
       public void ajouter1(Inscription i) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`inscription` (`id_inscription`,`date_inscription`,`id_classe`,`id_eleve`) VALUES ( ?, ?, ?,?);");
   pre.setInt(1, i.getid_inscription());
       pre.setDate(2,i.getdate_inscription());
    pre.setInt(3, i.getid_classe());
    pre.setInt(4, i.getid_eleve());


   
    pre.executeUpdate();
    }
            
    /**
     *
     * @param i
     */
    @Override
    public void delete(Inscription i) {
        String sql = "DELETE FROM `esprit`.`inscription` where (id_inscription ="+i.getid_inscription()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    @Override
    public void update(Inscription t) throws SQLException {
          String sql ="UPDATE `esprit`.`inscription` SET `id_inscription`='"+t.getid_inscription() + "',`date_inscription`='"+t.getdate_inscription() + "' ,`id_classe`='"+t.getid_classe() + "',`id_eleve`='"+t.getid_eleve()+ "'";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    @Override
    public List<Inscription> readAll() throws SQLException {
    List<Inscription> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from inscription");
     while (rs.next()) {                
               int id_inscription=rs.getInt(1);
             Date date_inscription=rs.getDate("date_inscription");
               int id_classe=rs.getInt("id_classe");
                     int id_eleve=rs.getInt("id_eleve");
           
            Inscription e=new Inscription(id_inscription,date_inscription,id_classe,id_eleve);
     arr.add(e);
     }
    return arr;
    }
}

    
    
    
    
    



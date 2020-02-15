/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */

package com.esprit.Service;
import com.esprit.entite.Club;
import com.esprit.IService.IServiceClub;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.Database;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

 //* @author Khadija

    public class ServiceClub implements IServiceClub<Club> {

    private Connection con;
    private Statement ste;

    public ServiceClub() {
        con = Database.getInstance().getConnection();

    }

    @Override
    public void ajouter(Club t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`club` (`id_club`,`nom_club`,`type_club`) VALUES ( '" + t.getId_club() + "', '" + t.getNom_club() + "', '" + t.getType_club() + "');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Club e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`club` (`id_club`,`nom_club`,`type_club`) VALUES ( ?, ?, ?);");
   pre.setInt(1, e.getId_club());
       pre.setString(2,e.getNom_club());
    pre.setString(3, e.getType_club());
   
   
    pre.executeUpdate();
    }
            


    public void delete(Club  t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`Club` where (id_club ="+t.getId_club()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(Club t) throws SQLException {
          String sql ="UPDATE `esprit`.`Club` SET `id_club`='"+t.getId_club() + "',`nom_club`='"+t.getNom_club() + "' ,`type_club`='"+t.getType_club() + "'  WHERE `id_club`='"+t.getId_club()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    public List<Club> readAll() throws SQLException {
    List<Club> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from Club");
     while (rs.next()) {                
               int id_club=rs.getInt(1);
               String nom_club=rs.getString("nom_club");
               String type_club=rs.getString(3);
               
           
             Club c=new Club(id_club,nom_club,type_club);
     arr.add(c);
     }
    return arr;
    }
    public Club rechercheClubpartype(String type_club)
 {  Club S = new Club();
 
           try {
            
                 String req4="SELECT * FROM esprit.`club` WHERE type_club='" + type_club + "';";
          Statement st = con.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
              
             S.setId_club(rs.getInt("id_club"));
                    S.setNom_club(rs.getString("nom_club"));
                    S.setType_club(rs.getString("type_club"));
                   
                 
               
               
         
               
            }
           
            return S;
        
        } catch (SQLException ex) {
            Logger.getLogger(ServiceClub.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
 }
}

    
    
    
    
    
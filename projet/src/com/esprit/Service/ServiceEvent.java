/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.entite.Event;
import com.esprit.IService.IServiceEvent;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.Database;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khadija
 */
public class ServiceEvent implements IServiceEvent<Event>{
     private Connection con;
    private Statement ste;

    public ServiceEvent() {
        con = Database.getInstance().getConnection();

    }

    @Override
    public void ajouter(Event t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`event` (`id_event`,`nom_event`,`date_event`) VALUES ( '" + t.getId_event() + "', '" + t.getNom_event() + "', '" + t.getDate_event() + "');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Event e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`event` (`id_event`,`nom_event`,`date_event`) VALUES ( ?, ?, ?);");
   pre.setInt(1, e.getId_event());
       pre.setString(2,e.getNom_event());
    pre.setDate(3, e.getDate_event());
   
   
    pre.executeUpdate();
    }
            


    public void delete(Event  t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`event` where (id_event ="+t.getId_event()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(Event t) throws SQLException {
          String sql ="UPDATE `esprit`.`event` SET `id_event`='"+t.getId_event() + "',`nom_event`='"+t.getNom_event() + "' ,`date_event`='"+t.getDate_event() + "'  WHERE `id_event`='"+t.getId_event()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    public List<Event> readAll() throws SQLException {
    List<Event> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from event");
     while (rs.next()) {                
               int id_event=rs.getInt(1);
               String nom_event=rs.getString("nom_event");
               Date date_event=rs.getDate("date_event");
               
           
             Event c=new Event(id_event,nom_event,date_event);
            
     arr.add(c);
     }
    return arr;
    }
    
}

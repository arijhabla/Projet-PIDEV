/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.Comptable;
import com.esprit.Entite.Conge;
import com.esprit.IService.IServiceComptable;
import com.esprit.IService.IServiceConge;
import com.esprit.Utils.DataBase;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
/**
 *
 * @author Pc
 */
public class ServiceConge implements IServiceConge<Conge> {
    private static ServiceConge instance;
    
    private Connection con;
    private Statement ste;

    public ServiceConge() {
        con = DataBase.getInstance().getConnection();
    }

    public void ajouter(Conge t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`conge` (`id_enseignant`,`Date_Debut_Conge`,`Date_Fin_Conge`) VALUES ( '" + t.getId_enseignant()+ "', '" + t.getDate_Debut_Conge()+ "', '" + t.getDate_Fin_Conge()+ "');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Conge e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`conge` (`id_enseignant`,`Date_Debut_Conge`,`Date_Fin_Conge`) VALUES (?,?,?);");
       pre.setInt(1, e.getId_enseignant());
       pre.setDate(2,e.getDate_Debut_Conge());
       pre.setDate(3, e.getDate_Fin_Conge());

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
          String sql ="UPDATE `esprit`.`conge` SET `Date_Debut_Conge`='"+t.getDate_Debut_Conge()+ "' ,`Date_Fin_Conge`='"+t.getDate_Fin_Conge()+ "' WHERE `id_enseignant`='"+t.getId_enseignant()+"' ";
  
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
               int id_enseignant=rs.getInt(1);
               Date Date_Debut_Conge=rs.getDate("Date_Debut_Conge");
               Date Date_Fin_Conge=rs.getDate("Date_Fin_Conge");
           
             Conge c=new Conge(id_enseignant,Date_Debut_Conge,Date_Fin_Conge);
     arr.add(c);
     }
    return arr;
    }
 
public static ServiceConge getInstance(){
        if(instance==null) 
        instance=new ServiceConge();
        return instance;
    }
public ObservableList<Conge> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Conge getcon(int ID) throws SQLException {
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from conge where `id_enseignant`='"+ID + "'");
    
   while(rs.next())
   {
       Conge C = new Conge();
       C.setDate_Debut_Conge(rs.getDate("Date_Debut_Conge"));
       C.setDate_Fin_Conge(rs.getDate("Date_Fin_Conge"));
   }
   return null ;
    }


    
    
}

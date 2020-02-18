/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.Comptable;
import com.esprit.IService.IServiceComptable;
import com.esprit.Utils.DataBase;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
/**
 *
 * @author ferie
 */

    public class ServiceComptable implements IServiceComptable<Comptable> {

    private static ServiceComptable instance;
    
    private Connection con;
    private Statement ste;

    public ServiceComptable() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Comptable t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`comptable` (`ID_comptable`,`nom_comptable`,`prenom_comptable`,`etat_comptable`, `telephone_comptable`, `adressemail_comptable`) VALUES ( '" + t.getID_comptable()+ "', '" + t.getNom_comptable()+ "', '" + t.getPrenom_comptable()+ "' , '" + t.getEtat_comptable()+ "', '" + t.getTelephone_comptable()+ "', '" + t.getAdressemail_comptable()+ "');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Comptable e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`comptable` (`ID_comptable`,`nom_comptable`,`prenom_comptable`,`etat_comptable`, `telephone_comptable`, `adressemail_comptable`) VALUES (?,?,?,?,?,?);");
       pre.setInt(1, e.getID_comptable());
       pre.setString(2,e.getNom_comptable());
       pre.setString(3, e.getPrenom_comptable());
       pre.setString(4, e.getEtat_comptable());
       pre.setInt(5, e.getTelephone_comptable());   
       pre.setString(6, e.getAdressemail_comptable());

   
    pre.executeUpdate();
    }
            


    public void delete(Comptable t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`comptable` where (ID_comptable ="+t.getID_comptable()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(Comptable t) throws SQLException {
          String sql ="UPDATE `esprit`.`comptable` SET `nom_comptable`='"+t.getNom_comptable()+ "' ,`prenom_comptable`='"+t.getPrenom_comptable()+ "',`etat_comptable`='"+t.getEtat_comptable()+ "',`telephone_comptable`='" +t.getTelephone_comptable()+ "',`adressemail_comptable`='"+t.getAdressemail_comptable()+ "'  WHERE `ID_comptable`='"+t.getID_comptable()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    public List<Comptable> readAll() throws SQLException {
    List<Comptable> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from comptable");
     while (rs.next()) {                
               int ID_comptable=rs.getInt(1);
               String nom_comptable=rs.getString("nom_comptable");
               String prenom_comptable=rs.getString("prenom_comptable");
               String etat_comptable=rs.getString("etat_comptable");
               int telephone_comptable=rs.getInt(5);     
               String adressemail_comptable=rs.getString("adressemail_comptable");
           
             Comptable c=new Comptable(ID_comptable,nom_comptable,prenom_comptable,etat_comptable,telephone_comptable,adressemail_comptable);
     arr.add(c);
     }
    return arr;
    }
 
public static ServiceComptable getInstance(){
        if(instance==null) 
        instance=new ServiceComptable();
        return instance;
    }
public ObservableList<Comptable> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comptable getcomp(int ID) throws SQLException {
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from comptable where `ID_comptable`='"+ID + "'");
    
   while(rs.next())
   {
       Comptable C = new Comptable();
       C.setNom_comptable(rs.getString("nom_comptable"));
       C.setPrenom_comptable(rs.getString("prenom_comptable"));
       C.setEtat_comptable(rs.getString(rs.getString("etat_comptable")));
       C.setAdressemail_comptable(rs.getString(rs.getString("adressemail_comptable")));
       C.setTelephone_comptable(rs.getInt("telephone_comptable"));
       return C ; 
   }
   return null ;
    }


}

    
    
    
    
    


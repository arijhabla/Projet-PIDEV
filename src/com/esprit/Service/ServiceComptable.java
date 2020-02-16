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
/**
 *
 * @author Pc
 */
public class ServiceComptable implements IServiceComptable<Comptable>{
    private Connection con;
    private Statement ste;

    public ServiceComptable() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouter(Comptable t) throws SQLException {
        ste = con.createStatement(); 
        String requeteInsert = "INSERT INTO `esprit`.`comptable` (`ID_comptable`,`nom_comptable`,`prenom_comptable`,`etat_comptable`,`date_embauche_comptable`,`telephone_comptable`,`adressemail_comptable`) VALUES ( '" + t.getID_comptable()+ "', '" + t.getNom_comptable()+ "','" + t.getPrenom_comptable()+ "', '" + t.getEtat_comptable()+ "', '" + t.getDate_embauche_comptable()+ "', '" + t.getTelephone_comptable()+ "', '" + t.getAdressemail_comptable()+ "');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Comptable c) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`comptable` (`ID_comptable`,`nom_comptable`,`prenom_comptable`,`etat_comptable`,`date_embauche_comptable`,`telephone_comptable`,`adressemail_comptable`) VALUES (?,?,?,?,?,?,?);");
       pre.setInt(1, c.getID_comptable());
       pre.setString(2,c.getNom_comptable());
       pre.setString(3, c.getPrenom_comptable());
       pre.setString(4,c.getEtat_comptable());
       pre.setDate(5,c.getDate_embauche_comptable());
       pre.setInt(6, c.getTelephone_comptable());
       pre.setString(7,c.getAdressemail_comptable());

   
    pre.executeUpdate();
    }
            


    public void delete(Comptable  c) throws SQLException {
        String sql = "DELETE FROM `esprit`.`comptable` where ( ID_comptable="+c.getID_comptable()+");";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(Comptable  c) throws SQLException {
  
          String sql ="UPDATE `esprit`.`comptable` SET `ID_comptable`='"+c.getID_comptable()+ "',`nom_comptable`='"+c.getNom_comptable()+ "' ,`prenom_comptable`='"+c.getPrenom_comptable()+ "',`etat_comptable`='"+c.getEtat_comptable()+ "',`date_embauche_comptable`='"+c.getDate_embauche_comptable()+ "',`telephone_comptable`='"+c.getTelephone_comptable()+ "' ,`adressemail_comptable`='"+c.getAdressemail_comptable()+ "' WHERE `ID_comptable`='"+c.getID_comptable()+"' ";
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
               Date date_embauche_comptable=rs.getDate(5);
               int telephone_comptable=rs.getInt(6);
               String adressemail_comptable=rs.getString("adressemail_comptable");
           
             Comptable c=new Comptable(ID_comptable,nom_comptable,prenom_comptable,etat_comptable,date_embauche_comptable,telephone_comptable,adressemail_comptable);
     arr.add(c);
     }
    return arr;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;

import com.esprit.Entite.Comptable;
import com.esprit.Entite.Paiement;
import com.esprit.IService.IServiceComptable;
import com.esprit.IService.IServicePaiement;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Pc
 */
public class ServicePaiement implements IServicePaiement<Paiement> {

    
    private static ServicePaiement instance;
    
    private Connection con;
    private Statement ste;

    public ServicePaiement() {
        con = DataBase.getInstance().getConnection();
    }
 
    @Override
    public void ajouter(Paiement t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`paiement` (`id_paiement`, `type_paiement`, `montant`) VALUES ( '" + t.getId_paiement()+ "', '" + t.getType_paiement()+ "', '" + t.getMontant()+ "');";
        ste.executeUpdate(requeteInsert);
        
    }
        public void ajouter1(Paiement e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`paiement` (`id_paiement`,`type_paiement`,`montant`) VALUES (?,?,?);");
       pre.setInt(1, e.getId_paiement());
       pre.setString(2,e.getType_paiement());
       pre.setInt(3, e.getMontant());   

   
    pre.executeUpdate();
    }
           

    @Override
    public void delete(Paiement t) throws SQLException {
                String sql = "DELETE FROM `esprit`.`paiement` where (id_paiement ="+t.getId_paiement()+");";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    }

    @Override
    public void update(Paiement t) throws SQLException {
                 String sql ="UPDATE `esprit`.`paiement` SET `type_paiement`='"+t.getType_paiement()+ "' ,`montant`='"+t.getMontant()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    }

    @Override
    public List<Paiement> readAll() throws SQLException {
            List<Paiement> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from paiement");
     while (rs.next()) {                
               int id_paiement=rs.getInt(1);
               String type_paiement=rs.getString("type_paiement");
               int montant=rs.getInt(3);     
           
             Paiement c=new Paiement(id_paiement,type_paiement,montant);
     arr.add(c);
     }
    return arr;
    }
    
    public static ServicePaiement getInstance(){
        if(instance==null) 
        instance=new ServicePaiement();
        return instance;
    }
public ObservableList<Comptable> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paiement getpa(int ID) throws SQLException {
       ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from paiement where `id_paiement`='"+ID + "'");
    
   while(rs.next())
   {
       Paiement P = new Paiement();
       P.setType_paiement(rs.getString("type_paiement"));
       P.setMontant(rs.getInt("montant"));
       return P; 
   }
   return null ;
    }

    }
    


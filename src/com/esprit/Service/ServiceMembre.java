/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.entite.Membre;
import com.esprit.IService.IServiceMembre;
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
public class ServiceMembre implements IServiceMembre<Membre>{
    
          private static ServiceMembre instance;
     public static ServiceMembre getInstance(){
        if(instance==null) 
            instance=new ServiceMembre();
        return instance;
    }

   /* public static ServiceMembre getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
     private Connection con;
    private Statement ste;

    public ServiceMembre() {
        con = Database.getInstance().getConnection();

    }

    @Override
    public void ajouter(Membre t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`membre` (`id_membre`,`nom_membre`,`prenom_membre`,`age_membre`) VALUES ( '" + t.getId_membre() + "', '" + t.getNom_membre() + "', '" + t.getPrenom_membre() + "','" + t.getAge_membre() + "');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Membre e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`membre` (`id_membre`,`nom_membre`,`prenom_membre`,`age_membre`) VALUES ( ?, ?, ?, ?);");
   pre.setInt(1, e.getId_membre());
       pre.setString(2,e.getNom_membre());
        pre.setString(3,e.getPrenom_membre());
    pre.setInt(4, e.getAge_membre());
   
   
    pre.executeUpdate();
    }
            

public List<Membre> Triparnom() throws SQLException{
          List<Membre>lst= new ArrayList<>();
          
          try{
    String req="SELECT * FROM esprit.`membre` ORDER BY nom_membre";
     
          Statement st = con.createStatement();
            st.executeQuery(req);
            ResultSet rs = st.executeQuery(req);
           while(rs.next()){
                int id_membre=rs.getInt(1);
               String nom_membre=rs.getString("nom_membre");
                String prenom_membre=rs.getString("prenom_membre");
               int age_membre=rs.getInt(4);
            lst.add(new Membre(id_membre,nom_membre,prenom_membre,age_membre));
          }
                return lst;
        
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMembre.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
        }
    public void delete(Membre  t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`membre` where (id_membre ="+t.getId_membre()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(Membre t) throws SQLException {
          String sql ="UPDATE `esprit`.`membre` SET `id_membre`='"+t.getId_membre() + "',`nom_membre`='"+t.getNom_membre() + "' ,`prenom_membre`='"+t.getPrenom_membre() + "',`age_membre`='"+t.getAge_membre() + "'  WHERE `id_membre`='"+t.getId_membre()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    public List<Membre> readAll() throws SQLException {
    List<Membre> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from membre");
     while (rs.next()) {                
               int id_membre=rs.getInt(1);
               String nom_membre=rs.getString("nom_membre");
                String prenom_membre=rs.getString("prenom_membre");
               int age_membre=rs.getInt(4);
               
           
             Membre c=new Membre(id_membre,nom_membre,prenom_membre,age_membre);
            
     arr.add(c);
     }
    return arr;
    }
    
    
}

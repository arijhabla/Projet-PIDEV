/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.Candidat;
import com.esprit.IService.IServiceCandidat;
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

    public class ServiceCandidat implements IServiceCandidat<Candidat> {
     private static  ServiceCandidat instance;

    private Connection con;
    private Statement ste;

    public ServiceCandidat() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Candidat t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`candidat` (`cin_Candidat`,`prenom_Candidat`,`nom_Candidat`,`age_Candidat`, `experience_Candidat`) VALUES ( '" + t.getCin_Candidat() + "', '" + t.getPrenom_Candidat() + "', '" + t.getNom_Candidat() + "' , '" + t.getAge_Candidat() + "', '" + t.getExperience_Candidat() + "');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Candidat e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`candidat` (`cin_Candidat`,`prenom_Candidat`,`nom_Candidat`,`age_Candidat`, `experience_Candidat`) VALUES ( ?, ?, ?,?,?);");
   pre.setInt(1, e.getCin_Candidat());
       pre.setString(2,e.getPrenom_Candidat());
    pre.setString(3, e.getNom_Candidat());
    pre.setInt(4, e.getAge_Candidat());
       pre.setString(5, e.getExperience_Candidat());

   
    pre.executeUpdate();
    }
        
    /*  public Candidat rechercheArtisteParUsername(String nom) {
Candidat a = new Candidat();
        

            String sql = "SELECT * FROM candidat  WHERE prenom like '%prenom_Candidat%' and nom_Candidat='" + nom+ "';";

            try {
                Statement stl = con.createStatement();
                ResultSet rs = stl.executeQuery(sql);

                while (rs.next()) {
                    a.setCin_Candidat(rs.getInt("cin_Candidat"));
                    a.setNom_Candidat(rs.getString("nom_Candidat"));
                    a.setPrenom_Candidat(rs.getString("prenom_Candidat"));
                    a.setAge(rs.getInt("age_Candidat"));
                  a.setExperience_Candidat(rs.getString("experience_Candidat"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(ServiceCandidat.class.getNom_Candidat()).log(Level.SEVERE, null, ex);
            }
        return a;     }

*/
    public Candidat rechercheCandidatParCin(int cin_Candidat)
 {  Candidat S = new Candidat();
        

            

           try {
            
                 String req4="SELECT * FROM `esprit`.`candidat` WHERE cin_Candidat='" + cin_Candidat + "';";
          Statement st = con.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
              
             S.setCin_Candidat(rs.getInt("cin_Candidat"));
                    S.setNom_Candidat(rs.getString("nom_Candidat"));
                    S.setPrenom_Candidat(rs.getString("prenom_Candidat"));
                    S.setAge(rs.getInt("age_Candidat"));
                  S.setExperience_Candidat(rs.getString("experience_Candidat"));
                 
                  System.out.println("ok");
               
         
               
            }
           
            return S;
        
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCandidat.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
 }
    
    
    public List<Candidat> Triparnom() throws SQLException{
          List<Candidat>lst= new ArrayList<>();
          
          try{
    String req="SELECT * FROM `esprit`.`candidat` ORDER BY nom_Candidat";
     
          Statement st = con.createStatement();
            st.executeQuery(req);
            ResultSet rs = st.executeQuery(req);
           while(rs.next()){
               int cin_Candidat=rs.getInt(1);
               String prenom_Candidat=rs.getString("prenom_Candidat");
                 String nom_Candidat=rs.getString("nom_Candidat");
              int age_Candidat=rs.getInt("age_Candidat");     
                String experience_Candidat=rs.getString("experience_Candidat");
            lst.add(new Candidat(cin_Candidat,prenom_Candidat,nom_Candidat,age_Candidat,experience_Candidat));
          }
                return lst;
        
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCandidat.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
        }
    
    public void delete(Candidat  t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`candidat` where (cin_Candidat ="+t.getCin_Candidat()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(Candidat t) throws SQLException {
          String sql ="UPDATE `esprit`.`candidat` SET `cin_Candidat`='"+t.getCin_Candidat() + "',`prenom_Candidat`='"+t.getPrenom_Candidat() + "' ,`nom_Candidat`='"+t.getNom_Candidat() + "',`age_Candidat`='"+t.getAge_Candidat() + "',`experience_Candidat`='"+t.getExperience_Candidat() + "'  WHERE `cin_Candidat`='"+t.getCin_Candidat()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   public int nbr_candidat(String nom){
    int nbr_c=0;
    String sql="select nom_Candidat from candidat where nom_Candidat='"+nom+"'";
     try{
         Statement st1 = con.createStatement();
         ResultSet rs=st1.executeQuery(sql);
         while(rs.next()){
            nbr_c++;
          
         }
         rs.close();
     }catch(SQLException ex)
     {
         System.err.println("SQLException"+ex.getMessage());
     }
    return nbr_c;
    }
    public List<Candidat> readAll() throws SQLException {
    List<Candidat> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from candidat");
     while (rs.next()) {                
               int cin_Candidat=rs.getInt(1);
               String nom_Candidat=rs.getString("nom_Candidat");
               String prenom_Candidat=rs.getString(3);
               int age_Candidat=rs.getInt("age_Candidat");     
                String experience_Candidat=rs.getString("experience_Candidat");
      
             Candidat c=new Candidat(cin_Candidat,prenom_Candidat,nom_Candidat,age_Candidat,experience_Candidat);
     arr.add(c);
     }
    return arr;
    }
     public static ServiceCandidat getInstance(){
        if(instance==null) 
            instance=new ServiceCandidat();
        return instance;
    }
}

    
    
    
    
    


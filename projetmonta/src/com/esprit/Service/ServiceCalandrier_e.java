/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.Calandrier_e;
import com.esprit.IService.IServiceCalandrier_e;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BEN SAID
 */
public class ServiceCalandrier_e implements IServiceCalandrier_e<Calandrier_e> {
      private static ServiceCalandrier_e instance;
    public static ServiceCalandrier_e getInstance() {
   if(instance==null) 
            instance=new ServiceCalandrier_e();
        return instance;    }

  

    private Connection con;
    private Statement ste;

    public ServiceCalandrier_e() {
        con = DataBase.getInstance().getConnection();

    }

@Override
    public void ajouter(Calandrier_e t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`Calandrier_e` (`id_calandrier`,`id_examen`,`id_matiere`,`id_salle`,`id_classe`,`nom`,`date_ex`) VALUES (NULL, '" + t.getId_examen() + "', '" + t.getId_matiere() + "', '" + t.getId_salle()+ "','" + t.getId_classe() + "','" + t.getNom() + "' ,'" + t.getDate_ex() + "');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Calandrier_e c) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`calandrier_e` (`id_calandrier`,`id_examen`,`id_matiere`,`id_salle`,`id_classe`,`nom`,`date_ex`) VALUES ( ?, ?, ?,?,? ,?,?);");
   pre.setInt(1, c.getId_calandrier());
       pre.setInt(2,c.getId_examen());
       pre.setInt(2,c.getId_matiere());
        pre.setInt(2,c.getId_salle());
         pre.setInt(2,c.getId_classe());
    pre.setString(3, c.getNom());
   pre.setString(4, c.getDate_ex());
      
   
    pre.executeUpdate();
    }
            


    public void delete(Calandrier_e  t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`Calandrier_e` where (id_Calandrier ="+t.getId_calandrier()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(Calandrier_e t) throws SQLException {
          String sql ="UPDATE `esprit`.`Calandrier_e` SET `id_calandrier`='"+t.getId_calandrier() + "',`id_examen`='"+t.getId_examen() + "' ,`id_matiere`='"+t.getId_matiere() + "',`id_salle`='"+t.getId_salle() + "',`id_classe`='"+t.getId_classe() + "',`nom`='"+t.getNom() + "',`date_ex`='"+t.getDate_ex() + "' WHERE `id_calandrier`='"+t.getId_calandrier()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    public List<Calandrier_e> readAll() throws SQLException {
    List<Calandrier_e> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from Calandrier_e");
     while (rs.next()) { 
         int id_calandrier=rs.getInt(1);
               int id_examen=rs.getInt("id_examen");
               int id_matiere=rs.getInt("id_matiere");     
              int id_salle=rs.getInt("id_salle");
               int id_classe=rs.getInt("id_classe");
               String nom=rs.getString("nom");
                String date_ex=rs.getString("date_ex");
             
               Calandrier_e c=new Calandrier_e(id_calandrier,id_examen,id_matiere,id_salle,id_classe,nom,date_ex);
     arr.add(c);
     }
    return arr;
    }
     public Calandrier_e rechercheCalandrier_eParid_classe(int id_classe)
 {  Calandrier_e S = new Calandrier_e();
        

            

           try {
            
                 String req4="SELECT * FROM esprit.`calandrier_e` WHERE id_classe='" + id_classe + "';";
          Statement st = con.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
              
             S.setId_calandrier(rs.getInt("id_calandrier"));
                    S.setId_examen(rs.getInt("id_examen"));
                    S.setId_matiere(rs.getInt("id_matiere"));
                    S.setId_salle(rs.getInt("id_salle"));
                 S.setId_classe(rs.getInt("id_classe"));
                  S.setNom(rs.getString("nom"));
                  S.setDate_ex(rs.getString("date_ex"));
                  System.out.println("ok");
             
   
               
            }
           
            return S;
        
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCalandrier_e.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
 }
   
     public List<Calandrier_e> Triparnom() throws SQLException{
          List<Calandrier_e>lst= new ArrayList<>();
          
          try{
    String req="SELECT * FROM esprit.`Calandrier_e` ORDER BY nom ";
     
          Statement st = con.createStatement();
            st.executeQuery(req);
            ResultSet rs = st.executeQuery(req);
           while(rs.next()){
                int id_calandrier=rs.getInt(1);
               int id_examen=rs.getInt("id_examen");
                int id_matiere=rs.getInt("id_matiere");
                int id_salle=rs.getInt("id_salle");
               int id_classe=rs.getInt(4);
               String nom=rs.getString("nom");
               String date_ex=rs.getString("date_ex");
  
     
            lst.add(new Calandrier_e(id_calandrier,id_examen,id_matiere,id_salle,id_classe,nom,date_ex));
          }
                return lst;
        
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCalandrier_e.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
        }
 
 
}

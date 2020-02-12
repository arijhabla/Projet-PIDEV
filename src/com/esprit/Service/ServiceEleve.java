/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.Eleve;
import com.esprit.IService.IServiceEleve;
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

    public class ServiceEleve implements IServiceEleve<Eleve> {

    private Connection con;
    private Statement ste;
    public List<Eleve> Triparnom;

    public ServiceEleve() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Eleve e) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`eleve` (`id_eleve`,`nom_eleve`,`prenom_eleve`,`datenaiss_eleve`, `adresse_eleve`,`tel_eleve`) VALUES ( '" + e.getid_eleve() + "', '" + e.getnom_eleve() + "', '" + e.getprenom_eleve() + "' , '" + e.getdatenaiss_eleve() + "', '" + e.getadresse_eleve() +  "' , '" + e.gettel_eleve() + "');" ;
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Eleve e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`eleve` (`id_eleve`,`nom_eleve`,`prenom_eleve`,`datenaiss_eleve`, `adresse_eleve`,`tel_eleve`) VALUES ( ?, ?, ?,?,?,?);");
   pre.setInt(1, e.getid_eleve());
       pre.setString(2,e.getnom_eleve());
    pre.setString(3, e.getprenom_eleve());
    pre.setDate(4, e.getdatenaiss_eleve());
       pre.setString(5, e.getadresse_eleve());
        pre.setInt(6, e.gettel_eleve());

   
    pre.executeUpdate();
    }
            
    /**
     *
     * @param e
     */
    @Override
    public void delete(Eleve e) {
        String sql = "DELETE FROM `esprit`.`eleve` where (id_eleve ="+e.getid_eleve()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    @Override
    public void update(Eleve t) throws SQLException {
          String sql ="UPDATE `esprit`.`eleve` SET `id_eleve`='"+t.getid_eleve() + "',`nom_eleve`='"+t.getnom_eleve() + "' ,`prenom_eleve`='"+t.getprenom_eleve() + "',`datenaiss_eleve`='"+t.getdatenaiss_eleve()+ "',`adresse_eleve`='"+t.getadresse_eleve()+ "',`tel_eleve`='"+t.gettel_eleve()+"'  WHERE `id_eleve`='"+t.getid_eleve()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    @Override
    public List<Eleve> readAll() throws SQLException {
    List<Eleve> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from eleve");
     while (rs.next()) {                
               int id_eleve=rs.getInt(1);
               String nom_eleve=rs.getString("nom_eleve");
               String prenom_eleve=rs.getString(3);
               Date datenaiss_eleve=rs.getDate("datenaiss_eleve");     
               String adresse_eleve=rs.getString("adresse_eleve");
               int tel_eleve=rs.getInt("tel_eleve");
           
             Eleve e=new Eleve(id_eleve,nom_eleve,prenom_eleve,datenaiss_eleve,adresse_eleve,tel_eleve);
     arr.add(e);
     }
    return arr;
    }
   public Eleve rechercheEleveParId(int id_eleve)
 {  Eleve S = new Eleve();
        

            

           try {
            
                 String req4="SELECT * FROM esprit.`eleve` WHERE id_eleve='" + id_eleve + "';";
          Statement st = con.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
              
             S.setid_eleve(rs.getInt("id_eleve"));
                    S.setnom_eleve(rs.getString("nom_eleve"));
                    S.setprenom_eleve(rs.getString("prenom_eleve"));
                    S.setdatenaiss_eleve(rs.getDate("datenaiss_eleve"));
                  S.setadresse_eleve(rs.getString("adresse_eleve"));
                    S.settel_eleve(rs.getInt("tel_eleve"));
                 
                  System.out.println("ok");
               
         
               
            }
           
            return S;
        
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEleve.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
 }
    @Override
    public List<Eleve> Triparnom() throws SQLException{
          List<Eleve>lst= new ArrayList<>();
          
          try{
    String req="SELECT * FROM esprit.`eleve` ORDER BY nom_eleve";
     
          Statement st = con.createStatement();
            st.executeQuery(req);
            ResultSet rs = st.executeQuery(req);
           while(rs.next()){
                int id_eleve=rs.getInt(1);
               String nom_eleve=rs.getString("nom_eleve");
                String prenom_eleve=rs.getString("prenom_eleve");
              Date datenaiss_eleve=rs.getDate("datenaiss_eleve");   
                String adresse_eleve=rs.getString("adresse_eleve");
                int tel_eleve=rs.getInt("tel_eleve");
            lst.add(new Eleve(id_eleve,nom_eleve,prenom_eleve,datenaiss_eleve,adresse_eleve,tel_eleve));
          }
                return lst;
        
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEleve.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
        }
}

    
    
    
    
    


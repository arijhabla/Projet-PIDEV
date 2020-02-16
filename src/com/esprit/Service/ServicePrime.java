/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.Prime;
import com.esprit.IService.IServicePrime;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Pc
 */
public class ServicePrime implements IServicePrime<Prime> {
    private Connection con;
    private Statement ste;

    public ServicePrime() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(Prime t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`prime` (`salaire`,`grade`) VALUES ( '" + t.getSalaire() + "', '" + t.getGrade()+ "');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Prime e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`prime` (`salaire`,`grade`) VALUES (?,?);");
   pre.setFloat(1, e.getSalaire());
   pre.setString(2,e.getGrade());

   
    pre.executeUpdate();
    }
            


    public void delete(Prime  t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`prime` where (salaire ="+t.getSalaire()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(Prime t) throws SQLException {
          String sql ="UPDATE `esprit`.`prime` SET `salaire`='"+t.getSalaire() + "',`grade`='"+t.getGrade() +"'  WHERE `grade`='"+t.getGrade()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

public Prime recherchePrimeParGrade(String grade_g)
 {  Prime S = new Prime();
        

            

           try {
            
                 String req4="SELECT * FROM esprit.`prime` WHERE grade='" + grade_g + "';";
          Statement st = con.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
              
             S.setGrade(rs.getString("grade"));
                  S.setSalaire(rs.getFloat("salaire"));
                 
         
               
            }
           
            return S;
        
        } catch (SQLException ex) {
            Logger.getLogger(ServicePrime.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
 }
    public List<Prime> readAll() throws SQLException {
    List<Prime> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from prime");
     while (rs.next()) {                
               float salaire=rs.getFloat(1);
               String grade=rs.getString("grade");
           
             Prime p=new Prime(salaire,grade);
     arr.add(p);
     }
    return arr;
    }
    
    public List<Prime> Triparsalaire() throws SQLException{
          List<Prime>lst= new ArrayList<>();
          
          try{
    String req="SELECT * FROM esprit.`prime` ORDER BY salaire";
     
          Statement st = con.createStatement();
            st.executeQuery(req);
            ResultSet rs = st.executeQuery(req);
           while(rs.next()){
               float salaire=rs.getFloat(1);
               String grade=rs.getString("grade");
               lst.add(new Prime(salaire,grade));
          }
                return lst;
        
        } catch (SQLException ex) {
            Logger.getLogger(ServicePrime.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
        } 
   
}

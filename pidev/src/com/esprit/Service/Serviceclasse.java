/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.classe;
import com.esprit.IService.IServiceClasse;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dell
 */
public class Serviceclasse implements IServiceClasse<classe>{
    private static Serviceclasse instance;
     private Connection con;
    private Statement ste;

    public Serviceclasse() {
        con = DataBase.getInstance().getConnection();

    }

    @Override
    public void ajouter(classe t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`classe` (`id_classe`,`nbr_eleves`) VALUES ( '" + t.getId_classe() + "', '" + t.getNbr_eleves() + "');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(classe e) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`classe` (`id_classe`,`nbr_eleves`) VALUES ( ?, ?);");
   pre.setInt(1, e.getId_classe());
       pre.setInt(2,e.getNbr_eleves());
   

   
    pre.executeUpdate();
    }
            


    public void delete(classe  t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`classe` where (id_classe ="+t.getId_classe()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(classe t) throws SQLException {
          String sql ="UPDATE `esprit`.`classe` SET `id_classe`='"+t.getId_classe() + "',`nbr_eleves`='"+t.getNbr_eleves() + "'  WHERE `id_classe`='"+t.getId_classe()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    public List<classe> readAll() throws SQLException {
    List<classe> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from classe");
     while (rs.next()) {                
               int id_classe=rs.getInt(1);
             int nbr_eleves=rs.getInt(2);
             
           
             classe c=new classe(id_classe,nbr_eleves);
     arr.add(c);
     }
    return arr;
    }
    /*public List<classe> Triparnbreleves() throws SQLException{
          List<classe>lst= new ArrayList<>();
          
          try{
    String req="SELECT * FROM esprit.`classe` ORDER BY nbr_eleves";
     
          Statement st = con.createStatement();
            st.executeQuery(req);
            ResultSet rs = st.executeQuery(req);
           while(rs.next()){
                int id_classe=rs.getInt(1);
               int nbr_eleves=rs.getInt("nbr_eleves");
            lst.add(new classe(id_classe,nbr_eleves));
          }
                return lst;
        
        } catch (SQLException ex) {
            Logger.getLogger(Serviceclasse.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
        } */
   public classe rechercheClasseParId(int id_classe){
        classe S = new classe();
        try{
            String req4="SELECT * FROM esprit.`classe` WHERE id_classe='" + id_classe + "';";
            Statement st= con.createStatement();
            st.executeQuery(req4);
            ResultSet rs= st.executeQuery(req4);
            while(rs.next()){
                S.setId_classe(rs.getInt("id_classe"));
                S.setNbr_eleves(rs.getInt("nbr_eleves"));
              
                System.out.println("ok");
            }
            return S;
        }
catch (SQLException ex){
    Logger.getLogger(Serviceclasse.class.getName()).log(Level.SEVERE, null, ex);
}
        return null;
    }
    public static Serviceclasse getInstance(){
        if (instance==null)
            instance=new Serviceclasse();
        return instance;
    }
}

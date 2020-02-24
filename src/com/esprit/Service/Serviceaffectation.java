/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Affectation;
import com.esprit.Entite.classe;
import com.esprit.IService.IServiceAffectation;
import com.esprit.IService.IServiceClasse;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class Serviceaffectation implements IServiceAffectation<Affectation> {

    private static Serviceaffectation instance;
    private Connection con;
    private Statement ste;

    public Serviceaffectation() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouter1(classe e) throws SQLException {

        PreparedStatement pre = con.prepareStatement("INSERT INTO `esprit`.`classe` (`id_classe`,`nbr_eleves`,`niveau`) VALUES ( ?, ?, ?);");
        pre.setInt(1, e.getId_classe());
        pre.setInt(2, e.getNbr_eleves());
        pre.setString(3, e.getNiveau());

        pre.executeUpdate();
    }

    public void delete(classe t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`classe` where (id_classe =" + t.getId_classe() + ");";
        //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";

        try {
            Statement stl = con.createStatement();
            int rs = stl.executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

    }

    public void update(classe t) throws SQLException {
        String sql = "UPDATE `esprit`.`classe` SET `id_classe`='" + t.getId_classe() + "',`nbr_eleves`='" + t.getNbr_eleves() + "',`niveau`='" + t.getNiveau() + "'  WHERE `id_classe`='" + t.getId_classe() + "' ";

        try {
            Statement stl = con.createStatement();
            int rs = stl.executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    public List<classe> readAll() throws SQLException {
        List<classe> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from classe");
        while (rs.next()) {
            int id_classe = rs.getInt(1);
            int nbr_eleves = rs.getInt(2);
            String niveau = rs.getString("niveau");

            classe c = new classe(id_classe, nbr_eleves, niveau);
            arr.add(c);
        }
        return arr;
    }

    public int selectAffection(Affectation aff) throws SQLException {
        int id = 0;
        ste = con.createStatement();
                String sql = "SELECT * FROM  affectation where affectation.id_salle=" + aff.getId_salle()+ " and affectation.date='" + aff.getDate() + "'and affectation.heure='" + aff.getHeure() +"'";
                System.out.println(sql);
      //  System.out.println("SELECT * FROM `affectation` WHERE affectation.id_salle=" + aff.getId_salle() + " and affectation.date=" + aff.getDate() + " and affectation.heure=" + aff.getHeure() + " and ' ");
        ResultSet rs = ste.executeQuery(sql);

        //id=rs.getInt(0);
        //   System.out.println("this is the reuslt of query"+rs);
//        System.out.println("this is the id"+rs.getInt("id"));
        int counter = 0;
        while (rs.next()) {
            counter++;
        }
        System.out.println("this is the number of rows"+counter);

        return counter;

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

    public classe rechercheClasseParId(int id_classe) {
        classe S = new classe();
        try {
            String req4 = "SELECT * FROM esprit.`classe` WHERE id_classe='" + id_classe + "';";
            Statement st = con.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
            while (rs.next()) {
                S.setId_classe(rs.getInt("id_classe"));
                S.setNbr_eleves(rs.getInt("nbr_eleves"));
                S.setNiveau(rs.getString("niveau"));
                System.out.println("ok");
            }
            return S;
        } catch (SQLException ex) {
            Logger.getLogger(Serviceclasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Serviceaffectation getInstance() {
        if (instance == null) {
            instance = new Serviceaffectation();
        }
        return instance;
    }

    @Override
    public void ajouter(Affectation t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`affectation` (`nom_classe`,`id_salle`,`nom_mat`,`date`,`heure`) VALUES ( '" + t.getNv_cl() + "', '" + t.getId_salle() + "', '" + t.getNom_matiere() + "', '" + t.getDate() + "', '" + t.getHeure() + "');";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public void delete(Affectation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Affectation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Service;
import com.esprit.Entite.Calandrier_e;
import com.esprit.Entite.Note;
import com.esprit.IService.IServiceNote;
import com.esprit.Utils.DataBase;
import com.esprit.gui.Afficher_noteController;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableView;
import javax.swing.table.TableModel;
import static org.shaded.apache.poi.hssf.usermodel.HeaderFooter.tab;

/**
 *
 * @author BEN SAID
 */
public class ServiceNote implements IServiceNote<Note> {

    private static ServiceNote instance;
    public static ServiceNote getInstance() {
   if(instance==null) 
            instance=new ServiceNote();
        return instance;    }

    private Connection con;
    private Statement ste;

    public ServiceNote() {
        con = DataBase.getInstance().getConnection();

    }

   
    public void ajouter(Note t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `esprit`.`note` (`id_eleve`,`id_examen`,`id_matiere`,`note`,`id_note`,`nom_matiere`,`mail`,`mdp`,`date`) VALUES ('" + t.getId_eleve() + "', '" + t.getId_examen()+ "','" + t.getId_matiere() + "','" + t.getNote() + "' , '" + t.getId_note()+ "', '" + t.getMail()+ "', '" + t.getMdp()+ "', '" + t.getNom_matiere()+ "', '" + t.getNote()+ "');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Note n) throws SQLException
    {
   
       PreparedStatement pre=con.prepareStatement("INSERT INTO `esprit`.`note` (`id_eleve`,`id_examen`,`id_matiere`,`note`,`id_note`,`nom_matiere`,`mail`,`mdp`,`date`) VALUES ( ?, ?, ?,?,?,?,?,?,?);");
   pre.setInt(1, n.getId_eleve());
       pre.setInt(2,n.getId_examen());
    pre.setInt(3, n.getId_matiere());
    pre.setFloat(4, n.getNote());
    pre.setInt(5, n.getId_note());  
     pre.setString(6, n.getNom_matiere());   
    pre.setString(7, n.getMail()); 
   pre.setString(8, n.getMdp()); 
   pre.setTimestamp (9, n.getDate()); 
    
    pre.executeUpdate();
    }
            


    public void delete(Note t) throws SQLException {
        String sql = "DELETE FROM `esprit`.`note` where (id_note ="+t.getId_note()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public void update(Note t) throws SQLException {
          String sql ="UPDATE `esprit`.`note` SET `id_eleve`='"+t.getId_eleve() + "',`id_examen`='"+t.getId_examen() + "' ,`id_matiere`='"+t.getId_matiere() + "',`note`='"+t.getNote() + "' ,`id_note`='"+t.getId_note() + "' ,`nom_matiere`='"+t.getNom_matiere()+ "' ,`mail`='"+t.getMail()+ "' ,`mdp`='"+t.getMdp()+ "' ,`date`='"+t.getNote()+ "'WHERE `id_note`='"+t.getId_note()+"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }}

   
    public List<Note> readAll() throws SQLException {
    List<Note> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from note");
     while (rs.next()) {                
               int id_eleve=rs.getInt(1);
               int id_examen=rs.getInt("id_examen");     
                int id_matiere=rs.getInt("id_matiere");
               float note=rs.getFloat("note");
              int id_note=rs.getInt("id_note");
              String nom_matiere=rs.getString("nom_matiere");
              String mail=rs.getString("mail");
              String mdp=rs.getString("mdp");
             Timestamp date=rs.getTimestamp("date");
             
               Note e=new Note(id_eleve,id_examen,id_matiere,note,id_note,nom_matiere, mail, mdp, date);
     arr.add(e);
     }
    return arr;
    }
       
  public Note rechercheNoteParid_eleve(int id_eleve)
 {  Note S = new Note();
        

            

           try {
            
                 String req4="SELECT * FROM esprit.`note` WHERE id_eleve='" + id_eleve + "';";
          Statement st = con.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
              
             S.setId_eleve(rs.getInt("id_eleve"));
                    S.setId_examen(rs.getInt("id_examen"));
                    S.setId_matiere(rs.getInt("id_matiere"));
                    S.setNote(rs.getFloat("note"));
                 S.setId_note(rs.getInt("id_note"));
                  S.setNom_matiere(rs.getString("nom_matiere"));
                   S.setMail(rs.getString("mail"));
                    S.setMdp(rs.getString("mdp"));
                     S.setDate(rs.getTimestamp("date"));
                 
                  System.out.println("ok");
             
               
            }
           
            return S;
        
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNote.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
 }
  //To change body of generated methods, choose Tools | Templates.
    }

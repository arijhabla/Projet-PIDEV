/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;

import com.esprit.Entite.Note;
import com.esprit.Service.ServiceNote;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author BEN SAID
 */
public class Afficher_noteController implements Initializable {
    @FXML
    private TableColumn<Note,Integer> tide;
    @FXML
    private TableColumn<Note,Integer> tidex;
    @FXML
    private TableColumn<Note,Integer> tidm;
    @FXML
    private TableColumn<Note,Float> tnote;
     @FXML
    private TableColumn<Note,Integer> tidnote;
    @FXML
    private Button aff;
    ObservableList<Note> data=FXCollections.observableArrayList();
    private TableView<Note> tab;
    @FXML
    private Button supp;


    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void setTab(TableView<Note> table) {
        this.tab = table;
    }

    public void setId_eleve(TableColumn<Note, Integer> id_eleve) {
        this.tide = id_eleve;
    }

    public void setid_examen(TableColumn<Note, Integer> id_examen) {
        this.tidex = id_examen;
    }

    public void setid_metiere(TableColumn<Note, Integer> id_matiere) {
        this.tidm = id_matiere;
    }
     public void setnote(TableColumn<Note, Float> note) {
        this.tnote = note;
       
    }
       public void setid_note(TableColumn<Note, Integer> id_note) {
        this.tidnote = id_note;
       }
       public void setAff(Button afficher) {
        this.aff = afficher;
    }
       
       
    @FXML
    private void afficher(ActionEvent event) {
         try {
             ServiceNote no= new ServiceNote();
           // List<Command> list = sp.readAll();
            
            data.addAll(no.readAll());
          
            tide.setCellValueFactory(new PropertyValueFactory<Note,Integer>("id_eleve"));  
         tidex.setCellValueFactory(new PropertyValueFactory<Note,Integer>("id_examen"));
            tidm.setCellValueFactory(new PropertyValueFactory<Note,Integer>("id_matiere"));
            tnote.setCellValueFactory(new PropertyValueFactory<Note,Float>("note"));
             tidnote.setCellValueFactory(new PropertyValueFactory<Note,Integer>("id_note"));          

            tab.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_noteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        
        try {
            Note n = (Note) tab.getSelectionModel().getSelectedItem();
             ServiceNote no = new ServiceNote();
            // as.delete(e);
             
           //  ArrayList arraylist = (ArrayList) as.afficher(e.getId_employe());
               no.delete(n);
              
            tide.setCellValueFactory(new PropertyValueFactory<>("id_eleve"));
           tidex.setCellValueFactory(new PropertyValueFactory<>("id_examen"));
            tidm.setCellValueFactory(new PropertyValueFactory<>("id_matiere"));
           tnote.setCellValueFactory(new PropertyValueFactory<>("note"));
           tidnote.setCellValueFactory(new PropertyValueFactory<>("id_note"));
         } catch (SQLException ex) {
             Logger.getLogger(Afficher_noteController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    
}


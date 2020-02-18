/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;

import com.esprit.Entite.Note;
import com.esprit.Service.ServiceNote;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
   
    ObservableList<Note> data=FXCollections.observableArrayList();
    @FXML
    private TableView<Note> tab;
    @FXML
    private Button supp;
    @FXML
    private Button modifierno;

   public static Integer id_e;
    public static Integer id_ex;
public static Integer id_mat;
public static Float not;
public static Integer id_not;
    @FXML
    private Button annuler;

    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        // TODO
    }    

    public TableColumn<Note, Integer> getTide() {
        return tide;
    }

    public void setTide(TableColumn<Note, Integer> tide) {
        this.tide = tide;
    }

    public TableColumn<Note, Integer> getTidex() {
        return tidex;
    }

    public void setTidex(TableColumn<Note, Integer> tidex) {
        this.tidex = tidex;
    }

    public TableColumn<Note, Integer> getTidm() {
        return tidm;
    }

    public void setTidm(TableColumn<Note, Integer> tidm) {
        this.tidm = tidm;
    }

    public TableColumn<Note, Float> getTnote() {
        return tnote;
    }

    public void setTnote(TableColumn<Note, Float> tnote) {
        this.tnote = tnote;
    }

    public TableColumn<Note, Integer> getTidnote() {
        return tidnote;
    }

    public void setTidnote(TableColumn<Note, Integer> tidnote) {
        this.tidnote = tidnote;
    }

  

    public ObservableList<Note> getData() {
        return data;
    }

    public void setData(ObservableList<Note> data) {
        this.data = data;
    }

    public TableView<Note> getTab() {
        return tab;
    }

    public void setTab(TableView<Note> tab) {
        this.tab = tab;
    }

    public Button getSupp() {
        return supp;
    }

    public void setSupp(Button supp) {
        this.supp = supp;
    }

       
       
  

    @FXML
    private void supprimer(ActionEvent event) {
        
        try {
            Note n = (Note) tab.getSelectionModel().getSelectedItem();
             ServiceNote no = new ServiceNote();
            // as.delete(e);
             
           //  ArrayList arraylist = (ArrayList) as.afficher(e.getId_employe());
               no.delete(n);
              
           tab.getItems().removeAll(n);
         } catch (SQLException ex) {
             Logger.getLogger(Afficher_noteController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    private void modifierno(ActionEvent event) {
       modifierno.setOnAction(n-> {
 Note ref = tab.getSelectionModel().getSelectedItem();
 Afficher_noteController.id_e=ref.getId_eleve();
 Afficher_noteController.id_ex=ref.getId_examen();
 Afficher_noteController.id_mat=ref.getId_matiere();
 Afficher_noteController.not=ref.getNote();
 Afficher_noteController.id_not=ref.getId_note();


 
 
           // AfficheremployeController.vv = selectedItems.toString().split(",")[0].substring(1);
             
            try {
            Parent root = FXMLLoader.load(getClass().getResource("Modifier_note.fxml"));
            Stage stage = (Stage) modifierno.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
           
        } catch (IOException ex) {
            Logger.getLogger(Afficher_noteController.class.getName()).log(Level.SEVERE, null, ex);
        }
                });
        
    }

    @FXML
    private void annuler(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Mnote.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) annuler.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }

    
}


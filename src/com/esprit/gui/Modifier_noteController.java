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
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BEN SAID
 */
public class Modifier_noteController implements Initializable {
    @FXML
    private TextField idel;
    @FXML
    private TextField idexa;
    @FXML
    private TextField idmat;
    @FXML
    private TextField notee;
    @FXML
    private Button modifiern;
    @FXML
    private Button annulern;
    @FXML
    private TextField idnm;
    @FXML
    private ComboBox<String> nommat;
    @FXML
    private TextField mailll;
    @FXML
    private TextField mdep;
    @FXML
    private DatePicker dateee;
    @FXML
    private Button ref;
ObservableList<String> nomlist = FXCollections.observableArrayList("math", "science","arabe","francais","anglais","sport");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nommat.setValue("Enseignant");
        nommat.setItems(nomlist);
    }
// TODO
       

    @FXML
    private void modifiern(ActionEvent event) throws SQLException {
         int id_eleve=Integer.parseInt(idel.getText());
        int id_examen=Integer.parseInt(idexa.getText());
         int id_matiere=Integer.parseInt(idmat.getText());
         float note=Float.parseFloat(notee.getText());  
          int id_note=Integer.parseInt(idnm.getText());
               String nom_matiere = nommat.getSelectionModel().getSelectedItem().toString();
         String mail=mailll.getText();
         String mdp=mdep.getText();  
          Timestamp date = Timestamp.valueOf(dateee.getValue().atTime(LocalTime.MIDNIGHT));
       
        Note no = new Note(id_eleve,id_examen,id_matiere,note,id_note,nom_matiere,mail,mdp,date);
        ServiceNote n =ServiceNote.getInstance();


n.update(no);
    }

   

    @FXML
    private void annulern(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Afficher_note.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) annulern.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ref(ActionEvent event) {
    }
    
}

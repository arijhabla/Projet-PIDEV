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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifiern(ActionEvent event) throws SQLException {
         int id_eleve=Integer.parseInt(idel.getText());
        int id_examen=Integer.parseInt(idexa.getText());
         int id_matiere=Integer.parseInt(idmat.getText());
         float note=Float.parseFloat(notee.getText());  
          int id_note=Integer.parseInt(idnm.getText());
       
        Note no = new Note(id_eleve,id_examen,id_matiere,note,id_note);
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
    
}

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
public class Ajouter_noteController implements Initializable {
     @FXML
    private TextField ftid_eleve;
     @FXML
    private TextField ftidexamen;
    @FXML
    private TextField ftidmatiere;
    @FXML
    private TextField ft_note;
    
    @FXML
    private Button bajout;
    @FXML
    private Button annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
        
        @FXML
    private void ajouter(ActionEvent event) {
        try {
                int id_eleve=Integer.parseInt(ftid_eleve.getText());
                int id_examen=Integer.parseInt(ftidexamen.getText());
                int id_matiere=Integer.parseInt(ftidmatiere.getText());
              
                float note=Float.parseFloat(ft_note.getText());
            

            
            
            
            System.out.println(id_matiere);
            Note n= new Note(id_eleve,id_examen,id_matiere,note);
            ServiceNote se= new ServiceNote(); 
            se.ajouter1(n);
        } catch (SQLException ex) {
            Logger.getLogger(Ajouter_noteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        // TODO

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
    





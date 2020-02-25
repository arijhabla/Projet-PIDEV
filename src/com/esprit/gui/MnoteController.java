/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;

import static com.sun.glass.ui.android.SoftwareKeyboard.hide;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BEN SAID
 */
public class MnoteController implements Initializable {
    @FXML
    private Button bajoute;
    @FXML
    private Button baffic;
    @FXML
    private Button bexit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
          try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Ajouter_note.fxml"));
            Scene scene = new Scene(root);

            
            
            Stage stage = (Stage) bajoute.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
            
            
            
            
            
            
          
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void afficher(ActionEvent event) {
           try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Afficher_note.fxml"));
          Scene scene = new Scene(root);
            Stage stage = (Stage) baffic.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void exit(ActionEvent event) {
           try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) bexit.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
    
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
       
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;

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
public class McalandrierController implements Initializable {
    @FXML
    private Button ajoutc;
    @FXML
    private Button affc;
    @FXML
    private Button exit;

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
            
            Parent root = FXMLLoader.load(getClass().getResource("Ajouter_calandrier.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) ajoutc.getScene().getWindow();
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
            
            Parent root = FXMLLoader.load(getClass().getResource("Afficher_calandrier.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) affc.getScene().getWindow();
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
            Stage stage = (Stage) exit.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;

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
public class AcceuilController implements Initializable {
    @FXML
    private Button bexamen;
    @FXML
    private Button bcalendrier_e;
    @FXML
    private Button bnote;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        // TODO
    }  

    @FXML
    private void gestione(ActionEvent event) {
        
        
           try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Mexam.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) bexamen.getScene().getWindow();
            stage.close();
            
            
            stage.setScene(scene);
            stage.show();
    
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
 
        
        
    }      
    
    
    
    
       

    @FXML
    private void gestionc(ActionEvent event) {
        
         try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Mcalandrier.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) bcalendrier_e.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
    
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    

    @FXML
    private void gestionn(ActionEvent event) {
        
             try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Mnote.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) bnote.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
    
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }

}




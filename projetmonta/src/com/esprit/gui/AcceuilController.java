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
import javafx.scene.control.Button;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

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
        
   
        
        
            FXMLLoader loader = new FXMLLoader
                                (getClass()
                                        .getResource("Ajouter_examen.fxml"));
            Ajouter_examenController apc = loader.getController();
       
        
    }      
    
    
    
    
       

    @FXML
    private void gestionc(ActionEvent event) {
    }

    @FXML
    private void gestionn(ActionEvent event) {
    }
    
    
}






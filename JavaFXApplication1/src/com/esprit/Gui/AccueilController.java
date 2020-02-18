/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Gui;

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
 * @author ferie
 */
public class AccueilController implements Initializable {
    @FXML
    private Button GestionEmp;
    @FXML
    private Button GestionCan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Gestionemployes(ActionEvent event) {
                 try {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    Stage stage = (Stage) GestionEmp.getScene().getWindow();
    stage.close();
    Scene scene =new Scene(root);
    stage.setScene(scene);
    stage.show();
    }catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    }

    @FXML
    private void Gestioncandidats(ActionEvent event) {
                        try {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
    Stage stage = (Stage) GestionCan.getScene().getWindow();
    stage.close();
    Scene scene =new Scene(root);
    stage.setScene(scene);
    stage.show();
    }catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
        
        
    }
    
}

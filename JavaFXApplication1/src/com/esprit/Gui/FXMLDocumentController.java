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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ferie
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Color x2;
    @FXML
    private Font x1;
    @FXML
    private Button ajouter;

@FXML
    private Button afficher;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    void handleButtonAction(ActionEvent event) {
         try {
    Parent root = FXMLLoader.load(getClass().getResource("Ajouteremploye.fxml"));
    Stage stage = (Stage) ajouter.getScene().getWindow();
    stage.close();
    Scene scene =new Scene(root);
    stage.setScene(scene);
    stage.show();
    }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
    
    @FXML
    void afficher(ActionEvent event) {
           try {
    Parent root = FXMLLoader.load(getClass().getResource("Afficheremploye.fxml"));
    Stage stage = (Stage) afficher.getScene().getWindow();
    stage.close();
    Scene scene =new Scene(root);
    stage.setScene(scene);
    stage.show();
    }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

   
    

    @FXML
    private void back(ActionEvent event) {
          try {
    Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
    Stage stage = (Stage) back.getScene().getWindow();
    stage.close();
    Scene scene =new Scene(root);
    stage.setScene(scene);
    stage.show();
    }catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    }
    }
    


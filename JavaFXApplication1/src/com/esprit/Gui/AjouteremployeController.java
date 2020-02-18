/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Gui;

import com.esprit.Entite.Employes;
import com.esprit.Service.ServiceEmployes;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ferie
 */
public class AjouteremployeController implements Initializable {
    @FXML
    private Color x1;
    @FXML
    private Color x3;
    @FXML
    private Font x2;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField age_e;
    @FXML
    private TextField role_e;
    @FXML
    private TextField salaire_e;
    @FXML
    private TextField prime_e;
    @FXML
    private TextField nbre_heure;
   @FXML
    private Button back_e;
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
            String nom_employe=nom.getText();
            String prenom_employe=prenom.getText();
            int age_employe=Integer.parseInt(age_e.getText());
            String role=role_e.getText();
            int salaire=Integer.parseInt(salaire_e.getText());
            int prime=Integer.parseInt(prime_e.getText());

            int nbr_heure=Integer.parseInt(nbre_heure.getText());
            
            
            
            System.out.println(nom_employe);
            Employes emp= new Employes(0,nom_employe,prenom_employe,age_employe,role,salaire,prime,nbr_heure);
            ServiceEmployes se=ServiceEmployes.getInstance(); 
            se.ajouter1(emp);
        } catch (SQLException ex) {
            Logger.getLogger(AjouteremployeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void back(ActionEvent event) {
         try {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Stage stage = (Stage) back_e.getScene().getWindow();
    stage.close();
    Scene scene =new Scene(root);
    stage.setScene(scene);
    stage.show();
    }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
         
       
    }
    
}

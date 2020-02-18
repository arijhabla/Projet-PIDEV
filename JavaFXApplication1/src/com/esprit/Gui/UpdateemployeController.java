/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Gui;

import com.esprit.Entite.Employes;
import com.esprit.Service.ServiceEmployes;
import com.esprit.Utils.DataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
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
public class UpdateemployeController implements Initializable {
   

    @FXML
    private Button modifier;
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
    private TextField age;
    @FXML
    private TextField role_e;
    @FXML
    private TextField salaire_e;
    @FXML
    private TextField prime_e;
    @FXML
    private TextField nbre_heure;
    @FXML
    private Button back;

    /*
String nom_emp= AfficheremployeController.nom_emp;
String prenom_emp= AfficheremployeController.prenom_emp;
Integer age_emp = AfficheremployeController.age_emp;
    */
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
 
    
    }   
       
       
//public static String vv="";
    @FXML
    private void modifier(ActionEvent event) {
        String nom_employe=nom.getText();
        String prenom_employe=prenom.getText();
         int age_employe=Integer.parseInt(age.getText());
        String role_employe=role_e.getText();
        int salaire_employe=Integer.parseInt(salaire_e.getText());
        int prime_employe =Integer.parseInt(prime_e.getText());
        int nbe_heure=Integer.parseInt(nbre_heure.getText());
        Employes emp = new Employes(0,nom_employe,prenom_employe,age_employe,role_employe,salaire_employe,prime_employe,nbe_heure);
        ServiceEmployes ep=ServiceEmployes.getInstance();


ep.update(emp); 
       
    }
    

    @FXML
    private void back(ActionEvent event) {
          try {
    Parent root = FXMLLoader.load(getClass().getResource("Afficheremploye.fxml"));
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
    


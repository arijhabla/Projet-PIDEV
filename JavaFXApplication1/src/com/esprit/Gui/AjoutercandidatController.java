/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Gui;


import com.esprit.Entite.Candidat;
import com.esprit.Service.ServiceCandidat;
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
public class AjoutercandidatController implements Initializable {
    @FXML
    private Color x1;
    @FXML
    private Color x3;
    @FXML
    private Font x2;
    @FXML
    private TextField cin;
    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
    @FXML
    private TextField age;
    @FXML
    private TextField experience;
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
    private void ajouter(ActionEvent event) {
         try {
                int cin_Candidat=Integer.parseInt(cin.getText());
            String prenom_Candidat=prenom.getText();
            String nom_Candidat=nom.getText();
            int age_Candidat=Integer.parseInt(age.getText());
            String experience_Candidat=experience.getText();

            
            
            
            System.out.println(cin_Candidat);
            Candidat c= new Candidat(cin_Candidat,prenom_Candidat,nom_Candidat,age_Candidat,experience_Candidat);
            ServiceCandidat sc=ServiceCandidat.getInstance(); 
            sc.ajouter(c);
        } catch (SQLException ex) {
            Logger.getLogger(AjouteremployeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void back(ActionEvent event) {
        try {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
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

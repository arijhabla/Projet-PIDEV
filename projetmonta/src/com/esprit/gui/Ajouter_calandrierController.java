/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;

import com.esprit.Entite.Calandrier_e;
import com.esprit.Service.ServiceCalandrier_e;
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
public class Ajouter_calandrierController implements Initializable {
    @FXML
    private TextField fid_examen;
     @FXML
    private TextField fid_matiere;
    @FXML
    private TextField fid_salle;
    @FXML
    private TextField fid_classe;
      @FXML
    private TextField fnom;
      @FXML
    private TextField fdate;
      @FXML
    private Button ajouter;
    @FXML
    private Button annuler;
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
                int id_examen=Integer.parseInt(fid_examen.getText());
                int id_matiere=Integer.parseInt(fid_matiere.getText());
                int id_salle=Integer.parseInt(fid_salle.getText());
                int id_classe=Integer.parseInt(fid_classe.getText());
                
                String nom= fnom.getText();
               String date_ex= fdate.getText();

                
                
              
         
            
            
            
            System.out.println(nom);
    Calandrier_e c=new Calandrier_e (id_examen,id_matiere,id_salle,id_classe,nom,date_ex);
            ServiceCalandrier_e ce= new ServiceCalandrier_e(); 
            ce.ajouter(c);
        } catch (SQLException ex) {
            Logger.getLogger(Ajouter_calandrierController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void annuler(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Mcalandrier.fxml"));
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




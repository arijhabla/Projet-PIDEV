/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;
import com.esprit.Entite.Examen;
import com.esprit.Service.ServiceExamen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author BEN SAID
 */
public class Ajouter_examenController implements Initializable {
    @FXML
    private TextField tfdate_examen;
     @FXML
    private TextField tfid_matiere;
    @FXML
    private TextField tf_coefficient;
    @FXML
    private Button bvalider;

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
                int id_matiere=Integer.parseInt(tfid_matiere.getText());
                String date_examen=tfdate_examen.getText();
                float coefficient=Float.parseFloat(tf_coefficient.getText());
            

            
            
            
            System.out.println(id_matiere);
            Examen e= new Examen(id_matiere,date_examen,coefficient);
            ServiceExamen se= new ServiceExamen(); 
            se.ajouter1(e);
        } catch (SQLException ex) {
            Logger.getLogger(Ajouter_examenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;
import com.esprit.Entite.Examen;
import com.esprit.Service.ServiceExamen;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalTime;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BEN SAID
 */
public class Ajouter_examenController implements Initializable {
    @FXML
    private DatePicker tfdate_examen;
     @FXML
    private TextField tfid_matiere;
    @FXML
    private TextField tf_coefficient;
    @FXML
    private Button bvalider;
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
                int id_matiere=Integer.parseInt(tfid_matiere.getText());
               
                float coefficient=Float.parseFloat(tf_coefficient.getText());
            Timestamp date_examen = Timestamp.valueOf(tfdate_examen.getValue().atTime(LocalTime.MIDNIGHT));

            
            
            
            System.out.println(id_matiere);
            Examen e= new Examen(id_matiere,date_examen,coefficient);
            ServiceExamen se= new ServiceExamen(); 
            se.ajouter1(e);
        } catch (SQLException ex) {
            Logger.getLogger(Ajouter_examenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void annuler(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Mexam.fxml"));
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

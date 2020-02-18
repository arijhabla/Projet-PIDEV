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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
public class Modifier_examenController implements Initializable {
    @FXML
    private TextField idmm;
    @FXML
    private TextField dateexm;
    @FXML
    private TextField coeffm;
    @FXML
    private Button modifier;
    @FXML
    private Button annulere;
    @FXML
    private TextField idexm;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
       
       
        int id_examen=Integer.parseInt(idexm.getText());
         int id_matiere=Integer.parseInt(idmm.getText());
        String date_examen=dateexm.getText();
        float coefficient=Float.parseFloat(coeffm.getText());
      
        Examen ex = new Examen(id_examen,id_matiere,date_examen,coefficient);
        ServiceExamen e =ServiceExamen.getInstance();


e.update(ex);
    }
 
    
   


    @FXML
    private void annulere(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Affichier_examen.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) annulere.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    
}

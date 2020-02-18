/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.com.gui;

import com.esprit.Entite.classe;
import com.esprit.Entite.emploidutemps;
import com.esprit.Service.Serviceemploi;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AjoutemploiController implements Initializable {
  @FXML
    private TextField tfnom_emp;
    @FXML
    private Button ajouter_emp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
     @FXML
    private void ajouter_emp(ActionEvent event) {
         try {
String nom_emp=tfnom_emp.getText(); 
            System.out.println(nom_emp);
            emploidutemps e= new emploidutemps(0,nom_emp);
            Serviceemploi se=Serviceemploi.getInstance(); 
            se.ajouter(e);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutemploiController.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    
    
}}

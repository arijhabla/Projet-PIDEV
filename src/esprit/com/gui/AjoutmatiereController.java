/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.com.gui;

import com.esprit.Entite.emploidutemps;
import com.esprit.Entite.matiere;
import com.esprit.Service.Serviceemploi;
import com.esprit.Service.Servicematiere;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AjoutmatiereController implements Initializable {
@FXML
    private TextField tfnom_matiere;
@FXML
    private TextField tfnbr_heures;
    @FXML
    private Button bvaliderm;
    @FXML
    private Font x1;
    @FXML
    private Button BCK;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
     @FXML
    private void ajouter_matiere(ActionEvent event) {
         try {
String nom_matiere=tfnom_matiere.getText(); 
int nbr_heures=Integer.parseInt(tfnbr_heures.getText());
            System.out.println(nom_matiere);
            System.out.println(nbr_heures);
            matiere m= new matiere(0, nom_matiere ,nbr_heures);
            Servicematiere sm=Servicematiere.getInstance(); 
            sm.ajouter(m);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutemploiController.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    
    
}

    @FXML
    private void BCK(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("gotomat.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) BCK.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    }
    

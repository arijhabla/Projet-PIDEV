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
public class AjoutmatiereController implements Initializable {
@FXML
    private TextField tfnom_matiere;
@FXML
    private TextField tfnbr_heures;
    @FXML
    private Button bvaliderm;
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
    
}

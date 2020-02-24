/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.com.gui;

import com.esprit.Entite.classe;
import com.esprit.Entite.salle;
import com.esprit.Service.Serviceclasse;
import com.esprit.Service.Servicesalle;
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
 * @author dell
 */
public class AjoutsalleController implements Initializable {
  @FXML
    private TextField tfcapacite;
    @FXML
    private Button bentrer;
    @FXML
    private Button retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    private void ajouter_salle(ActionEvent event) {
         try {
                int capacite=Integer.parseInt(tfcapacite.getText());
 
            System.out.println(capacite);
            salle s= new salle(0,capacite);
            Servicesalle ss=Servicesalle.getInstance(); 
            ss.ajouter(s);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutclasseController.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    

    }

    @FXML
    private void retour(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("gotosalle.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) retour.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    }
    

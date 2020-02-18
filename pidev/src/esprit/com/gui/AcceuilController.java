/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.com.gui;

import com.esprit.Entite.classe;
import com.esprit.Entite.emploidutemps;
import com.esprit.Service.Serviceclasse;
import com.esprit.Service.Serviceemploi;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AcceuilController implements Initializable {
 @FXML
    private Button bclasse;
  @FXML
    private Button bemp;
   @FXML
    private Button bmatiere;
    @FXML
    private Button bsalle;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
     @FXML
     private void gotoclasse(ActionEvent event) {
       
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("gotoclasse.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }   
        
    }

    @FXML
    private void gotoemp(ActionEvent event) {
    }

    @FXML
    private void gotomat(ActionEvent event) {
    }

    @FXML
    private void gotosalle(ActionEvent event) {
    }
    
    
}
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.com.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class GotoclasseController implements Initializable {
@FXML
    private Button bajouter;
    @FXML
    private Button bafficher;
    @FXML
    private Button RETOUR;
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
            
            Parent root = FXMLLoader.load(getClass().getResource("Ajoutclasse.fxml"));
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
    private void afficher(ActionEvent event) {
          try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Afficherclasse.fxml"));
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
    private void RETOUR(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) RETOUR.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    }
    


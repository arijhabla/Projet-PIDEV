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
public class GotoempController implements Initializable {
    @FXML
    private Button afficheremp;
    @FXML
    private Button ajouteremp;
    @FXML
    private Button ret;
    @FXML
    private Button affecter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficheremp(ActionEvent event) {
            try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Afficheremp.fxml"));
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
    private void ajouteremp(ActionEvent event) {
            try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Ajoutemploi.fxml"));
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
    private void ret(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) ret.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void affecter(ActionEvent event) {
          try {
            
            Parent root = FXMLLoader.load(getClass().getResource("affectation.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
                          System.out.println("probleme here while transition");

            System.out.println(ex.getMessage());
        } 
    }
    }
    


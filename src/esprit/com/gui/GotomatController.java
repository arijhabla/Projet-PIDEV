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
public class GotomatController implements Initializable {
    @FXML
    private Button affichermat;
    @FXML
    private Button ajoutermat;
    @FXML
    private Button retour1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void affichermat(ActionEvent event) {
            try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Affichermatiere.fxml"));
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
    private void ajoutermat(ActionEvent event) {
            try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Ajoutmatiere.fxml"));
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
    private void retour1(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) retour1.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    }
    

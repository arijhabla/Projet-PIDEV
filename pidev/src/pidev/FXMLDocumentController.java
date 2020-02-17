/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev;

import com.esprit.Service.ServiceClub;
import com.esprit.entite.Club;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khadija
 */
public class FXMLDocumentController implements Initializable {

    
   @FXML
    private Button ajouter;


 @FXML
    private Button afficher;
    
 @FXML
    void afficher(ActionEvent event) {
try {
    Parent root = FXMLLoader.load(getClass().getResource("afficherclub.fxml"));
    Stage stage = (Stage) afficher.getScene().getWindow();
    stage.close();
    Scene scene =new Scene(root);
    stage.setScene(scene);
    stage.show();
    }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {

try {
    Parent root = FXMLLoader.load(getClass().getResource("ajouterclub.fxml"));
    Stage stage = (Stage) ajouter.getScene().getWindow();
    stage.close();
    Scene scene =new Scene(root);
    stage.setScene(scene);
    stage.show();
    }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

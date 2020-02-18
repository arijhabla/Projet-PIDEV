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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khadija
 */
public class AjouterclubController implements Initializable {

      @FXML
    private TextField nom;

    @FXML
    private TextField type;

    @FXML
    private Button ajouter;

    @FXML
    void ajouter(ActionEvent event) throws SQLException {
 System.out.println("heyyy");

String nom_c=nom.getText();
String t=type.getText();
System.out.println(nom_c);
Club c= new Club(0,nom_c,t);
ServiceClub sc=ServiceClub.getInstance();
sc.ajouter(c);
    }
     @FXML
    private Button back;

   
    @FXML
    void back(ActionEvent event) {
try {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    Stage stage = (Stage) back.getScene().getWindow();
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

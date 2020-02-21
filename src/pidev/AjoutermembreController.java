/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev;

import com.esprit.Service.ServiceMembre;
import com.esprit.entite.Membre;
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
public class AjoutermembreController implements Initializable {

      @FXML
    private TextField nom;

    @FXML
    private TextField prenom;
       @FXML
    private TextField age;
       

    @FXML
    private Button ajouter;

    @FXML
    void ajouter(ActionEvent event) throws SQLException {
       /* if (nom.getText().isEmpty() || prenom.getText().isEmpty() || age.getText().isEmpty()) {

             System.out.println("remplir les informations");
             Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Ooops, missing information!");

            alert.showAndWait();
        } else {
 System.out.println("heyyy");*/

String nom_m=nom.getText();
String prenom_m=prenom.getText();
int age_m=Integer.parseInt(age.getText());
System.out.println(nom_m);
Membre c= new Membre(0,nom_m,prenom_m,age_m);
ServiceMembre sc=ServiceMembre.getInstance();
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

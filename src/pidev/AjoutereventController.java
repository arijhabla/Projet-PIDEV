/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev;

import com.esprit.Service.ServiceEvent;
import com.esprit.entite.Event;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khadija
 */
public class AjoutereventController implements Initializable {

      @FXML
    private TextField nom;

    @FXML
    private DatePicker date;

    @FXML
    private Button ajouter;

    @FXML
    void ajouter(ActionEvent event) throws SQLException {
        
        
       /* if (nom.getText().isEmpty() ) {

             System.out.println("remplir les informations");
             Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Ooops, missing information!");

            alert.showAndWait();
        } else {
 System.out.println("heyyy");*/
String nom_e=nom.getText();
LocalDate datee = date.getValue();
            Date daten = Date.valueOf(datee);

System.out.println(nom_e);
Event c= new Event(0,nom_e,daten);
ServiceEvent se=ServiceEvent.getInstance();
se.ajouter(c);}
    
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

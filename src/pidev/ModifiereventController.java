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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ModifiereventController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField date;
    @FXML
    private Button modifier;
    @FXML
    private TextField id;
    @FXML
    private Button back;
    @FXML
    private DatePicker date2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void modifier(ActionEvent event) {
        int id_event = Integer.parseInt(id.getText());
        String nom_event = nom.getText();
        LocalDate datem = date2.getValue();
        Date daten = Date.valueOf(datem);
        Event emp = new Event(id_event, nom_event, daten);
        ServiceEvent se= ServiceEvent.getInstance();

        try {
            se.update(emp);
        } catch (SQLException ex) {
            Logger.getLogger(AffichereventController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void back(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("afficherevent.fxml"));
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}

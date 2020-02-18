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
 * @author Khadija
 */
public class UpdateeleveController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private TextField type;
    @FXML
    private Button modifier;
    @FXML
    private TextField id;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
         int id_club =Integer.parseInt(id.getText());
        String nom_club=nom.getText();
        String type_club=type.getText();
      
        Club emp = new Club(id_club,nom_club,type_club);
        ServiceClub es=ServiceClub.getInstance();


        try {
            es.update(emp);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherclubController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    

    }

    @FXML
    private void back(ActionEvent event) {
        
        
                
                try {
    Parent root = FXMLLoader.load(getClass().getResource("afficherclub.fxml"));
    Stage stage = (Stage) back.getScene().getWindow();
    stage.close();
    Scene scene =new Scene(root);
    stage.setScene(scene);
    stage.show();
    }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}

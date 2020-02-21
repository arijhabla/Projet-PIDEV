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
public class ModifiermembreController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private Button modifier;
    @FXML
    private TextField id;
    @FXML
    private TextField age;
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
         int id_membre =Integer.parseInt(id.getText());
        String nom_membre=nom.getText();
        String prenom_membre=prenom.getText();
         int age_membre =Integer.parseInt(age.getText());
      
        Membre emp = new Membre(id_membre,nom_membre,prenom_membre,age_membre);
        ServiceMembre es=ServiceMembre.getInstance();


        try {
            es.update(emp);
        } catch (SQLException ex) {
            Logger.getLogger(AffichermembreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    

    }

    @FXML
    private void back(ActionEvent event) {
        
        
                
                try {
    Parent root = FXMLLoader.load(getClass().getResource("affichermembre.fxml"));
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

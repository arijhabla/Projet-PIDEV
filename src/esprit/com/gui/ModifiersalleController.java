/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import com.esprit.Entite.classe;
import com.esprit.Entite.salle;
import com.esprit.Service.Serviceclasse;
import com.esprit.Service.Servicesalle;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ModifiersalleController implements Initializable {
    @FXML
    private TextField tfc;
    @FXML
    private TextField tfids;
    @FXML
    private Font x1;
    @FXML
    private Button modifiersalle;
    @FXML
    private Button back2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifiersalle(ActionEvent event) throws SQLException {
                int id_salle=Integer.parseInt(tfids.getText());

         int capacite=Integer.parseInt(tfc.getText());
       
       salle s1 = new salle(id_salle,capacite);
        Servicesalle ss=Servicesalle.getInstance();


ss.update(s1);
    }

    @FXML
    private void back2(ActionEvent event) {
           try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Affichersalle.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) back2.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    
}

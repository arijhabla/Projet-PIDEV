/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import com.esprit.Entite.classe;
import com.esprit.Entite.matiere;
import com.esprit.Service.Serviceclasse;
import com.esprit.Service.Servicematiere;
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
public class ModifiermatController implements Initializable {
    @FXML
    private Font x1;
    @FXML
    private TextField tfidm;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfnbr;
    @FXML
    private Button modmat;
    @FXML
    private Button back4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modmat(ActionEvent event) throws SQLException {
         int id_matiere=Integer.parseInt(tfidm.getText());

         String nom_matiere=tfnom.getText();
         int nbr_heures=Integer.parseInt(tfnbr.getText());
       
        matiere m1 = new matiere(id_matiere,nom_matiere,nbr_heures);
        Servicematiere sm=Servicematiere.getInstance();


sm.update(m1);
    }

    @FXML
    private void back4(ActionEvent event) {
           try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Affichermatiere.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) back4.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    
}

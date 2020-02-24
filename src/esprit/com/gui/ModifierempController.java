/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import com.esprit.Entite.classe;
import com.esprit.Entite.emploidutemps;
import com.esprit.Service.Serviceclasse;
import com.esprit.Service.Serviceemploi;
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
public class ModifierempController implements Initializable {
    @FXML
    private Font x1;
    @FXML
    private TextField tfidee;
    @FXML
    private TextField tfn;
    @FXML
    private Button modifiere;
    @FXML
    private Button BACK;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifiere(ActionEvent event) throws SQLException {
               int id_emploi=Integer.parseInt(tfidee.getText());

         String nom_emploi=tfn.getText();
       
        emploidutemps e1 = new emploidutemps(id_emploi,nom_emploi);
        Serviceemploi se=Serviceemploi.getInstance();


se.update(e1);
    }

    @FXML
    private void BACK(ActionEvent event) {
             try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Afficheremp.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) BACK.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    
}

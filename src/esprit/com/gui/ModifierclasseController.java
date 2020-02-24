/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import com.esprit.Entite.classe;
import com.esprit.Service.Serviceclasse;
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
public class ModifierclasseController implements Initializable {
    @FXML
    private TextField tfnb;
    @FXML
    private Button modifier;
    @FXML
    private TextField id;
    @FXML
    private Button back1;
    @FXML
    private Font x1;
    @FXML
    private TextField tfni;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
              int id_classe=Integer.parseInt(id.getText());

         int nbr_eleves=Integer.parseInt(tfnb.getText());
       String niveau=tfni.getText();
        classe c1 = new classe(id_classe,nbr_eleves, niveau);
        Serviceclasse sc=Serviceclasse.getInstance();


sc.update(c1);
    }

    @FXML
    private void back1(ActionEvent event) {
          try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Afficherclasse.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) back1.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }

   
    
}

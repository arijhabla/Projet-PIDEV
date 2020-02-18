/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import com.esprit.Entite.classe;
import com.esprit.Service.Serviceclasse;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
       
        classe c1 = new classe(id_classe,nbr_eleves);
        Serviceclasse sc=Serviceclasse.getInstance();


sc.update(c1);
    }

    @FXML
    private void id(ActionEvent event) {
    }
    
}

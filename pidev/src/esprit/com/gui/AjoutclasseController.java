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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AjoutclasseController implements Initializable {
    @FXML
    private TextField tfnbr;
    @FXML
    private Button bvalider;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
         try {
                int nbr_eleves=Integer.parseInt(tfnbr.getText());
 
            System.out.println(nbr_eleves);
            classe c= new classe(0,nbr_eleves);
            Serviceclasse sc=Serviceclasse.getInstance(); 
            sc.ajouter(c);
        } catch (SQLException ex) {
            Logger.getLogger(AjoutclasseController.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    

    } }
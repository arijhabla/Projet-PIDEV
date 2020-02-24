/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.com.gui;
import com.esprit.Entite.classe;
import com.esprit.Service.Serviceclasse;
import static esprit.com.gui.AfficherclasseController.niveau;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
    @FXML
    private Button back;
    @FXML
    private Font x1;
    @FXML
    private TextField tfniv;
   

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
                String niveau=tfniv.getText();
            System.out.println(nbr_eleves);
            System.out.println(niveau);
            classe c= new classe(0,nbr_eleves,niveau);
            Serviceclasse sc=Serviceclasse.getInstance(); 
            sc.ajouter(c);
//
            
        } catch (SQLException ex) {
            Logger.getLogger(AjoutclasseController.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    

    } 

    @FXML
    private void back(ActionEvent event) {
          try {
            
            Parent root = FXMLLoader.load(getClass().getResource("gotoclasse.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
}
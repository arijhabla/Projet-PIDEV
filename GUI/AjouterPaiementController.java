 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.GUI;

import com.esprit.Entite.Paiement;
import com.esprit.Service.ServiceComptable;
import com.esprit.Service.ServicePaiement;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class AjouterPaiementController implements Initializable {
    @FXML
    private ComboBox<String> typep;
    @FXML
    private TextField montantp;
    @FXML
    private Button ajouter;
    
    ObservableList<String> rolelist = FXCollections.observableArrayList("Chèque", "Espèce","En ligne");
   


  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typep.setValue("Chèque");
        typep.setItems(rolelist);
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        
                
         if (typep.getSelectionModel().getSelectedItem().toString().isEmpty() || montantp.getText().isEmpty()) {

             System.out.println("remplir les informations");
            /*Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Ooops, missing information!");

            alert.showAndWait();*/
        } else {
                   try {
            String type_paiement=typep.getSelectionModel().getSelectedItem().toString();
            int montant=Integer.parseInt(montantp.getText());
            
            
            
            System.out.println();
            Paiement cmp= new Paiement(0,type_paiement,montant);
            ServicePaiement sp=ServicePaiement.getInstance(); 
            sp.ajouter(cmp);
            
            
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }

         }       
         
                   
                   
                   
        
    }
    }
    


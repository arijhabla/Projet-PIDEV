/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;

import com.esprit.Entite.Calandrier_e;
import com.esprit.Service.ServiceCalandrier_e;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BEN SAID
 */
public class Modifier_calandrierController implements Initializable {
    @FXML
    private TextField idem;
    @FXML
    private TextField idmm;
    @FXML
    private TextField idsm;
    @FXML
    private TextField idcm;
    @FXML
    private TextField nomm;
    @FXML
    private TextField datecm;
    @FXML
    private Button modifierc;
    @FXML
    private Button annulerc;

   
    
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierc(ActionEvent event) throws SQLException {
        int id_calandrier=Integer.parseInt(idcm.getText());
        int id_examen=Integer.parseInt(idem.getText());
         int id_matiere=Integer.parseInt(idmm.getText());
        int id_salle=Integer.parseInt(idsm.getText());
        int id_classe=Integer.parseInt(idcm.getText());
       String nom= nomm.getText();
        String date_ex= datecm.getText();
        Calandrier_e cae = new Calandrier_e(id_calandrier,id_examen,id_matiere,id_salle,id_classe, nom,date_ex);
        ServiceCalandrier_e ce =ServiceCalandrier_e.getInstance();


ce.update(cae);
    }
    

    @FXML
    private void annulerc(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Afficher_calandrier.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) annulerc.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    
}

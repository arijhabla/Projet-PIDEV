/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.GUI;

import com.esprit.Entite.Comptable;
import com.esprit.Service.ServiceComptable;
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
 * @author Pc
 */


public class ModifierComptableController implements Initializable {
    @FXML
    private Button valider;
    @FXML
    private TextField nomcom;
    @FXML
    private TextField prenomcom;
    @FXML
    private TextField etatcom;
    @FXML
    private TextField telcom;
    @FXML
    private TextField adressecom;
    
    public static Comptable C ;

    public static Comptable getC() {
        return C;
    }

    public static void setC(Comptable C) {
        ModifierComptableController.C = C;
    }
    @FXML
    private Button refresh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void valider(ActionEvent event) throws SQLException {

        String nom_comptable=nomcom.getText();
        String prenom_comptable=prenomcom.getText();
        String etat_comptable=etatcom.getText();
        int telephone_comptable=Integer.parseInt(telcom.getText());
        String adressemail_comptable=adressecom.getText();
        
        Comptable cmp = new Comptable();
        
        cmp.setAdressemail_comptable(adressemail_comptable);
        cmp.setNom_comptable(nom_comptable);
        cmp.setPrenom_comptable(prenom_comptable);
        cmp.setID_comptable(C.getID_comptable());
        cmp.setEtat_comptable(etat_comptable);
        cmp.setTelephone_comptable((int)telephone_comptable);
        
        ServiceComptable sc=ServiceComptable.getInstance();


sc.update(cmp);

    }

     @FXML
    private void refresh(ActionEvent event) {
         System.out.println(C.getID_comptable());
        ServiceComptable sc = new ServiceComptable();

        nomcom.setText(C.getNom_comptable());
        prenomcom.setText(C.getPrenom_comptable());
        adressecom.setText(C.getAdressemail_comptable());
        telcom.setText(Integer.toString(C.getTelephone_comptable()));
        etatcom.setText(C.getEtat_comptable());
    }
}

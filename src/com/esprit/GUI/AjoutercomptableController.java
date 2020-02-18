/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.GUI;

import com.esprit.Entite.Comptable;
import com.esprit.Service.ServiceComptable;
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
 * @author Pc
 */
public class AjoutercomptableController implements Initializable {
    @FXML
    private TextField nomc;
    @FXML
    private TextField prenomc;
    @FXML
    private TextField etatc;
    @FXML
    private TextField telc;
    @FXML
    private TextField adressec;
    @FXML
    private Button ajouter;

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
            String nom_comptable=nomc.getText();
            String prenom_comptable=prenomc.getText();
            String etat_comptable=etatc.getText();
            int telephone_comptable=Integer.parseInt(telc.getText());
            String adressemail_comptable=adressec.getText();
            
            
            
            System.out.println(nom_comptable);
            Comptable cmp= new Comptable(0,nom_comptable,prenom_comptable,etat_comptable,telephone_comptable,adressemail_comptable);
            ServiceComptable sc=ServiceComptable.getInstance(); 
            sc.ajouter(cmp);
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        
    }
    }
    

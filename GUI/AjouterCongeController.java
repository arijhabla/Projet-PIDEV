/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.GUI;

import com.esprit.Entite.Conge;
import com.esprit.Service.ServiceConge;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class AjouterCongeController implements Initializable {
    @FXML
    private TextField idc;
    @FXML
    private TextField ddc;
    @FXML
    private TextField dfc;
    @FXML
    private Button ajouter;
    
     @FXML
    private DatePicker date1;
     
      @FXML
    private DatePicker date2;

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
            
            int id_enseignant=Integer.parseInt(idc.getText());
             LocalDate date_deb= date1.getValue();
            Date dated = Date.valueOf(date_deb);
            LocalDate date_fin= date2.getValue();
            Date datef = Date.valueOf(date_fin);
            
            
            
            
            System.out.println(id_enseignant);
            Conge con= new Conge(id_enseignant,dated,datef);
            ServiceConge sc=ServiceConge.getInstance(); 
            sc.ajouter(con);
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
    
}

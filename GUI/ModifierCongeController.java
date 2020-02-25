/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.GUI;
import com.esprit.Entite.Conge;
import static com.esprit.GUI.ModifierComptableController.C;
import com.esprit.Service.ServiceComptable;
import com.esprit.Service.ServiceConge;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ModifierCongeController implements Initializable {
    @FXML
    private DatePicker dated;
    @FXML
    private TextField ide;
    @FXML
    private DatePicker date2;
    @FXML
    private Button modifier;
    



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
    private void modifier(ActionEvent event) throws SQLException {
    
        int id_enseignant = Integer.parseInt(ide.getText());
        LocalDate datem = dated.getValue();
        Date daten = Date.valueOf(datem);
        LocalDate datem2 = date2.getValue();
        Date daten2 = Date.valueOf(datem2);
        Conge con = new Conge(id_enseignant, daten, daten2);

        ServiceConge sc=ServiceConge.getInstance();
        

            sc.update(con);
    }


    
}

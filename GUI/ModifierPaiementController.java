/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.GUI;

import com.esprit.Entite.Comptable;
import com.esprit.Entite.Paiement;
import static com.esprit.GUI.ModifierComptableController.C;
import com.esprit.Service.ServiceComptable;
import com.esprit.Service.ServicePaiement;
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
public class ModifierPaiementController implements Initializable {
    @FXML
    private Button modifier;
    @FXML
    private TextField typep;
    @FXML
    private TextField montantp;
        public static Paiement C ;

    public static Paiement getC() {
        return C;
    }

    public static void setC(Paiement C) {
        ModifierPaiementController.C = C;
    }
    @FXML
    private Button refresh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        
        String type_paiement=typep.getText();
        int montant=Integer.parseInt(montantp.getText());
        
        Paiement cmp = new Paiement();
        
        cmp.setId_paiement(C.getId_paiement());
        cmp.setMontant((int)montant);
        cmp.setType_paiement(type_paiement);
        
        ServicePaiement sc=ServicePaiement.getInstance();

        sc.update(cmp);
        
    }



    @FXML
    private void refresh(ActionEvent event) {
        System.out.println(C.getId_paiement());
        ServicePaiement sc = new ServicePaiement();

        typep.setText(C.getType_paiement());
        montantp.setText(Integer.toString(C.getMontant()));
    }
    
}

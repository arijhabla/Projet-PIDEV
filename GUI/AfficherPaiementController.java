/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.GUI;

import com.esprit.Entite.Comptable;
import com.esprit.Entite.Paiement;
import com.esprit.Service.ServiceComptable;
import com.esprit.Service.ServicePaiement;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class AfficherPaiementController implements Initializable {
    @FXML
    private TableView<Paiement> table;
    @FXML
    private TableColumn<Paiement, Integer> idp;
    @FXML
    private TableColumn<Paiement, String> typep;
    @FXML
    private TableColumn<Paiement, Integer> montantp;
    private ObservableList<Paiement> data=FXCollections.observableArrayList();
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    public static Integer id_p;
    public static String type_p;
    public static Integer montant_p;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                     try {
            ServicePaiement sp= new ServicePaiement();
  
            data.addAll(sp.readAll());
            
            idp.setCellValueFactory(new PropertyValueFactory<Paiement,Integer>("id_paiement"));
            typep.setCellValueFactory(new PropertyValueFactory<Paiement,String>("type_paiement"));
            montantp.setCellValueFactory(new PropertyValueFactory<Paiement,Integer>("montant"));
            
            table.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(AffichercomptableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
 public void setTab(TableView<Paiement> table) {
        this.table = table;
    } 
    public void setId(TableColumn<Paiement, Integer> idp) {
        this.idp = idp;
    } 

    public void setTypep(TableColumn<Paiement, String> typep) {
        this.typep = typep;
    }

    public void setMontantp(TableColumn<Paiement, Integer> montantp) {
        this.montantp = montantp;
    }
    
    public void setData(ObservableList<Paiement> data) {
        this.data = data;
    }

    @FXML
    private void supprimer(ActionEvent event) {
            try {
             Paiement p = (Paiement) table.getSelectionModel().getSelectedItem();
             ServicePaiement sp = new ServicePaiement();
               sp.delete(p);
               table.getItems().removeAll(p);
         } catch (SQLException ex) {
         }
    
    }

    @FXML
    private void modifier(ActionEvent event) {
        modifier.setOnAction(e-> {
        Paiement ref = table.getSelectionModel().getSelectedItem();
                     
            try {
            Parent root = FXMLLoader.load(getClass().getResource("ModifierPaiement.fxml"));
            Stage stage = (Stage) modifier.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            ModifierPaiementController.setC(ref); 
                System.out.println(ref.getId_paiement());
            stage.setScene(scene);
            stage.show();
               } catch (IOException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
                });
    }
    
}

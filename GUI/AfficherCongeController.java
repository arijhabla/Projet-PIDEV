/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.GUI;

import com.esprit.Entite.Conge;
import com.esprit.Service.ServiceConge;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
public class AfficherCongeController implements Initializable {
    @FXML
    private TableView<Conge> table;
    @FXML
    private TableColumn<Conge, Integer> ide;
    @FXML
    private TableColumn<Conge, Date> ddc;
    @FXML
    private TableColumn<Conge, Date> dfc;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    
    private ObservableList<Conge> data=FXCollections.observableArrayList();
    public static Integer id_e;
    public static Date dated;
    public static Date datef;




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
            ServiceConge sc= new ServiceConge();
  
            data.addAll(sc.readAll());
            
            ide.setCellValueFactory(new PropertyValueFactory<Conge,Integer>("id_enseignant"));
            ddc.setCellValueFactory(new PropertyValueFactory<Conge,Date>("Date_Debut_Conge"));
            dfc.setCellValueFactory(new PropertyValueFactory<Conge,Date>("Date_Fin_Conge"));
                    
            table.setItems(data);

        } catch (SQLException ex) {
            Logger.getLogger(AffichercomptableController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }    

    
     public void setTab(TableView<Conge> table) {
        this.table = table;
    } 
    public void setId(TableColumn<Conge, Integer> ide) {
        this.ide = ide;
    }   
    public void setDatedebut(TableColumn<Conge, Date> ddc) {
        this.ddc = ddc;
    } 
        public void setDatefin(TableColumn<Conge, Date> dfc) {
        this.dfc = dfc;
    } 
    
    
    
    @FXML
    private void supprimer(ActionEvent event) {
            try {
             Conge c = (Conge) table.getSelectionModel().getSelectedItem();
             ServiceConge sc = new ServiceConge();
               sc.delete(c);
               table.getItems().removeAll(c);
         } catch (SQLException ex) {
         }
        
    }

    @FXML
    private void modifier(ActionEvent event) {
     modifier.setOnAction(e-> {
 Conge ref = table.getSelectionModel().getSelectedItem();
 AfficherCongeController.id_e=ref.getId_enseignant();
 AfficherCongeController.dated=ref.getDate_Debut_Conge();
 AfficherCongeController.datef=ref.getDate_Fin_Conge();
 


 
             
            try {
            Parent root = FXMLLoader.load(getClass().getResource("ModifierConge.fxml"));
            Stage stage = (Stage) modifier.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
           Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
                });
        
        
    }   
    }


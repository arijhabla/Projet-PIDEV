/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;

import com.esprit.Entite.Examen;
import com.esprit.Service.ServiceExamen;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author BEN SAID
 */
public class Affichier_examenController implements Initializable {
    @FXML
    private TableColumn<Examen,Integer> tfexamen;
    @FXML
    private TableColumn<Examen,Integer> tfmatiere;
    @FXML
    private TableColumn<Examen,String> tfdate;
    @FXML
    private TableColumn<Examen,Float> tfc;
    @FXML
    private Button afficher;
    ObservableList<Examen> data=FXCollections.observableArrayList();
    @FXML
    private TableView<Examen> table;
    @FXML
    private Button supprimer;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void setTab(TableView<Examen> table) {
        this.table = table;
    }

    public void setId(TableColumn<Examen, Integer> id_examen) {
        this.tfexamen = id_examen;
    }

    public void setmatiere(TableColumn<Examen, Integer> id_matiere) {
        this.tfmatiere = id_matiere;
    }

    public void setdate(TableColumn<Examen, String> date_examen) {
        this.tfdate = date_examen;
    }
     public void setcoeff(TableColumn<Examen, Float> coefficient) {
        this.tfc = coefficient;
    }
       public void setAff(Button affcher) {
        this.afficher = afficher;
    }
    @FXML
    private void afficher(ActionEvent event) {
         try {
             ServiceExamen se= new ServiceExamen();
           // List<Command> list = sp.readAll();
            
            data.addAll(se.readAll());
            
         tfexamen.setCellValueFactory(new PropertyValueFactory<Examen,Integer>("id_examen"));
            tfmatiere.setCellValueFactory(new PropertyValueFactory<Examen,Integer>("id_matiere"));
            tfdate.setCellValueFactory(new PropertyValueFactory<Examen,String>("date_examen"));
                       tfc.setCellValueFactory(new PropertyValueFactory<Examen,Float>("coefficient"));

            table.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(Affichier_examenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        
        try {
             Examen c = (Examen) table.getSelectionModel().getSelectedItem();
             ServiceExamen sc = new ServiceExamen();
            // as.delete(e);
             
           //  ArrayList arraylist = (ArrayList) as.afficher(e.getId_employe());
               sc.delete(c);
              
            tfexamen.setCellValueFactory(new PropertyValueFactory<>("id_examen"));
           tfmatiere.setCellValueFactory(new PropertyValueFactory<>("id_matiere"));
            tfdate.setCellValueFactory(new PropertyValueFactory<>("date_examen"));
           tfc.setCellValueFactory(new PropertyValueFactory<>("coefficient"));

         } catch (SQLException ex) {
             Logger.getLogger(Affichier_examenController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    
}

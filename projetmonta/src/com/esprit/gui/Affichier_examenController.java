/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;

import com.esprit.Entite.Examen;
import com.esprit.Service.ServiceExamen;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
   
    ObservableList<Examen> data=FXCollections.observableArrayList();
    @FXML
    private TableView<Examen> table;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifierex;
    @FXML
    private Button annuler;
    @FXML


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
  
   
   

    @FXML
    private void supprimer(ActionEvent event) {
        
        try {
             Examen c = (Examen) table.getSelectionModel().getSelectedItem();
             ServiceExamen sc = new ServiceExamen();
            // as.delete(e);
             
           //  ArrayList arraylist = (ArrayList) as.afficher(e.getId_employe());
               sc.delete(c);
                      table.getItems().removeAll(c);

         } catch (SQLException ex) {
             Logger.getLogger(Affichier_examenController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    public static Integer id_ex;
public static Integer id_mat;
public static String date_e;
public static Float coeff;

    @FXML
    private void modifierex(ActionEvent event) {
       modifierex.setOnAction(n-> {
 Examen ref = table.getSelectionModel().getSelectedItem();

 Affichier_examenController.id_ex=ref.getId_examen();
 Affichier_examenController.id_mat=ref.getId_matiere();
 Affichier_examenController.date_e=ref.getDate_examen();
 Affichier_examenController.coeff=ref.getCoefficient();


 
 
           // AfficheremployeController.vv = selectedItems.toString().split(",")[0].substring(1);
             
            try {
            Parent root = FXMLLoader.load(getClass().getResource("Modifier_examen.fxml"));
            Stage stage = (Stage) modifierex.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
           
        } catch (IOException ex) {
            Logger.getLogger(Afficher_noteController.class.getName()).log(Level.SEVERE, null, ex);
        }
                });
        
    }

    @FXML
    private void annuler(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Mexam.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) annuler.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }

    
}

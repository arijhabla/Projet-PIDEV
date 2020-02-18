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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
 * @author BEN SAID
 */
public class Afficher_calandrierController implements Initializable {
    @FXML
    private TableColumn<Calandrier_e, Integer> idc;
    @FXML
    private TableColumn<Calandrier_e, Integer> idex;
    @FXML
    private TableColumn<Calandrier_e, Integer> idm;
    @FXML
    private TableColumn<Calandrier_e, Integer> ids;
    @FXML
    private TableColumn<Calandrier_e, Integer> idcl;
    @FXML
    private TableColumn<Calandrier_e, String> nomex;
    @FXML
    private TableColumn<Calandrier_e, String> datee;
    
     ObservableList<Calandrier_e> data=FXCollections.observableArrayList();
     @FXML
    private TableView<Calandrier_e> table;
    @FXML
    private Button sup;
    @FXML
    private Button modifierca;
   public static Integer id_c;
    public static Integer id_ex;
public static Integer id_mat;
public static Integer id_sal;
public static Integer id_clas;
public static String nom_e;
public static String date_e;
    @FXML
    private Button annuler;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             ServiceCalandrier_e ce= new ServiceCalandrier_e();
           // List<Command> list = sp.readAll();
            
            data.addAll(ce.readAll());
            
         idc.setCellValueFactory(new PropertyValueFactory<Calandrier_e,Integer>("id_calandrier"));
            idex.setCellValueFactory(new PropertyValueFactory<Calandrier_e,Integer>("id_examen"));
            idm.setCellValueFactory(new PropertyValueFactory<Calandrier_e,Integer>("id_matiere"));
                       ids.setCellValueFactory(new PropertyValueFactory<Calandrier_e,Integer>("id_salle"));
                       idcl.setCellValueFactory(new PropertyValueFactory<Calandrier_e,Integer>("id_classe"));
                       nomex.setCellValueFactory(new PropertyValueFactory<Calandrier_e,String>("nom"));
                       datee.setCellValueFactory(new PropertyValueFactory<Calandrier_e,String>("date_ex"));

            table.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_calandrierController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    } 

    public TableColumn<Calandrier_e, Integer> getIdc() {
        return idc;
    }

    public void setIdc(TableColumn<Calandrier_e, Integer> idc) {
        this.idc = idc;
    }

    public TableColumn<Calandrier_e, Integer> getIdex() {
        return idex;
    }

    public void setIdex(TableColumn<Calandrier_e, Integer> idex) {
        this.idex = idex;
    }

    public TableColumn<Calandrier_e, Integer> getIdm() {
        return idm;
    }

    public void setIdm(TableColumn<Calandrier_e, Integer> idm) {
        this.idm = idm;
    }

    public TableColumn<Calandrier_e, Integer> getIds() {
        return ids;
    }

    public void setIds(TableColumn<Calandrier_e, Integer> ids) {
        this.ids = ids;
    }

    public TableColumn<Calandrier_e, Integer> getIdcl() {
        return idcl;
    }

    public void setIdcl(TableColumn<Calandrier_e, Integer> idcl) {
        this.idcl = idcl;
    }

    public TableColumn<Calandrier_e, String> getNomex() {
        return nomex;
    }

    public void setNomex(TableColumn<Calandrier_e, String> nomex) {
        this.nomex = nomex;
    }

    public TableColumn<Calandrier_e, String> getDatee() {
        return datee;
    }

    public void setDatee(TableColumn<Calandrier_e, String> datee) {
        this.datee = datee;
    }

   

    public ObservableList<Calandrier_e> getData() {
        return data;
    }

    public void setData(ObservableList<Calandrier_e> data) {
        this.data = data;
    }

    public TableView<Calandrier_e> getTable() {
        return table;
    }

    public void setTable(TableView<Calandrier_e> table) {
        this.table = table;
    }

    public Button getSup() {
        return sup;
    }

    public void setSup(Button sup) {
        this.sup = sup;
    }
    


    @FXML
    private void supprimer(ActionEvent event) {
        try {
             Calandrier_e c = (Calandrier_e) table.getSelectionModel().getSelectedItem();
             ServiceCalandrier_e ce = new ServiceCalandrier_e();
            // as.delete(e);
             
           //  ArrayList arraylist = (ArrayList) as.afficher(e.getId_employe());
               ce.delete(c);
              
              table.getItems().removeAll(c);

         } catch (SQLException ex) {
             Logger.getLogger(Afficher_calandrierController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    

    @FXML
    private void modifierca(ActionEvent event) {
     modifierca.setOnAction(e-> {
 Calandrier_e ref = table.getSelectionModel().getSelectedItem();
 Afficher_calandrierController.id_c=ref.getId_calandrier();
 Afficher_calandrierController.id_ex=ref.getId_examen();
 Afficher_calandrierController.id_mat=ref.getId_matiere();
 Afficher_calandrierController.id_sal=ref.getId_salle();
 Afficher_calandrierController.id_clas=ref.getId_classe();
 Afficher_calandrierController.nom_e=ref.getNom();
  Afficher_calandrierController.date_e=ref.getDate_ex();

 
 
           // AfficheremployeController.vv = selectedItems.toString().split(",")[0].substring(1);
             
            try {
            Parent root = FXMLLoader.load(getClass().getResource("Modifier_calandrier.fxml"));
            Stage stage = (Stage) modifierca.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
           
        } catch (IOException ex) {
            Logger.getLogger(Afficher_calandrierController.class.getName()).log(Level.SEVERE, null, ex);
        }
                });
     
      
        
    }

    @FXML
    private void annuler(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Mcalandrier.fxml"));
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
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.gui;

import com.esprit.Entite.Calandrier_e;
import com.esprit.Entite.Examen;
import com.esprit.Service.ServiceCalandrier_e;
import com.esprit.Service.ServiceExamen;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author BEN SAID
 */
public class Modifier_calandrierController implements Initializable {
    @FXML
    private ComboBox<Integer> idem;
    @FXML
    private ComboBox<Integer> idmm;
    @FXML
    private TextField idsm;
    @FXML
    private TextField idcm;
    @FXML
    private ComboBox<String> nomm;
    @FXML
    private DatePicker datecm;
    @FXML
    private Button modifierc;
    @FXML
    private Button annulerc;
    @FXML
    private Button refrech;

   ObservableList<String> nomlist = FXCollections.observableArrayList("math", "science","arabe","francais","anglais","sport");
    
 
public static Calandrier_e C;

    public static Calandrier_e getC() {
        return C;
    }

    public static void setC(Calandrier_e C) {
        Modifier_calandrierController.C = C;
    }
    @FXML
    private TextField idcal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       nomm.setValue("Enseignant");
        nomm.setItems(nomlist);
        ServiceExamen sx=new ServiceExamen();
        List<Examen> lee= new ArrayList();
        try
        {
        lee=sx.readAll();
        for(int i=0;i<lee.size();i++)
        {
        idem.getItems().add(i,lee.get(i).getId_examen());
        }
        }catch(SQLException ex){
        Logger.getLogger(Ajouter_calandrierController.class.getName()).log(Level.SEVERE,null,ex);
        }
        try
        {
        lee=sx.readAll();
        for(int i=0;i<lee.size();i++)
        {
       idmm.getItems().add(i,lee.get(i).getId_matiere());
        }
        }catch(SQLException ex){
        Logger.getLogger(Ajouter_calandrierController.class.getName()).log(Level.SEVERE,null,ex);
        }
        // TODO
    }    

    @FXML
    private void modifierc(ActionEvent event) throws SQLException {
        int id_calandrier=Integer.parseInt(idcm.getText());
        int id_examen=idem.getValue();
         int id_matiere=idmm.getValue();
        int id_salle=Integer.parseInt(idsm.getText());
        int id_classe=Integer.parseInt(idcm.getText());
      String nom = nomm.getSelectionModel().getSelectedItem().toString();
        Timestamp date_ex = Timestamp.valueOf(datecm.getValue().atTime(LocalTime.MIDNIGHT));
        Calandrier_e cae = new Calandrier_e(id_calandrier,id_examen,id_matiere,id_salle,id_classe, nom,date_ex);
        ServiceCalandrier_e ce =ServiceCalandrier_e.getInstance();


ce.update(cae);
    }
    

    @FXML
    private void annulerc(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Afficher_calandrier.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) annulerc.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void refrech(ActionEvent event) {
       System.out.println(C.getId_calandrier());
        ServiceCalandrier_e sc = new ServiceCalandrier_e();
        idcal.setText(Integer.toString(C.getId_calandrier()));
        idsm.setText(Integer.toString(C.getId_salle()));
        idcm.setText(Integer.toString(C.getId_classe()));
       
        
        
      
    }
    
}

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
import com.esprit.Utils.DataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Ajouter_calandrierController implements Initializable {

    @FXML
    private ComboBox<Integer> fid_examen;
    @FXML
    private ComboBox<Integer> fid_matiere;
    @FXML
    private TextField fid_salle;
    @FXML
    private TextField fid_classe;
    @FXML
    private ComboBox<String> fnom;
    @FXML
    private DatePicker fdate;
    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;
    //fid_examen<Examen>.getitems().add(rs.getInteger(id_examen));
//String a="SELECT id_examen FROM examen";

    private Connection con;
    private Statement ste;

   

    //ObservableList<Integer> cbex = FXCollections.observableArrayList(getitems().add(a.getInteger("id_examen")));
    ObservableList<String> nomlist = FXCollections.observableArrayList("math", "science", "arabe", "francais", "anglais", "sport");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fnom.setValue("math");
        fnom.setItems(nomlist);
        ServiceExamen sx=new ServiceExamen();
        List<Examen> lee= new ArrayList();
        try
        {
        lee=sx.readAll();
        for(int i=0;i<lee.size();i++)
        {
        fid_examen.getItems().add(i,lee.get(i).getId_examen());
        }
        }catch(SQLException ex){
        Logger.getLogger(Ajouter_calandrierController.class.getName()).log(Level.SEVERE,null,ex);
        }
        try
        {
        lee=sx.readAll();
        for(int i=0;i<lee.size();i++)
        {
        fid_matiere.getItems().add(i,lee.get(i).getId_matiere());
        }
        }catch(SQLException ex){
        Logger.getLogger(Ajouter_calandrierController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
        // TODO

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
 
        try {
            //int id_examen = fid_examen.getValue();
          //int id_examen = fid_examen.getSelectionModel().getSelectedIndex();
            //int id_examen = fid_examen.getSelectionModel().getSelectedItem().toInt();
            //int id_examen = Integer.parseInt(fid_examen.getText ());
            int id_examen=fid_examen.getValue();
            int id_matiere = fid_matiere.getValue();
            int id_salle = Integer.parseInt(fid_salle.getText());
            int id_classe = Integer.parseInt(fid_classe.getText());

            String nom = fnom.getSelectionModel().getSelectedItem().toString();
            Timestamp date_ex = Timestamp.valueOf(fdate.getValue().atTime(LocalTime.MIDNIGHT));

            System.out.println(nom);
            Calandrier_e c = new Calandrier_e(id_examen, id_matiere, id_salle, id_classe, nom, date_ex);
            ServiceCalandrier_e ce = new ServiceCalandrier_e();
            ce.ajouter(c);
        } catch (SQLException ex) {
            Logger.getLogger(Ajouter_calandrierController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

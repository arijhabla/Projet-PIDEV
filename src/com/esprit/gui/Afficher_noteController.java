/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.Entite.Note;
import com.esprit.Service.ServiceNote;
import com.esprit.Utils.DataBase;
import com.gembox.spreadsheet.ExcelColumnCollection;
import com.gembox.spreadsheet.ExcelFile;
import com.gembox.spreadsheet.ExcelWorksheet;
import com.gembox.spreadsheet.SpreadsheetInfo;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import com.restfb.types.Group;
import com.restfb.types.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * FXML Controller class
 *
 * @author BEN SAID
 */
public class Afficher_noteController implements Initializable {

    @FXML
    private TableColumn<Note, Integer> tide;
    @FXML
    private TableColumn<Note, Integer> tidex;
    @FXML
    private TableColumn<Note, Integer> tidm;
    @FXML
    private TableColumn<Note, Float> tnote;
    @FXML
    private TableColumn<Note, Integer> tidnote;

    ObservableList<Note> data = FXCollections.observableArrayList();
    @FXML
    public TableView<Note> tab;
    @FXML
    private Button supp;
    @FXML
    private Button modifierno;

    public static Integer id_e;
    public static Integer id_ex;
    public static Integer id_mat;
    public static Float not;
    public static Integer id_not;
    public static String nom_matier;
    public static String mail;
    public static String motdp;
    public static Timestamp date;
    @FXML
    private Button annuler;
    @FXML
    private TableColumn<Note, String> nommat;
    @FXML
    private TableColumn<Note, String> maill;
    @FXML
    private TableColumn<Note, String> mdp;
    @FXML
    private TableColumn<Note, Timestamp> daate;
    @FXML
    private Button save;
    private Connection con;
    private Statement ste;
    private ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ServiceNote no = new ServiceNote();
           // List<Command> list = sp.readAll();

            data.addAll(no.readAll());

            tide.setCellValueFactory(new PropertyValueFactory<Note, Integer>("id_eleve"));
            tidex.setCellValueFactory(new PropertyValueFactory<Note, Integer>("id_examen"));
            tidm.setCellValueFactory(new PropertyValueFactory<Note, Integer>("id_matiere"));
            tnote.setCellValueFactory(new PropertyValueFactory<Note, Float>("note"));
            tidnote.setCellValueFactory(new PropertyValueFactory<Note, Integer>("id_note"));
            nommat.setCellValueFactory(new PropertyValueFactory<Note, String>("nom_matiere"));
            maill.setCellValueFactory(new PropertyValueFactory<Note, String>("id_examen"));
            mdp.setCellValueFactory(new PropertyValueFactory<Note, String>("id_matiere"));
            daate.setCellValueFactory(new PropertyValueFactory<Note, Timestamp>("date"));

            tab.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_noteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO

    }

    public TableColumn<Note, String> getNommat() {
        return nommat;
    }

    public void setNommat(TableColumn<Note, String> nommat) {
        this.nommat = nommat;
    }

    public TableColumn<Note, String> getMaill() {
        return maill;
    }

    public void setMaill(TableColumn<Note, String> maill) {
        this.maill = maill;
    }

    public TableColumn<Note, String> getMdp() {
        return mdp;
    }

    public void setMdp(TableColumn<Note, String> mdp) {
        this.mdp = mdp;
    }

    public TableColumn<Note, Timestamp> getDaate() {
        return daate;
    }

    public void setDaate(TableColumn<Note, Timestamp> daate) {
        this.daate = daate;
    }

    public TableColumn<Note, Integer> getTide() {
        return tide;
    }

    public void setTide(TableColumn<Note, Integer> tide) {
        this.tide = tide;
    }

    public TableColumn<Note, Integer> getTidex() {
        return tidex;
    }

    public void setTidex(TableColumn<Note, Integer> tidex) {
        this.tidex = tidex;
    }

    public TableColumn<Note, Integer> getTidm() {
        return tidm;
    }

    public void setTidm(TableColumn<Note, Integer> tidm) {
        this.tidm = tidm;
    }

    public TableColumn<Note, Float> getTnote() {
        return tnote;
    }

    public void setTnote(TableColumn<Note, Float> tnote) {
        this.tnote = tnote;
    }

    public TableColumn<Note, Integer> getTidnote() {
        return tidnote;
    }

    public void setTidnote(TableColumn<Note, Integer> tidnote) {
        this.tidnote = tidnote;
    }

    public ObservableList<Note> getData() {
        return data;
    }

    public void setData(ObservableList<Note> data) {
        this.data = data;
    }

    public TableView<Note> getTab() {
        return tab;
    }

    public void setTab(TableView<Note> tab) {
        this.tab = tab;
    }

    public Button getSupp() {
        return supp;
    }

    public void setSupp(Button supp) {
        this.supp = supp;
    }

    @FXML
    private void supprimer(ActionEvent event) {

        try {
            Note n = (Note) tab.getSelectionModel().getSelectedItem();
            ServiceNote no = new ServiceNote();
            // as.delete(e);

            //  ArrayList arraylist = (ArrayList) as.afficher(e.getId_employe());
            no.delete(n);

            tab.getItems().removeAll(n);
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_noteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modifierno(ActionEvent event) {
        modifierno.setOnAction(n -> {
            Note ref = tab.getSelectionModel().getSelectedItem();
            Afficher_noteController.id_e = ref.getId_eleve();
            Afficher_noteController.id_ex = ref.getId_examen();
            Afficher_noteController.id_mat = ref.getId_matiere();
            Afficher_noteController.not = ref.getNote();
            Afficher_noteController.id_not = ref.getId_note();
            Afficher_noteController.nom_matier = ref.getNom_matiere();
            Afficher_noteController.mail = ref.getMail();
            Afficher_noteController.motdp = ref.getMdp();
            Afficher_noteController.date = ref.getDate();

           // AfficheremployeController.vv = selectedItems.toString().split(",")[0].substring(1);
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Modifier_note.fxml"));
                Stage stage = (Stage) modifierno.getScene().getWindow();
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

            Parent root = FXMLLoader.load(getClass().getResource("Mnote.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) annuler.getScene().getWindow();
            stage.close();

            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void save(ActionEvent event) throws IOException, SQLException {
       //besoins ref = table.getSelectionModel().getSelectedItem();
//String nom_produit = ref.getNom_produit();
//int bes = ref.getNos_besoins();
  String accessToken="EAADyHGgwtGUBABUouu0ZA5OZCzl5yQgMKJe330Dl9c58IotpGDfYUbEklMUjigqiHfHBZB4COgmZAcoajOdw7ZCi83L679wg2pActXil3srwfaRL2mcd8K9WJQssRdkgPZCPT7LAcvGRk3fz7xovSXvcewHAgh8csETeaNEZBQZCwXLIkiH2w5KZC3KAdZATZBpEf7IeeA39WrMl7B5D6xLQ9qZAtPzY02CZA8ZAvYOZAqMIKeyNwZDZD";
     //Scanner s = new  Scanner(System.in);
FacebookClient fbClient;
    fbClient = new DefaultFacebookClient(accessToken,Version.VERSION_6_0);
    Connection<Group> result = fbClient.fetchConnection("me/groups",Group.class);
    for(List<Group> GroupPage: result){
        for(Group aGroup : GroupPage)
        {
           // System.out.println(aGroup.getName());
                 /*System.out.println("do you want to post in this page ?");
                       String ans = s.nextLine();*/
                      if(aGroup.getName().equalsIgnoreCase("Test")){
                          // System.err.println("what to want to post");
                               String msg = "Examen reporté ";
    FacebookType response= fbClient.publish(aGroup.getId()+"/feed", FacebookType.class,Parameter.with("message",msg));
    System.out.println("fb.com/"+response.getId());

                       }
        }
    }

}}

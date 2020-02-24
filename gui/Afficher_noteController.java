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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ResourceBundle;
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
      /*
            //String query="select * from note ";

            con = DataBase.getInstance().getConnection();

                ste = con.createStatement();
                ResultSet rs = ste.executeQuery("select * from note");
//          rs.next();
//          
//                System.out.println(rs.getInt("id_eleve"));
         
            // ResultSet rs = (ResultSet) ste.executeQuery(query);
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("user details");
            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("id_eleve");
            header.createCell(1).setCellValue("id_examen");
            header.createCell(2).setCellValue("id_matiere");
            header.createCell(3).setCellValue("note");
            header.createCell(4).setCellValue("id_note");
            header.createCell(5).setCellValue("nom_matiere");
            header.createCell(6).setCellValue("mail");
            header.createCell(7).setCellValue("mdp");
            header.createCell(8).setCellValue("date");

            int index = 1;
            while (rs.next()) {
                XSSFRow row = sheet.createRow(index);
                row.createCell(0).setCellValue(Integer.toString(rs.getInt("id_eleve")));
                row.createCell(1).setCellValue(Integer.toString(rs.getInt("id_examen")));
                row.createCell(2).setCellValue(Integer.toString(rs.getInt("id_matiere")));
                row.createCell(3).setCellValue(Integer.toString(rs.getInt("note")));
                row.createCell(4).setCellValue(Integer.toString(rs.getInt("id_note")));
                row.createCell(5).setCellValue(rs.getString("nom_matiere"));
                row.createCell(6).setCellValue(rs.getString("mail"));
                row.createCell(7).setCellValue(rs.getString("mdp"));
                row.createCell(8).setCellValue(rs.getTimestamp("date"));
                index++;
            }
            FileOutputStream fileOut = new FileOutputStream("userDetails.xlsx");
            wb.write(fileOut);
            fileOut.close();
        //ste.close();
            //rs.close();
            System.out.println("bug is note here");

        

    }*/

try {
String recipient = "55303078";
String message = " Greetings from Mr. Gupta! Have a nice day!";
String username = "admin";
String password = "abc123";
String originator = "55303078";
String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&username=admin&password=abc123&" +
 "username=" + URLEncoder.encode(username, "UTF-8") +
 "&password=" + URLEncoder.encode(password, "UTF-8") +
 "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
 "&messagetype=SMS:TEXT" +
 "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
 "&originator=" + URLEncoder.encode(originator, "UTF-8") +
 "&serviceprovider=GSMModem1" +
 "&responseformat=html";
URL url = new URL(requestUrl);
HttpURLConnection uc = (HttpURLConnection)url.openConnection();
System.out.println(uc.getResponseMessage());
uc.disconnect();
} catch(Exception ex) {
System.out.println(ex.getMessage());
}


}}

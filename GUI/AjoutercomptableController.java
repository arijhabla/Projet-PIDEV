/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.GUI;

import com.esprit.Entite.Comptable;
import com.esprit.Service.ServiceComptable;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class AjoutercomptableController implements Initializable {
    @FXML
    private TextField nomc;
    @FXML
    private TextField prenomc;
    @FXML
    private ComboBox etatc;
    @FXML
    private TextField telc;
    @FXML
    private TextField adressec;
    @FXML
    private Button ajouter;
    ObservableList<String> rolelist = FXCollections.observableArrayList("En congé", "Travaille");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        etatc.setValue("En congé");
        etatc.setItems(rolelist);
        
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        
         if (nomc.getText().isEmpty() || prenomc.getText().isEmpty() || etatc.getSelectionModel().getSelectedItem().toString().isEmpty() || telc.getText().isEmpty() || adressec.getText().isEmpty()) {

             System.out.println("remplir les informations");
            /*Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Ooops, missing information!");

            alert.showAndWait();*/
        } else {
                   try {
            String nom_comptable=nomc.getText();
            String prenom_comptable=prenomc.getText();
            String etat_comptable=etatc.getSelectionModel().getSelectedItem().toString();
            int telephone_comptable=Integer.parseInt(telc.getText());
            String adressemail_comptable=adressec.getText();
            
            
            
            System.out.println(nom_comptable);
            Comptable cmp= new Comptable(0,nom_comptable,prenom_comptable,etat_comptable,telephone_comptable,adressemail_comptable);
            ServiceComptable sc=ServiceComptable.getInstance(); 
            sc.ajouter(cmp);
            
            
            //mail 
     
            try {
                    String host = "smtp.gmail.com";
                    String user = "openquantumpidev@gmail.com";
                    String pass = "pidev1230";
                    
                    String to = adressec.getText();
                    String from = "thelostloki@gmail.com";
                    String subject = "Welcome To EasyChool";
                    String messageText = "Welcome ToEasyChool " + "Mr/Mme." + nomc.getText();
                    boolean sessionDebug = false;

                    Properties props = System.getProperties();

                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", host);
                    props.put("mail.smtp.port", "587");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.required", "true");

                    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                    Session mailSession = Session.getDefaultInstance(props, null);
                    mailSession.setDebug(sessionDebug);
                    Message msg = new MimeMessage(mailSession);
                    msg.setFrom(new InternetAddress(from));
                    InternetAddress[] address = {new InternetAddress(to)};
                    msg.setRecipients(Message.RecipientType.TO, address);
                    msg.setSubject(subject);
                    //msg.setSentDate(new Date());
                    msg.setText(messageText);

                    Transport transport = mailSession.getTransport("smtp");
                    transport.connect(host, user, pass);
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();
                    System.out.println("message send successfully");
                } catch (Exception ex) {
                    System.out.println(ex);

                }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }

         }       
         
                   
                   
                   
        
    }

}
    

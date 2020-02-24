/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import com.esprit.Entite.salle;
import com.esprit.Service.Servicesalle;
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
 * @author dell
 */
public class AffichersalleController implements Initializable {
    @FXML
    private Button modifiersalle;
    @FXML
    private Button supprimersalle;
    @FXML
    private Button affichersalle;
    @FXML
    private TableView<salle> tab1;
     private ObservableList<salle> data=FXCollections.observableArrayList();
    @FXML
    private TableColumn<salle, Integer> tfids;
    @FXML
    private TableColumn<salle, Integer> tfcap;
    public static Integer id_salle;
    public static Integer capacite;
    @FXML
    private Button backk;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifiersalle(ActionEvent event) {
              modifiersalle.setOnAction(e-> {
 salle ref = tab1.getSelectionModel().getSelectedItem();
 AffichersalleController.id_salle=ref.getId_salle();
 AffichersalleController.capacite=ref.getCapacite();
             
            try {
            Parent root = FXMLLoader.load(getClass().getResource("Modifiersalle.fxml"));
            Stage stage = (Stage) modifiersalle.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AffichersalleController.class.getName()).log(Level.SEVERE, null, ex);
        }
                });
    }

    @FXML
    private void supprimersalle(ActionEvent event) {
          try {
             salle s = (salle) tab1.getSelectionModel().getSelectedItem();
             Servicesalle s1 = new Servicesalle();
            
               s1.delete(s);
               tab1.getItems().removeAll(s);
         } catch (SQLException ex) {
             Logger.getLogger(AffichersalleController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    private void affichersalle(ActionEvent event) {
            try {
            Servicesalle ss= new Servicesalle();
           // List<Command> list = sp.readAll();
            
            data.addAll(ss.readAll());
            
            tfids.setCellValueFactory(new PropertyValueFactory<salle,Integer>("id_salle"));
            tfcap.setCellValueFactory(new PropertyValueFactory<salle,Integer>("capacite"));
           
            tab1.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherclasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void backk(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("gotosalle.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) backk.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    }
    


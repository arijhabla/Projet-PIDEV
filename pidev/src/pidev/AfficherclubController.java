/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev;

import com.esprit.Service.ServiceClub;
import com.esprit.entite.Club;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khadija
 */
public class AfficherclubController implements Initializable {
    @FXML
    private TableView<Club> table;
    @FXML
    private TableColumn<Club,Integer> id;
   @FXML
    private TableColumn<Club,String> nom;
    @FXML
    private TableColumn<Club,String> type;
    @FXML
    private Button afficher;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button back;
    private ObservableList<Club> data=FXCollections.observableArrayList();
    @FXML
    private TextField filterField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    public void setTab(TableView<Club> table) {
        this.table = table;
    }

    public void setId(TableColumn<Club, Integer> id) {
        this.id = id;
    }

    public void setNom(TableColumn<Club, String> nom) {
        this.nom = nom;
    }

    public void setPrenom(TableColumn<Club, String> type) {
        this.type = type;
    }


    public void setAff(Button afficher) {
        this.afficher = afficher;
    }

    public void setData(ObservableList<Club> data) {
        this.data = data;
    }
    
    public void aff(){
        try {
            ServiceClub sc= new ServiceClub();
           // List<Command> list = sp.readAll();
            
            data.addAll(sc.readAll());
            
            id.setCellValueFactory(new PropertyValueFactory<Club,Integer>("id_club"));
            nom.setCellValueFactory(new PropertyValueFactory<Club,String>("nom_club"));
            type.setCellValueFactory(new PropertyValueFactory<Club,String>("type_club"));
           
            table.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherclubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afficher(ActionEvent event) {
        afficher.setOnAction(e-> {
           afficher.setDisable(true);
            aff();
           
         }); 
        
        
    }
    

    @FXML
    private void supprimer(ActionEvent event) {
        try {
             Club c = (Club) table.getSelectionModel().getSelectedItem();
             ServiceClub sc = new ServiceClub();
            // as.delete(e);
             
           //  ArrayList arraylist = (ArrayList) as.afficher(e.getId_employe());
               sc.delete(c);
               table.getItems().removeAll(c);
              aff();
           

         } catch (SQLException ex) {
             Logger.getLogger(AfficherclubController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void back(ActionEvent event) {
        
        try {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    Stage stage = (Stage) back.getScene().getWindow();
    stage.close();
    Scene scene =new Scene(root);
    stage.setScene(scene);
    stage.show();
    }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    
    
    }
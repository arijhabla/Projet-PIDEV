/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.gui;

import com.esprit.Entite.classe;
import com.esprit.Entite.matiere;
import com.esprit.Service.Servicematiere;
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
public class AffichermatiereController implements Initializable {
    @FXML
    private TableView<matiere> tabv;
     private ObservableList<matiere> data=FXCollections.observableArrayList();
    @FXML
    private TableColumn<matiere, Integer> idmat;
    @FXML
    private TableColumn<matiere, String> tfnom;
    @FXML
    private TableColumn<matiere, Integer> tfh;
    @FXML
    private Button affichermat;
    @FXML
    private Button suppmat;
    @FXML
    private Button modmat;
    @FXML
    private Button back3;
    public static Integer id_matiere;
    public static String nom_matiere;
    public static Integer nbr_heures;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void affichermat(ActionEvent event) {
                  try {
            Servicematiere sm= new Servicematiere();
           // List<Command> list = sp.readAll();
            
            data.addAll(sm.readAll());
            
            idmat.setCellValueFactory(new PropertyValueFactory<matiere,Integer>("id_matiere"));
            tfnom.setCellValueFactory(new PropertyValueFactory<matiere,String>("nom_matiere"));
            tfh.setCellValueFactory(new PropertyValueFactory<matiere,Integer>("nbr_heures"));
           
            tabv.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(AffichermatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @FXML
    private void suppmat(ActionEvent event) {
           try {
             matiere m= (matiere) tabv.getSelectionModel().getSelectedItem();
             Servicematiere ss = new Servicematiere();
            
               ss.delete(m);
               tabv.getItems().removeAll(m);
         } catch (SQLException ex) {
             Logger.getLogger(AfficherclasseController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    private void back3(ActionEvent event) {
            try {
            
            Parent root = FXMLLoader.load(getClass().getResource("gotomat.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) back3.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void modmat(ActionEvent event) {
            modmat.setOnAction(e-> {
 matiere ref = tabv.getSelectionModel().getSelectedItem();
 AffichermatiereController.id_matiere=ref.getId_matiere();
 AffichermatiereController.nom_matiere=ref.getNom_matiere();
 AffichermatiereController.nbr_heures=ref.getNbr_heures();
             
            try {
            Parent root = FXMLLoader.load(getClass().getResource("Modifiermat.fxml"));
            Stage stage = (Stage) modmat.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherclasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
                });
    }
    }
    


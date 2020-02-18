/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.com.gui;

import com.esprit.Entite.classe;
import com.esprit.Service.Serviceclasse;
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
public class AfficherclasseController implements Initializable {
    
    @FXML
    private TableColumn<classe,Integer> tfid;
    @FXML
    private Button afficher;
    @FXML
    private TableView<classe> table;
    private ObservableList<classe> data=FXCollections.observableArrayList();
    @FXML
    private TableColumn<classe,Integer> tff;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    public static Integer nbr_eleves;
    public static Integer id_classe;
  
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setTab(TableView<classe> table) {
        this.table = table;
    }

    public void setId(TableColumn<classe,Integer> id_classe) {
        this.tfid = id_classe;
    }

    public void setNbre(TableColumn<classe,Integer>nbr_eleves) {
        this.tff = nbr_eleves;
    }

  

    public void setAff(Button affcher) {
        this.afficher = afficher;
    }

    public void setData(ObservableList<classe> data) {
        this.data = data;
    }

    @FXML
    private void afficher(ActionEvent event) {
           try {
            Serviceclasse sc= new Serviceclasse();
           // List<Command> list = sp.readAll();
            
            data.addAll(sc.readAll());
            
            tfid.setCellValueFactory(new PropertyValueFactory<classe,Integer>("id_classe"));
            tff.setCellValueFactory(new PropertyValueFactory<classe,Integer>("nbr_eleves"));
           
            table.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherclasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
        
        
        try {
             classe e = (classe) table.getSelectionModel().getSelectedItem();
             Serviceclasse as = new Serviceclasse();
            
               as.delete(e);
               table.getItems().removeAll(e);
         } catch (SQLException ex) {
             Logger.getLogger(AfficherclasseController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    private void modifier(ActionEvent event) {
        modifier.setOnAction(e-> {
 classe ref = table.getSelectionModel().getSelectedItem();
 AfficherclasseController.id_classe=ref.getId_classe();
 AfficherclasseController.nbr_eleves=ref.getNbr_eleves();
             
            try {
            Parent root = FXMLLoader.load(getClass().getResource("Modifierclasse.fxml"));
            Stage stage = (Stage) modifier.getScene().getWindow();
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

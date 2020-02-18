/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.com.gui;

import com.esprit.Entite.classe;
import com.esprit.Entite.emploidutemps;
import com.esprit.Service.Serviceclasse;
import com.esprit.Service.Serviceemploi;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AfficherempController implements Initializable {
@FXML
    private TableColumn<emploidutemps,Integer> tfide;
@FXML
    private TableColumn<emploidutemps,String> tfnome;
    @FXML
    private Button afficheremp;
    private TableView<emploidutemps> tab;
    private ObservableList<emploidutemps> data=FXCollections.observableArrayList();
    @FXML
    private Button supprimeremp;
  
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setTab(TableView<emploidutemps> table) {
        this.tab= table;
    }

    public void setId(TableColumn<emploidutemps,Integer> id_emploi) {
        this.tfide= id_emploi;
    }

    public void setNom(TableColumn<emploidutemps,String>nom_emp) {
        this.tfnome = nom_emp;
    }

  

    public void setAff(Button afficheremp) {
        this.afficheremp = afficheremp;
    }

    public void setData(ObservableList<emploidutemps> data) {
        this.data = data;
    }

    @FXML
    private void afficheremp(ActionEvent event) {
           try {
            Serviceemploi se= new Serviceemploi();
           // List<Command> list = sp.readAll();
            
            data.addAll(se.readAll());
            
            tfide.setCellValueFactory(new PropertyValueFactory<emploidutemps,Integer>("id_emploi"));
            tfnome.setCellValueFactory(new PropertyValueFactory<emploidutemps,String>("nom_emp"));
           
            tab.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherempController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }

    @FXML
   private void supprimeremp(ActionEvent event) {
        
        
        try {
             emploidutemps e = (emploidutemps) tab.getSelectionModel().getSelectedItem();
             Serviceemploi as = new Serviceemploi();
            // as.delete(e);
             
           //  ArrayList arraylist = (ArrayList) as.afficher(e.getId_employe());
               as.delete(e);
              
            tfide.setCellValueFactory(new PropertyValueFactory<>("id_emploi"));
            tfnome.setCellValueFactory(new PropertyValueFactory<>("nom_emp"));
         } catch (SQLException ex) {
             Logger.getLogger(AfficherempController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
  
    


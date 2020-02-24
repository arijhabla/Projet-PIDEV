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
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
 * @author dell
 */
public class AfficherempController implements Initializable {
@FXML
    private TableColumn<emploidutemps,Integer> tfide;
@FXML
    private TableColumn<emploidutemps,String> tfnome;
    @FXML
    private Button afficheremp;
    @FXML
    private TableView<emploidutemps> tab;
    private ObservableList<emploidutemps> data=FXCollections.observableArrayList();
    @FXML
    private Button supprimeremp;
    @FXML
    private Button modifiere;
    @FXML
    private Button BACK5;
    public static Integer id_emploi;
    public static String nom_emploi;
    @FXML
    private TextField filterField;
  
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FilteredList<emploidutemps> filteredData = new FilteredList<>(data, b -> true);
          filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(emploidutemps -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (emploidutemps.getNom_emp().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
                                }
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<emploidutemps> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tab.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
tab.setItems(sortedData);
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
             Serviceemploi se = new Serviceemploi();
            
               se.delete(e);
               tab.getItems().removeAll(e);
         } catch (SQLException ex) {
             Logger.getLogger(AfficherempController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    private void modifiere(ActionEvent event) {
         modifiere.setOnAction(e-> {
 emploidutemps ref = tab.getSelectionModel().getSelectedItem();
 AfficherempController.id_emploi=ref.getId_emploi();
 AfficherempController.nom_emploi=ref.getNom_emp();
             
            try {
            Parent root = FXMLLoader.load(getClass().getResource("Modifieremp.fxml"));
            Stage stage = (Stage) modifiere.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherempController.class.getName()).log(Level.SEVERE, null, ex);
        }
                });
    }

    @FXML
    private void BACK5(ActionEvent event) {
             try {
            
            Parent root = FXMLLoader.load(getClass().getResource("gotoemp.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) BACK5.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
    }

  
    


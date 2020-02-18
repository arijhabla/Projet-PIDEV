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
    public static String nom_c;
public static String type_c;
public static Integer id_c;
    @FXML
    private TextField filterField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           aff();
        FilteredList<Club> filteredData = new FilteredList<>(data, b -> true);
          filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(emp -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (emp.getNom_club().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (emp.getType_club().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Club> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
table.setItems(sortedData);
        
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
              //aff();
           

         } catch (SQLException ex) {
             Logger.getLogger(AfficherclubController.class.getName()).log(Level.SEVERE, null, ex);
         }
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

    @FXML
    private void modifier(ActionEvent event) {
        
        modifier.setOnAction(e-> {
 Club ref = table.getSelectionModel().getSelectedItem();
 AfficherclubController.id_c=ref.getId_club();
 AfficherclubController.nom_c=ref.getNom_club();
 AfficherclubController.type_c=ref.getType_club();


 
           // AfficheremployeController.vv = selectedItems.toString().split(",")[0].substring(1);
             
            try {
            Parent root = FXMLLoader.load(getClass().getResource("Updateeleve.fxml"));
            Stage stage = (Stage) modifier.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
                });
        
        
    }
    
 
    
    }
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev;

import com.esprit.Service.ServiceEvent;
import com.esprit.entite.Event;
import com.esprit.entite.Event;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
public class AffichereventController implements Initializable {
    @FXML
    private TableView<Event> table;
       @FXML
    private TableColumn<Event,Integer> id;
          @FXML
    private TableColumn<Event,String> nom;
             @FXML
    private TableColumn<Event,Date> date;
    @FXML
    private Button afficher;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button back;
  private ObservableList<Event> data=FXCollections.observableArrayList();
    public static String nom_e;
public static Date date_e;
public static Integer id_e;
    @FXML
    private TextField filterField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           aff();
        FilteredList<Event> filteredData = new FilteredList<>(data, b -> true);
          filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(emp -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (emp.getNom_event().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Event> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
table.setItems(sortedData);
        
    }    
    public void setTab(TableView<Event> table) {
        this.table = table;
    }

    public void setId(TableColumn<Event, Integer> id) {
        this.id = id;
    }

    public void setNom(TableColumn<Event, String> nom) {
        this.nom = nom;
    }

    public void setDate(TableColumn<Event, Date> date) {
        this.date = date;
    }


    public void setAff(Button afficher) {
        this.afficher = afficher;
    }

    public void setData(ObservableList<Event> data) {
        this.data = data;
    }
    
    public void aff(){
        try {
            ServiceEvent se= new ServiceEvent();
           // List<Command> list = sp.readAll();
            
            data.addAll(se.readAll());
            
           id.setCellValueFactory(new PropertyValueFactory<Event,Integer>("id_event"));
           nom.setCellValueFactory(new PropertyValueFactory<Event,String>("nom_event"));
           date.setCellValueFactory(new PropertyValueFactory<Event,Date>("date_event"));
           
            table.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(AffichereventController.class.getName()).log(Level.SEVERE, null, ex);
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
             Event c = (Event) table.getSelectionModel().getSelectedItem();
             ServiceEvent sc = new ServiceEvent();
            // as.delete(e);
             
           //  ArrayList arraylist = (ArrayList) as.afficher(e.getId_employe());
               sc.delete(c);
               table.getItems().removeAll(c);
              //aff();
           

         } catch (SQLException ex) {
             Logger.getLogger(AffichereventController.class.getName()).log(Level.SEVERE, null, ex);
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
 Event ref = table.getSelectionModel().getSelectedItem();
 AffichereventController.id_e=ref.getId_event();
 AffichereventController.nom_e=ref.getNom_event();
 AffichereventController.date_e=ref.getDate_event();
 


 
           // AfficheremployeController.vv = selectedItems.toString().split(",")[0].substring(1);
             
            try {
            Parent root = FXMLLoader.load(getClass().getResource("modifierevent.fxml"));
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
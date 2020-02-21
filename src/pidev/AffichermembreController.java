/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev;

import com.esprit.Service.ServiceMembre;
import com.esprit.entite.Membre;
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
public class AffichermembreController implements Initializable {
    @FXML
    private TableView<Membre> table;
    @FXML
    private TableColumn<Membre,Integer> id;
   @FXML
    private TableColumn<Membre,String> nom;
    @FXML
    private TableColumn<Membre,String> prenom;
     @FXML
    private TableColumn<Membre,Integer> age;
    @FXML
    private Button afficher;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button back;
    private ObservableList<Membre> data=FXCollections.observableArrayList();
    public static String nom_m;
public static String prenom_m;
public static Integer id_m;
public static Integer age_m;
    @FXML
    private TextField filterField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           aff();
        FilteredList<Membre> filteredData = new FilteredList<>(data, b -> true);
          filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(emp -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (emp.getNom_membre().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (emp.getPrenom_membre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Membre> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
table.setItems(sortedData);
        
    }    
    public void setTab(TableView<Membre> table) {
        this.table = table;
    }
    public void setAge(TableColumn<Membre, Integer> age) {
        this.age = age;
    }

    public void setId(TableColumn<Membre, Integer> id) {
        this.id = id;
    }

    public void setNom(TableColumn<Membre, String> nom) {
        this.nom = nom;
    }

    public void setPrenom(TableColumn<Membre, String> prenom) {
        this.prenom = prenom;
    }


    public void setAff(Button afficher) {
        this.afficher = afficher;
    }

    public void setData(ObservableList<Membre> data) {
        this.data = data;
    }
    
    public void aff(){
        try {
            ServiceMembre sc= new ServiceMembre();
           // List<Command> list = sp.readAll();
            
            data.addAll(sc.readAll());

            id.setCellValueFactory(new PropertyValueFactory<Membre,Integer>("id_membre"));
            nom.setCellValueFactory(new PropertyValueFactory<Membre,String>("nom_membre"));
            prenom.setCellValueFactory(new PropertyValueFactory<Membre,String>("prenom_membre"));
            age.setCellValueFactory(new PropertyValueFactory<Membre,Integer>("age_membre"));
           
            table.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(AffichermembreController.class.getName()).log(Level.SEVERE, null, ex);
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
             Membre c = (Membre) table.getSelectionModel().getSelectedItem();
             ServiceMembre sc = new ServiceMembre();
            // as.delete(e);
             
           //  ArrayList arraylist = (ArrayList) as.afficher(e.getId_employe());
               sc.delete(c);
               table.getItems().removeAll(c);
              //aff();
           

         } catch (SQLException ex) {
             Logger.getLogger(AffichermembreController.class.getName()).log(Level.SEVERE, null, ex);
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
 Membre ref = table.getSelectionModel().getSelectedItem();
 AffichermembreController.id_m=ref.getId_membre();
 AffichermembreController.nom_m=ref.getNom_membre();
 AffichermembreController.prenom_m=ref.getPrenom_membre();
 AffichermembreController.age_m=ref.getAge_membre();


 
           // AfficheremployeController.vv = selectedItems.toString().split(",")[0].substring(1);
             
            try {
            Parent root = FXMLLoader.load(getClass().getResource("modifiermembre.fxml"));
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
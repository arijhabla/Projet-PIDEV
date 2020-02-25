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
 * @author Pc
 */
public class AffichercomptableController implements Initializable {
    @FXML
    private TableView<Comptable> table;
    @FXML
    private TableColumn<Comptable,Integer> idc;
    @FXML
    private TableColumn<Comptable,String> nomc;
    @FXML
    private TableColumn<Comptable,String> prenomc;
    @FXML
    private TableColumn<Comptable,String> etatc;
    @FXML
    private TableColumn<Comptable,Integer> telc;
    @FXML
    private TableColumn<Comptable,String> adressec;
    private Button afficher;
    private ObservableList<Comptable> data=FXCollections.observableArrayList();
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    
public static Integer idcom;
public static String nomcom;
public static String prenomcom;
public static String etatcom;
public static Integer telcom;
public static String mailcom;
    @FXML
    private TextField filterField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
             try {
            ServiceComptable sc= new ServiceComptable();
  
            data.addAll(sc.readAll());
            
            idc.setCellValueFactory(new PropertyValueFactory<Comptable,Integer>("ID_comptable"));
            nomc.setCellValueFactory(new PropertyValueFactory<Comptable,String>("nom_comptable"));
            prenomc.setCellValueFactory(new PropertyValueFactory<Comptable,String>("prenom_comptable"));
            etatc.setCellValueFactory(new PropertyValueFactory<Comptable,String>("etat_comptable"));
            telc.setCellValueFactory(new PropertyValueFactory<Comptable,Integer>("telephone_comptable"));
            adressec.setCellValueFactory(new PropertyValueFactory<Comptable,String>("adressemail_comptable"));
           
            table.setItems(data);
            
            
                     // List<Command> list = sp.readAll();
                         FilteredList<Comptable> filteredData = new FilteredList<>(data, b -> true);
          filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(emp -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (emp.getNom_comptable().toLowerCase().indexOf(lowerCaseFilter) != -1){
                                    return true;
				} else if (emp.getPrenom_comptable().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Comptable> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
table.setItems(sortedData);


        } catch (SQLException ex) {
            Logger.getLogger(AffichercomptableController.class.getName()).log(Level.SEVERE, null, ex);
        }
             

    } 

     public void setTab(TableView<Comptable> table) {
        this.table = table;
    } 
    public void setId(TableColumn<Comptable, Integer> idc) {
        this.idc = idc;
    } 
    public void setNom(TableColumn<Comptable, String> nomc) {
        this.nomc = nomc;
    }

    public void setPrenom(TableColumn<Comptable, String> prenomc) {
        this.prenomc = prenomc;
    }

    public void setEtat(TableColumn<Comptable,String>etatc) {
        this.etatc = etatc;
    }

    public void setTelephone(TableColumn<Comptable,Integer>telc) {
        this.telc=telc;
    }
     public void setAdresse(TableColumn<Comptable,String>adressec) {
        this.adressec=adressec;
    }
    public void setAff(Button afficher) {
        this.afficher = afficher;
    }

    public void setData(ObservableList<Comptable> data) {
        this.data = data;
    }
     
    @FXML
    private void supprimer(ActionEvent event) {
    
    try {
             Comptable c = (Comptable) table.getSelectionModel().getSelectedItem();
             ServiceComptable sc = new ServiceComptable();
               sc.delete(c);
               table.getItems().removeAll(c);
         } catch (SQLException ex) {
         }
    
    }

    @FXML
    private void modifier(ActionEvent event) {
        modifier.setOnAction(e-> {
        Comptable ref = table.getSelectionModel().getSelectedItem();
                     
            try {
            Parent root = FXMLLoader.load(getClass().getResource("ModifierComptable.fxml"));
            Stage stage = (Stage) modifier.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            ModifierComptableController.setC(ref); 
                System.out.println(ref.getID_comptable());
            stage.setScene(scene);
            stage.show();
               } catch (IOException ex) {
            Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
        }
                });
    }
    
}

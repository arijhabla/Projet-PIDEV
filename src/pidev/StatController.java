/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev;

import com.esprit.Service.ServiceClub;
import com.esprit.entite.Club;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Khadija
 */
public class StatController implements Initializable {

   
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<?, ?> SalaryChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    
        private ObservableList<Club> data=FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
          /*  assert SalaryChart != null : "fx:id=\"SalaryChart\" was not injected: check your FXML file 'stat.fxml'.";
        assert x != null : "fx:id=\"x\" was not injected: check your FXML file 'stat.fxml'.";
        assert y != null : "fx:id=\"y\" was not injected: check your FXML file 'stat.fxml'.";*/
        
           ServiceClub sc= new ServiceClub();
           // List<Command> list = sp.readAll();
        try {            
            data.addAll(sc.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(StatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       XYChart.Series set1 = new XYChart.Series<>();
       set1.getData().add(new XYChart.Data("Rotaract",5000));
        set1.getData().add(new XYChart.Data("Enactus",6000));
         set1.getData().add(new XYChart.Data("Tunivision",2500));
          set1.getData().add(new XYChart.Data("Libertad",3900));
          set1.getData().add(new XYChart.Data("Junior Entreprise",1200));
       SalaryChart.getData().addAll(set1);
       
        
        
        
    }    
    
}

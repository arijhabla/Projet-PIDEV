/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev;

import com.esprit.entite.Club;
import com.esprit.Service.ServiceClub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Khadija
 */
public class ListData {
        
     
    private ObservableList<Club> users=FXCollections.observableArrayList();

    public ListData() {
        
        ServiceClub udao=ServiceClub.getInstance();
        users= udao.displayAll();
        
    }
    
    public ObservableList<Club> getUsers(){
        return users;
    }
    
}

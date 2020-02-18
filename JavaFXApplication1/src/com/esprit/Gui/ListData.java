/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Gui;

import com.esprit.Entite.Employes;
import com.esprit.Service.ServiceEmployes;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ferie
 */
public class ListData {
     private ObservableList<Employes> users=FXCollections.observableArrayList();

    public ListData() {
        
        try {
            ServiceEmployes udao=ServiceEmployes.getInstance();
            users= udao.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(ListData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
}
     public ObservableList<Employes> getUsers(){
        return users;
    }
}

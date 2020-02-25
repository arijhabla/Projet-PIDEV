/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.IService;
import com.esprit.Entite.Paiement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Pc
 */
public interface IServicePaiement<T> {
    void ajouter(T t) throws SQLException;
    void delete(T t) throws SQLException;
    void update(T t) throws SQLException;
    
    Paiement getpa (int ID) throws SQLException;
    List<T> readAll() throws SQLException;  
}

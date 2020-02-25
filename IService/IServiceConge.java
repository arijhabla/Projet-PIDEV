/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.IService;

import com.esprit.Entite.Conge;
import java.sql.SQLException;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
/**
 *
 * @author Pc
 */
public interface IServiceConge<T> {
    void ajouter(T t) throws SQLException;
    void delete(T t) throws SQLException;
    void update(T t) throws SQLException;
    List<T> readAll() throws SQLException;  
}

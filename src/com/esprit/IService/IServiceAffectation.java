/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.IService;

import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author dell
 */
public interface IServiceAffectation<T> {
     void ajouter(T t) throws SQLException;
    void delete(T t) throws SQLException;
   void update(T t) throws SQLException;
    
}

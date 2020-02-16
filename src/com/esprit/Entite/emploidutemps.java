/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Entite;

/**
 *
 * @author dell
 */
public class emploidutemps {
     private int id_emploi;
    

    public int getId_emploi() {
        return id_emploi;
    }

    public void setId_emploi(int id_emploi) {
        this.id_emploi = id_emploi;
    }

    public emploidutemps(int id_emploi) {
        this.id_emploi = id_emploi;

    }

    @Override
    public String toString() {
        return "emploi du temps{" + "id_emploi=" + id_emploi + '}';
    }
    
    
    
}

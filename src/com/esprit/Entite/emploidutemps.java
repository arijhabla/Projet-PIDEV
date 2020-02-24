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
    private String nom_emp;
    

    public int getId_emploi() {
        return id_emploi;
    }
     public String getNom_emp() {
        return nom_emp;
    }

    public void setId_emploi(int id_emploi) {
        this.id_emploi = id_emploi;
    }
    public void setNom_emp(String nom_emp) {
        this.nom_emp = nom_emp;
    }

    public emploidutemps(int id_emploi, String nom_emp) {
        this.id_emploi = id_emploi;
        this.nom_emp = nom_emp;

    }

    @Override
    public String toString() {
        return "emploi du temps{" + "id_emploi=" + id_emploi + ", nom_emploi=" + nom_emp +'}';
    }
    
    
    
}

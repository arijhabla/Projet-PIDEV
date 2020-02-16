/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Entite;

import java.sql.Date;

/**
 *
 * @author Pc
 */
public class Conge {
    
    int id_enseignant;
    Date date_debut;
    Date date_fin;
    
    public Conge() {
    }
    
    
    public Conge(int id_enseignant, Date date_debut, Date date_fin) {
        this.id_enseignant = id_enseignant;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Conge{" + "id_enseignant=" + id_enseignant + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }

    
    
   
}

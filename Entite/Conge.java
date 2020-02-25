package com.esprit.Entite;

import java.sql.Date;

/**
 *
 * @author ferie
 */
public class Conge {
    private int id_enseignant;
    private Date Date_Debut_Conge;
    private Date Date_Fin_Conge;

    public Conge(int id_enseignant, Date Date_Debut_Conge, Date Date_Fin_Conge) {
        this.id_enseignant = id_enseignant;
        this.Date_Debut_Conge = Date_Debut_Conge;
        this.Date_Fin_Conge = Date_Fin_Conge;
    }

    public Conge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public Date getDate_Debut_Conge() {
        return Date_Debut_Conge;
    }

    public void setDate_Debut_Conge(Date Date_Debut_Conge) {
        this.Date_Debut_Conge = Date_Debut_Conge;
    }

    public Date getDate_Fin_Conge() {
        return Date_Fin_Conge;
    }

    public void setDate_Fin_Conge(Date Date_Fin_Conge) {
        this.Date_Fin_Conge = Date_Fin_Conge;
    }

   
    
    

    @Override
    public String toString() {
        return "Conge{" + "id_enseignant=" + id_enseignant + ", Date_Debut_Conge=" + Date_Debut_Conge + ", Date_Fin_Conge=" + Date_Fin_Conge + '}';
    }

    

 
    
    
}
package com.esprit.Entite;

import java.sql.Date;

/**
 *
 * @author ferie
 */
public class Conge {
    private int id_Conge;
 
    private Date Date_Debut_Conge;
    private Date Date_Fin_Conge;

    public int getId_conge() {
        return id_Conge;
    }

    

    public Date getDate_Debut_Conge() {
        return Date_Debut_Conge;
    }

    public Date getDate_Fin_Conge() {
        return Date_Fin_Conge;
    }

    public void setId_conge(int id_Conge) {
        this.id_Conge = id_Conge;
    }

   

    public void setDate_Debut_Conge(Date Date_Debut_Conge) {
        this.Date_Debut_Conge = Date_Debut_Conge;
    }

    public void setDate_Fin_Conge(Date Date_Fin_Conge) {
        this.Date_Fin_Conge = Date_Fin_Conge;
    }

    public Conge(int id_Conge, Date Date_Debut_Conge, Date Date_Fin_Conge) {
        this.id_Conge = id_Conge;
     
        this.Date_Debut_Conge = Date_Debut_Conge;
        this.Date_Fin_Conge = Date_Fin_Conge;
    }

    @Override
    public String toString() {
        return "Conge{" + "id_conge=" + id_Conge + ", Date_Debut_Conge=" + Date_Debut_Conge + ", Date_Fin_Conge=" + Date_Fin_Conge + '}';
    }

 
    
    
}
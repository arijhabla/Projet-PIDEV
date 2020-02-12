/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Entite;

import java.sql.Date;

/**
 *
 * @author arij
 */
public class Absence {
    private int id_absence;
    private Date date_absence;
    private int id_matiere;
    private int id_eleve;
    

    public int getid_absence() {
        return id_absence;
    }

    public Date getdate_absence() {
        return date_absence;
    }

    public int getid_matiere() {
        return id_matiere;
    }

    /**
     *
     * @return
     */
    public int getid_eleve (){
        return id_eleve;
    }

    public void setid_absence(int id_absence) {
        this.id_absence = id_absence;
    }

    public void setdate_absence(Date date_absence) {
        this.date_absence= date_absence;
    }

    public void setid_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public void setid_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }

    

    public Absence(int id_absence, Date date_absence, int id_matiere, int id_eleve) {
        this.id_absence = id_absence;
        this.date_absence = date_absence;
        this.id_matiere = id_matiere;
        this.id_eleve = id_eleve ;
        
    }

    @Override
    public String toString() {
        return "Absence{" + "id_absence=" + id_absence + ",date_absence=" + date_absence + ", id_matiere=" + id_matiere + ", id_eleve=" + id_eleve +  '}';
    }
    
    
    
    
}

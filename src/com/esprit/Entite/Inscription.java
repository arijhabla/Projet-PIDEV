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
public class Inscription {
    private int id_inscription;
    private Date date_inscription;
    private int id_classe;
    private int id_eleve;
    

    public int getid_inscription() {
        return id_inscription;
    }

    public Date getdate_inscription() {
        return date_inscription;
    }

    public int getid_classe() {
        return id_classe;
    }

    /**
     *
     * @return
     */
    public int getid_eleve (){
        return id_eleve;
    }

    public void setid_inscrption(int id_inscription) {
        this.id_inscription = id_inscription;
    }

    public void setdate_inscription(Date date_inscription) {
        this.date_inscription= date_inscription;
    }

    public void setid_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public void setid_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }

    

    public Inscription(int id_inscription, Date date_inscription, int id_classe, int id_eleve) {
        this.id_inscription = id_inscription;
        this.date_inscription = date_inscription;
        this.id_classe = id_classe;
        this.id_eleve = id_eleve ;
        
    }

    @Override
    public String toString() {
        return "Inscription{" + "id_inscription=" + id_inscription + ",date_inscription=" + date_inscription + ", id_classe=" + id_classe + ", id_eleve=" + id_eleve +  '}';
    }
    
    
    
    
}

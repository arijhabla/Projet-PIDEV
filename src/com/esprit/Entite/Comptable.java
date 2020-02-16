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
public class Comptable {
    
    int ID_comptable;
    String nom_comptable;
    String prenom_comptable;
    String etat_comptable;
    Date date_embauche_comptable ;
    int telephone_comptable ;
    String adressemail_comptable;

    
    
    public Comptable() {
    }
      
    
    public Comptable(int ID_comptable, String nom_comptable, String prenom_comptable, String etat_comptable, Date date_embauche_comptable, int telephone_comptable, String adressemail_comptable) {
        this.ID_comptable = ID_comptable;
        this.nom_comptable = nom_comptable;
        this.prenom_comptable = prenom_comptable;
        this.etat_comptable = etat_comptable;
        this.date_embauche_comptable = date_embauche_comptable;
        this.telephone_comptable = telephone_comptable;
        this.adressemail_comptable = adressemail_comptable;
    }

    public int getID_comptable() {
        return ID_comptable;
    }

    public void setID_comptable(int ID_comptable) {
        this.ID_comptable = ID_comptable;
    }

    public String getNom_comptable() {
        return nom_comptable;
    }

    public void setNom_comptable(String nom_comptable) {
        this.nom_comptable = nom_comptable;
    }

    public String getPrenom_comptable() {
        return prenom_comptable;
    }

    public void setPrenom_comptable(String prenom_comptable) {
        this.prenom_comptable = prenom_comptable;
    }

    public String getEtat_comptable() {
        return etat_comptable;
    }

    public void setEtat_comptable(String etat_comptable) {
        this.etat_comptable = etat_comptable;
    }

    public Date getDate_embauche_comptable() {
        return date_embauche_comptable;
    }

    public void setDate_embauche_comptable(Date date_embauche_comptable) {
        this.date_embauche_comptable = date_embauche_comptable;
    }

    public int getTelephone_comptable() {
        return telephone_comptable;
    }

    public void setTelephone_comptable(int telephone_comptable) {
        this.telephone_comptable = telephone_comptable;
    }

    public String getAdressemail_comptable() {
        return adressemail_comptable;
    }

    public void setAdressemail_comptable(String adressemail_comptable) {
        this.adressemail_comptable = adressemail_comptable;
    }

    @Override
    public String toString() {
        return "Comptable{" + "ID_comptable=" + ID_comptable + ", nom_comptable=" + nom_comptable + ", prenom_comptable=" + prenom_comptable + ", etat_comptable=" + etat_comptable + ", date_embauche_comptable=" + date_embauche_comptable + ", telephone_comptable=" + telephone_comptable + ", adressemail_comptable=" + adressemail_comptable + '}';
    }

    
}

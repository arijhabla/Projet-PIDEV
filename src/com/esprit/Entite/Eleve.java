/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Entite;

import java.sql.Date;

/**
 *
 * @author ferie
 */
public class Eleve {
    private int id_eleve;
    private String nom_eleve;
    private String prenom_eleve;
    private Date datenaiss_eleve;
    private String adresse_eleve;
    private int tel_eleve;

    public Eleve() {
 //To change body of generated methods, choose Tools | Templates.
    }

    public int getid_eleve() {
        return id_eleve;
    }

    public String getnom_eleve() {
        return nom_eleve;
    }

    public String getprenom_eleve() {
        return prenom_eleve;
    }

    /**
     *
     * @return
     */
    public Date getdatenaiss_eleve() {
        return datenaiss_eleve;
    }

    public String getadresse_eleve() {
        return adresse_eleve;
    }
    
    public int gettel_eleve() {
        return tel_eleve;
    }

    public void setid_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }

    public void setnom_eleve(String nom_eleve) {
        this.nom_eleve = nom_eleve;
    }

    public void setprenom_eleve(String prenom_eleve) {
        this.prenom_eleve = prenom_eleve;
    }

    public void setdatenaiss_eleve(Date datenaiss_eleve) {
        this.datenaiss_eleve = datenaiss_eleve;
    }

    public void setadresse_eleve(String adresse_eleve) {
        this.adresse_eleve = adresse_eleve;
    }

     public void settel_eleve(int tel_eleve) {
        this.tel_eleve = tel_eleve;
    }

    public Eleve(int id_eleve, String nom_eleve, String prenom_eleve, Date datenaiss_eleve, String adresse_eleve, int tel_eleve) {
        this.id_eleve = id_eleve;
        this.nom_eleve = nom_eleve;
        this.prenom_eleve = prenom_eleve;
        this.datenaiss_eleve = datenaiss_eleve ;
        this.adresse_eleve = adresse_eleve;
        this.tel_eleve = tel_eleve;
    }

    @Override
    public String toString() {
        return "Eleve{" + "id_eleve=" + id_eleve + ", nom_eleve=" + nom_eleve + ", prenom_eleve=" + prenom_eleve + ", datenaiss_eleve=" + datenaiss_eleve + ", adresse_eleve=" + adresse_eleve + ", tel_eleve=" + tel_eleve + '}';
    }

  
    
    
    
}

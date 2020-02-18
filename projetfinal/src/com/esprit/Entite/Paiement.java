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
public class Paiement {
    int id_eleve;
    int frais_scolarite;
    String type_paiement;
    Date date_paiement;

    public Paiement(int id_eleve, int frais_scolarite, String type_paiement, Date date_paiement) {
        this.id_eleve = id_eleve;
        this.frais_scolarite = frais_scolarite;
        this.type_paiement = type_paiement;
        this.date_paiement = date_paiement;
    }

    public int getId_eleve() {
        return id_eleve;
    }

    public void setId_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }

    public int getFrais_scolarite() {
        return frais_scolarite;
    }

    public void setFrais_scolarite(int frais_scolarite) {
        this.frais_scolarite = frais_scolarite;
    }

    public String getType_paiement() {
        return type_paiement;
    }

    public void setType_paiement(String type_paiement) {
        this.type_paiement = type_paiement;
    }

    public Date getDate_paiement() {
        return date_paiement;
    }

    /**
     *
     * @param date_paiement
     */
    public void setDate_paiement(Date date_paiement) {
        this.date_paiement = date_paiement;
    }

    @Override
    public String toString() {
        return "paiement{" + "id_eleve=" + id_eleve + ", frais_scolarite=" + frais_scolarite + ", type_paiement=" + type_paiement + ", date_paiement=" + date_paiement + '}';
    }
    
    
}

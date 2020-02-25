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
    int id_paiement;
    String type_paiement;
    int montant;

    public Paiement(int id_paiement, String type_paiement, int montant) {
        this.id_paiement = id_paiement;
        this.type_paiement = type_paiement;
        this.montant = montant;
    }

    public Paiement() {
           }

    public int getId_paiement() {
        return id_paiement;
    }

    public void setId_paiement(int id_paiement) {
        this.id_paiement = id_paiement;
    }

    public String getType_paiement() {
        return type_paiement;
    }

    public void setType_paiement(String type_paiement) {
        this.type_paiement = type_paiement;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Paiement{" + "id_paiement=" + id_paiement + ", type_paiement=" + type_paiement + ", montant=" + montant + '}';
    }
    
    

}

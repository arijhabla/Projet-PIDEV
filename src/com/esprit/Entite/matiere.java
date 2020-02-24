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
public class matiere {
    private int id_matiere;
    private String nom_matiere;
    private int nbr_heures;

    public int getId_matiere() {
        return id_matiere;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }
     public int getNbr_heures() {
        return nbr_heures;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }
    public void setNbr_heures(int nbr_heures) {
        this.nbr_heures = nbr_heures;
    }
    public matiere(int id_matiere, String nom_matiere, int nbr_heures) {
        this.id_matiere = id_matiere;
        this.nom_matiere = nom_matiere;
        this.nbr_heures=nbr_heures;
    }

    @Override
    public String toString() {
        return "matière{" + "id_matière=" + id_matiere + ", nom_matière=" + nom_matiere +", nbr_heures=" +nbr_heures + '}';
    }
    
    
     
}

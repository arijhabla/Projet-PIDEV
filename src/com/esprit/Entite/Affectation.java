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
public class Affectation {

    private int id;
    private String nv_cl;
    private int id_salle;
    private String nom_matiere; 
    private String date;
    private String heure ;

    public Affectation(int id, String nv_cl, int id_salle, String nom_matiere, String date,String heure) {
        this.id = id;
        this.nv_cl = nv_cl;
        this.id_salle = id_salle;
        this.nom_matiere = nom_matiere;
        this.date = date;
        this.heure = heure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Affectation(int id, String nv_cl, int id_salle,String nom_matiere) {
        this.id = id;
        this.nv_cl = nv_cl;
        this.id_salle = id_salle;
        this.nom_matiere=nom_matiere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNv_cl() {
        return nv_cl;
    }

    public void setNv_cl(String nv_cl) {
        this.nv_cl = nv_cl;
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }
    

}

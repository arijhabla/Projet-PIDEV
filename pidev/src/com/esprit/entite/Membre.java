/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.entite;

/**
 *
 * @author Khadija
 */
public class Membre {
    int id_membre;
    String nom_membre;
    String prenom_membre;
    int age_membre;

    @Override
    public String toString() {
        return "Membre{" + "id_membre=" + id_membre + ", nom_membre=" + nom_membre + ", prenom_membre=" + prenom_membre + ", age_membre=" + age_membre + '}';
    }

    public Membre(int id_membre, String nom_membre, String prenom_membre, int age_membre) {
        this.id_membre = id_membre;
        this.nom_membre = nom_membre;
        this.prenom_membre = prenom_membre;
        this.age_membre = age_membre;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public String getNom_membre() {
        return nom_membre;
    }

    public void setNom_membre(String nom_membre) {
        this.nom_membre = nom_membre;
    }

    public String getPrenom_membre() {
        return prenom_membre;
    }

    public void setPrenom_membre(String prenom_membre) {
        this.prenom_membre = prenom_membre;
    }

    public int getAge_membre() {
        return age_membre;
    }

    public void setAge_membre(int age_membre) {
        this.age_membre = age_membre;
    }
    
}

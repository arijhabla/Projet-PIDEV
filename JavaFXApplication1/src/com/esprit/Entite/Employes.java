/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Entite;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ferie
 */
public class Employes {
    private int  id_employe;
    public String nom_employe;
   private  String prenom_employe;
   private int  age_employe;
   private String role;
    private  float salaire;
   private float prime;
   private int nbr_heure;

    public Employes(int id_employe, String nom_employe, String prenom_employe, int age_employe, String role, float salaire, float prime, int nbr_heure) {
        this.id_employe = id_employe;
        this.nom_employe = nom_employe;
        this.prenom_employe = prenom_employe;
        this.age_employe = age_employe;
        this.role = role;
        this.salaire = salaire;
        this.prime = prime;
        this.nbr_heure = nbr_heure;
    }

    public Employes() {
    }
   
   

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public String getNom_employe() {
        return nom_employe;
    }

    public void setNom_employe(String nom_employe) {
        this.nom_employe = nom_employe;
    }

    public String getPrenom_employe() {
        return prenom_employe;
    }

    public void setPrenom_employe(String prenom_employe) {
        this.prenom_employe = prenom_employe;
    }

    public int getAge_employe() {
        return age_employe;
    }

    public void setAge_employe(int age_employe) {
        this.age_employe = age_employe;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public float getPrime() {
        return prime;
    }

    public void setPrime(float prime) {
        this.prime = prime;
    }

    public int getNbr_heure() {
        return nbr_heure;
    }

    public void setNbr_heure(int nbr_heure) {
        this.nbr_heure = nbr_heure;
    }

    @Override
    public String toString() {
        return "Employes{" + "id_employe=" + id_employe + ", nom_employe=" + nom_employe + ", prenom_employe=" + prenom_employe + ", age_employe=" + age_employe + ", role=" + role + ", salaire=" + salaire + ", prime=" + prime + ", nbr_heure=" + nbr_heure + '}';
    }
     

   
   
}

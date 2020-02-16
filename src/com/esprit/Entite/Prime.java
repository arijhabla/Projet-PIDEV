/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Entite;

/**
 *
 * @author Pc
 */
public class Prime {
    float salaire;
    String grade;

    public Prime() {
    
    }

    public float getSalaire() {
        return salaire;
    }

    @Override
    public String toString() {
        return "Prime{" + "salaire=" + salaire + ", grade=" + grade + '}';
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Prime(float salaire, String grade) {
        this.salaire = salaire;
        this.grade = grade;
    }

    public Prime recherchePrimeParGrade(String primaire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

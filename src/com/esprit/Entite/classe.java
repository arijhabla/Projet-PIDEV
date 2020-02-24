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
public class classe {
    private int id_classe;
    private int nbr_eleves;
    private String niveau;

    public classe() {
    }

    public int getId_classe() {
        return id_classe;
    }

    public int getNbr_eleves() {
        return nbr_eleves;
    }
      public String getNiveau() {
        return niveau;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public void setNbr_eleves(int nbr_eleves) {
        this.nbr_eleves = nbr_eleves;
    }
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
   
    public classe(int id_classe, int nbr_élèves, String niveau) {
        this.id_classe = id_classe;
        this.nbr_eleves = nbr_élèves;
        this.niveau=niveau;
    }

    @Override
    public String toString() {
        return "Classe{" + "id_classe=" + id_classe + ", nbr_eleves=" + nbr_eleves + "niveau" + niveau+'}';
    }
    
    
    
    
}

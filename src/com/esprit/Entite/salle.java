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
public class salle {
    private int id_salle;
    private int capacite;

    public int getId_salle() {
        return id_salle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    public salle(int id_salle, int capacite) {
        this.id_salle = id_salle;
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "salle{" + "id_salle=" + id_salle + ", capacité=" + capacite + '}';
    }
    
    
     
}

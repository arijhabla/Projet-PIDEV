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
public class Club {
    int id_club;
    String nom_club;
    String type_club;

    public Club() {
    }

    @Override
    public String toString() {
        return "Club{" + "id_club=" + id_club + ", nom_club=" + nom_club + ", type_club=" + type_club + '}';
    }

    public int getId_club() {
        return id_club;
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    public String getNom_club() {
        return nom_club;
    }

    public void setNom_club(String nom_club) {
        this.nom_club = nom_club;
    }

    public String getType_club() {
        return type_club;
    }

    public void setType_club(String type_club) {
        this.type_club = type_club;
    }

    public Club(int id_club, String nom_club, String type_club) {
        this.id_club = id_club;
        this.nom_club = nom_club;
        this.type_club = type_club;
    }
    
    



}

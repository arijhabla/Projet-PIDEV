/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.Entite;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author BEN SAID
 */
public class Note {
    int id_eleve;
    int id_examen;
    int id_matiere;
    float note;
    int id_note;
    String nom_matiere;
    String mail;
    String mdp;
    Timestamp date;

    public Note(int id_eleve, int id_examen, int id_matiere, float note, String nom_matiere, String mail, String mdp, Timestamp date) {

    }

  
    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

  

   

    public int getId_eleve() {
        return id_eleve;
    }

    public int getId_examen() {
        return id_examen;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public float getNote() {
        return note;
    }

    public void setId_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }

    public void setId_examen(int id_examen) {
        this.id_examen = id_examen;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    @Override
    public String toString() {
        return "Note{" + "id_eleve=" + id_eleve + ", id_examen=" + id_examen + ", id_matiere=" + id_matiere + ", note=" + note + ", id_note=" + id_note + ", nom_matiere=" + nom_matiere + ", mail=" + mail + ", mdp=" + mdp + ", date=" + date + '}';
    }
    

  

    public Note(int id_eleve, int id_examen, int id_matiere, float note, int id_note, String nom_matiere, String mail, String mdp,Timestamp date) {
        this.id_eleve = id_eleve;
        this.id_examen = id_examen;
        this.id_matiere = id_matiere;
        this.note = note;
        this.id_note = id_note;
        this.nom_matiere = nom_matiere;
        this.mail = mail;
        this.mdp = mdp;
        this.date = date;
    }

    public Note(int id_examen, int id_matiere, float note, int id_note, String nom_matiere, String mail, String mdp, Timestamp date) {
        this.id_examen = id_examen;
        this.id_matiere = id_matiere;
        this.note = note;
        this.id_note = id_note;
        this.nom_matiere = nom_matiere;
        this.mail = mail;
        this.mdp = mdp;
        this.date = date;
    }
    
    
   

   
  

    public Note() {
    }
    
    
    
}

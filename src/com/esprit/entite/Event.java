/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.entite;
import java.sql.Date;

/**
 *
 * @author Khadija
 */
public class Event {
   int id_event;
   String nom_event;
   Date date_event;

    public Event(int i, String nom_e, String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Event{" + "id_event=" + id_event + ", nom_event=" + nom_event + ", date_event=" + date_event + '}';
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public Date getDate_event() {
        return date_event;
    }

    public void setDate_event(Date date_event) {
        this.date_event = date_event;
    }

    public Event(int id_event, String nom_event, Date date_event) {
        this.id_event = id_event;
        this.nom_event = nom_event;
        this.date_event = date_event;
    }

    public Event() {
    }
    
}

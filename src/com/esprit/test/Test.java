/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.test;
import com.esprit.entite.Membre;
import com.esprit.Service.ServiceMembre;
import com.esprit.entite.Club;
import com.esprit.entite.Event;
import com.esprit.Service.ServiceClub;
import com.esprit.Service.ServiceEvent;
import com.esprit.Utils.Database;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Khadija
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServiceClub sc=new ServiceClub();
        ServiceEvent se=new ServiceEvent();
        ServiceMembre sm=new ServiceMembre();
        Club c1=new Club(45,"nounou","charity");
        Club c2=new Club(4,"doja","mimi");
        Club c3=new Club(25,"doja","doja");
        Club c4=new Club(22,"hello","hello");
        Club c5=new Club(1,"rotaract","charity");
        Membre m1=new Membre(1,"hhh","kk",5);
         Membre m2=new Membre(5,"kkff","kkfff",6);
         Membre m3=new Membre(6,"feriel","ff",7);
         
        Date d1=new Date(2020,06,12);
        Event e1=new Event(4,"rouja",d1);
         Event e2=new Event(55,"fifi",d1);
        
        
                try {
                    //sm.ajouter(m3);
                      //sc.ajouter(c5);
                //sm.update(m1);
                  // sc.update(c1);
//sm.ajouter(m1);
                    //sc.delete(c5);
                   //Club l=sc.rechercheClubpartype("charity");
       // se.ajouter1(e2);
      // sc.ajouter1(c3);
   // se.update(e1);
   //se.delete(e2);
        
          
            //List<Event>lt=se.readAll();
            List<Club> mylist = sc.readAll();
          // List<Membre> lst =sm.Triparnom();
               
        System.out.println(mylist);
        
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
   
       
    }
    


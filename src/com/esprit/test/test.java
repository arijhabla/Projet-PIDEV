/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.test;
import com.esprit.Entite.classe;
import com.esprit.Entite.emploidutemps;
import com.esprit.Entite.matiere;
import com.esprit.Entite.salle;
import com.esprit.Service.Serviceclasse;
import com.esprit.Service.Serviceemploi;
import com.esprit.Service.Servicematiere;
import com.esprit.Service.Servicesalle;
import com.esprit.Utils.DataBase;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author dell
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Serviceclasse sc=new Serviceclasse();
      Serviceemploi se=new Serviceemploi();
      Servicematiere sm=new Servicematiere();
       Servicesalle ss=new Servicesalle();
    classe c1=new classe(4,55);
    classe c2=new classe(3,8);
    emploidutemps e1=new emploidutemps(1);
    matiere m1=new matiere(2,"fff",3);
    salle s1=new salle(2,5);
    salle s2=new salle(4,41);
   
    try {
//ss.ajouter(s1);
        //ss.delete(s1);
      //ss.update(s2);
        //sc.ajouter(c1);
         //sc.delete(s1);
    //sm.update(m1);    
//sc.update(c2);
//sm.delete(m1);
 //sc.ajouter(c2);
   // se.update(e1);    
//se.delete(e1);
//ee.delete(e2);        
 
     // List<classe> lst=sc.Triparnbreleves();
      //System.out.println(lst);
     
     // List<salle> lst = ss.readAll();
         //System.out.println(lst);
     classe c= sc.rechercheClasseParId(4);
     System.out.println(c);
          List<classe> lst = sc.readAll();
          System.out.println(lst);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
        
        
        
    }
    

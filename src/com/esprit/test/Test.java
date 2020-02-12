/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.test;
import com.esprit.Entite.Inscription;
import com.esprit.Service.ServiceInscription;
import com.esprit.Entite.Absence;
import com.esprit.Service.ServiceAbsence;
import com.esprit.Entite.Eleve;
import com.esprit.Service.ServiceEleve;
import com.esprit.Entite.Eleve;
import com.esprit.Entite.Inscription;
import com.esprit.Service.ServiceEleve;
import com.esprit.Utils.DataBase;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 @author ferie
 */
public class Test {
    
    public static void main(String[] args) {
        ServiceEleve co=new ServiceEleve();
        
        ServiceAbsence sa=new  ServiceAbsence();
        ServiceInscription si=new ServiceInscription();
            Date d2=new Date(2006,04,5);
              Date d3=new Date(2001,17,20);
    Eleve e1=new Eleve(12,"doja","ggg",d2,"ddd",1111);
        Eleve e3=new Eleve(20,"hanaouna","habla",d2,"sousse",12);
    Eleve e2=new Eleve(55,"hhahaha","kkkk",d3,"rrrrr",322);
    Absence a1=new Absence(1,d2,2,4);
     Absence a2=new Absence(2,d3,22,31);   
          Inscription i1=new Inscription(2,d3,2111,30);   
       Date d4=new Date(1045,140,0);
    
        try {
//         
            
           // co.ajouter(e3);
            //si.delete(i1);
          //  si.update(i1);
           //// sa.update(a1);
//  si.ajouter(i1);
//sa.ajouter1(a2);
 // co.delete(e1);
  //co.update(e3);
       // co.ajouter(co2);
          //co.ajouter1(e1);
         // co.ajouter(e2);
    
            // co.update(co2);
          co.delete(e3);
         //  sec.delete(c2);
          //  List lst=co.readAll();
          //Eleve l =co.rechercheEleveParId(12);
          //
         // System.out.println(l);
          List<Eleve> lst=co.Triparnom();
          System.out.println(lst);
       
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }
   
}

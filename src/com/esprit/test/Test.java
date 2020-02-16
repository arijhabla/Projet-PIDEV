/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.test;
import com.esprit.Entite.Comptable;
import com.esprit.Entite.Conge;
import com.esprit.Entite.Paiement;
import com.esprit.Entite.Prime;
import com.esprit.Service.ServiceComptable;
import com.esprit.Service.ServiceConge;
import com.esprit.Service.ServicePaiement;
import com.esprit.Service.ServicePrime;

import com.esprit.Utils.DataBase;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Pc
 */
public class Test {
    private static Prime Prime;
       public static void main(String[] args) {
        ServicePrime p=new ServicePrime();
        ServicePaiement pa=new ServicePaiement();
        ServiceComptable c=new ServiceComptable();
        ServiceConge myco=new ServiceConge();
      
        Prime p1 = new Prime(5000,"primaire");
        Prime p2=new Prime(700,"primaire1");
        Prime p3=new Prime(6000,"primaire2");
        Prime p4=new Prime(6000,"secondaire2");
        Prime p5=new Prime(55,"primaire");
        Date d1=new Date(2020,06,12);
        Date d2=new Date(2020,07,15);
        Conge con1 = new Conge(222,d1,d2);
        Paiement pa1 = new Paiement(25,4,"eeee",d1);
        Paiement pa2=new Paiement(144444,444,"hannouna",d1);
        Comptable c1=new Comptable(074,"Chakroun","Omar","Congés",d1,25684957,"ChakrounOmar@hotmail.com");
        Comptable c2=new Comptable(80,"Chakroun","Omar","Congés",d1,25684957,"ChakrounOmar@hotmail.com");
      
        try {
           //         
           //Prime pr=p.recherchePrimeParGrade("primaire");
           //System.out.println(pr);
            //c.delete(c1);
            //c.ajouter(c2);
           // pa.update(pa1); 
           //System.out.println(pa1);
           //p.update(p2);
           // p.delete(p1);
           // p.delete(p2);
           // p.delete(p3);
           //p.delete(p4);
           //ser.ajouter1(e2);
           myco.ajouter(con1);
          //p.ajouter(p2); 
         // p.ajouter(p3); 
        // p.ajouter(p4); 
        
            //p.delete(p1);
  // p.delete(p2);
 // p.delete(p3);
 //p.delete(p4);
// p.ajouter1(p1);/
    
          //  List<Prime>lt=p.readAll();
           //List<Paiement>lst=pa.readAll();
          //List<Prime>lst=p.Triparsalaire();
          //System.out.println(lst);
           System.out.println(con1);
          
          
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
    }
    
}

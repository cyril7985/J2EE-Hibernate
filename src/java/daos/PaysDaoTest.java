/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Pays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrateur
 */
public class PaysDaoTest {
    
    public static void main(String[] args) {
        String message;
        
        //Instanciation de l'objet sessionH et ouverture d'une session Hibernate
        SessionH sessionH = new SessionH();
        Session session = sessionH.getSession();

        //Instanciation de l'objet paysDao        
        PaysDao paysDao = new PaysDao(session);

        //Select All  
//        System.out.println("SELECT ALL");
//        List<Pays> listPays = paysDao.selectAll();
//        for (int i = 0; i < listPays.size(); i++) {
//            Pays pays = listPays.get(i);
//            System.out.println(pays.getNomPays());
//            
//        }
//        //SelectOne
//        Pays paysOne = paysDao.selectOneById("034");
//        System.out.println("SELECT ONE");
//        System.out.println(paysOne.getNomPays());
//        sessionH.closeSession(session);
//        
//        session = sessionH.getSession();
//        paysDao.setSessionH(session);

       //Insert
      /* System.out.println("INSERT PAYS");
        org.hibernate.Transaction tx = session.beginTransaction();
        Pays newPays = new Pays("212", "Maroc");
        
        int affected = paysDao.insert(newPays);
        
        if (affected > 0) {
            tx.commit();            
        } else {
            tx.rollback();
        }*/
        
        //delete
       /* System.out.println("DELETE PAYS");
        org.hibernate.Transaction tx = session.beginTransaction();
        Pays maroc = new Pays("212","Maroc");
        int deleted = paysDao.delete(maroc);
        //sessionH.closeSession(session);
         if (deleted > 0) {
            tx.commit(); 
             System.out.println("commit delete");
        } else {
            tx.rollback();
        }*/
        
         //Update
          System.out.println("DELETE PAYS");
           org.hibernate.Transaction tx = session.beginTransaction();
           Pays france = new Pays("033","Francesse");
           int updated = paysDao.update(france);
           if (updated > 0) {
            tx.commit(); 
             System.out.println("commit update");
        } else {
            tx.rollback();
        }
         
         
         
         
         session.close();
         
    }//psvm

}//main

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Pays;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Administrateur
 */
public class PaysDao {

    //Attributs
    private Session session = null;

    //Methodes
    public PaysDao(Session session) {
        this.session = session;
    }//constructeur

    public void setSessionH(Session sessionH) {
        this.session = sessionH;
    }

    //Select All
    public List<Pays> selectAll() {
        //Le resultat du selectAll sera une List d'objet Pays
        List<Pays> listPays = null;

        try {
            
            //Ordre hibernate
            org.hibernate.Query q = this.session.createQuery("FROM Pays");
            //La methode list permet de récuperer une collection
            listPays = q.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return listPays;
    }

    //SelectOne
    public Pays selectOneById(String id) {
        Pays pays = null;
        try {
            org.hibernate.Query q = this.session.createQuery("FROM Pays WHERE id_pays=?");
            q.setString(0, id);
            //La methode uniqueResult renvoie le resultat du selectOne
            pays = (Pays) q.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return pays;
    }

    //Insert
    public int insert(Pays pays) {
        int affected = 0;

        try {
            //La methode .save est le pendant de l'insert en SQL
            session.save(pays);
            affected = 1;
            System.out.println(affected + " enregistrement effectué");

        } catch (HibernateException e) {
            affected = -1;
            System.out.println("HibernateException: " + e.getMessage());
            //e.printStackTrace();
            //  message = e.getMessage();
        }

        return affected;
    }

    
    //Delete
    public int delete(Pays pays) {
        int affected = 1;
        try {
            session.delete(pays);
            //affected = 1;
            System.out.println(affected + " supression effectué");
        } catch (HibernateException e) {
            affected = -1;
            System.out.println("HibernateException: " + e.getMessage());
        }

        return affected;
    }
    
    //Update
    /**
     * 
     * @param pays
     * @return 
     */
    public int update(Pays pays){
        int updated=1;
        try {
            session.update(pays);
            System.out.println(updated + " modification effectuée");
        } catch (HibernateException e) {
            updated = -1;
            System.out.println("HibernateException: " + e.getMessage());
        }
                
        return updated;
    }
}//main

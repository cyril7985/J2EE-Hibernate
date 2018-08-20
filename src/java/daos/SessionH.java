/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.NewHibernateUtil;
/*
Ici, on crée la methode getSession qui va nous permettre d'ouvrir une session Hibernate
On utilisera l'objet sessionH pour ouvrir une session Hibernate
*/

/**
 *
 * @author Administrateur
 */
public class SessionH {

    /**
     * 
     * @return 
     */
    public Session getSession() {
        Session sessionH = null;
        try {
            sessionH = NewHibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException e) {
        }

        return sessionH;
    }//getSession

    /**
     * 
     * @param session
     * @return 
     */
    public boolean closeSession(Session session) {
        boolean lbOk = true;
        try {
            session.close();
        } catch (HibernateException e) {
            lbOk = false;
        }

        return lbOk;
    }//closeSession

    /* Transaction beginTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     */
}//main

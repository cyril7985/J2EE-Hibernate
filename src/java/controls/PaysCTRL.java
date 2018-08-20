/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import entities.Pays;
import daos.PaysDao;
import daos.SessionH;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "PaysCTRL", urlPatterns = {"/PaysCTRL"})
public class PaysCTRL extends HttpServlet {

    private final String IHM = "PaysIHM.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();

        /*
         Affichage de la table dans un tableau
         */
        
        //Instanciation de l'objet sessionH et ouverture d'une session Hibernate
        SessionH sessionH = new SessionH();
        Session session = sessionH.getSession();
        //Instanciation de l'objet PaysDao
        PaysDao paysDao = new PaysDao(session);
        //Recupération de la liste des pays
        List<Pays> listePays = paysDao.selectAll();
        //Affichage ds la jsp
        request.setAttribute("listePays", listePays);
        //Fermeture de la 
        session.close();

        //Redirection
        ServletContext contexte = getServletContext();
        RequestDispatcher aiguileur = contexte.getRequestDispatcher("/jsp/" + IHM);
        aiguileur.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String message = "";

        //Instanciation de l'objet sessionH et ouverture d'une session Hibernate
        SessionH sessionH = new SessionH();
        Session session = sessionH.getSession();
        //Instanciation de l'objet PaysDao
        PaysDao paysDao = new PaysDao(session);

        //Recupération des saisies utlisisateur      
        String idPays = request.getParameter("idPays");
        String nomPays = request.getParameter("nomPays");

        /*
       Bouton clear
         */
        
        //Si l'utilisateur clique sur le bouton,on remplie les champs de chaine vide
        if (request.getParameter("cls") != null) {
            request.setAttribute("idPaysText", "");
            request.setAttribute("nomPaysText", "");
        }

        /*
        Bouton ajouter
         */
        //Si le bouton a été cliqué
        if (request.getParameter("ajouter") != null) {
            //Ouverture d'une session de transaction
            org.hibernate.Transaction tx = session.beginTransaction();
            //Instanciation d'un nouvel objet Pays avec comme paramettre les valeurs saisies par le user
            Pays pays = new Pays(idPays, nomPays);
            //Appel de la methode paysDao.insert qui retourne un integer
            int affected = paysDao.insert(pays);
          //S'il y a un résultat, on valide (commit) l'insert, sinon on rollback la session de transaction
            if (affected > 0) {
                tx.commit();
            } else {
                tx.rollback();
            }
            message = nomPays + " a bien été enregistré";
        }
        afficherData(request);
        request.setAttribute("message", message);

        /*
        Bouton supprimer
         */
        if (request.getParameter("supprimer") != null) {
            org.hibernate.Transaction tx = session.beginTransaction();
            Pays pays = new Pays(idPays, nomPays);
            int affected = paysDao.delete(pays);
            if (affected > 0) {
                tx.commit();
            } else {
                tx.rollback();
            }
            afficherData(request);
            message = nomPays + " a bien été supprimé";
        }
        request.setAttribute("message", message);
        

        /*
        Bouton modifier
         */
        
        //Même principe que l'insert
        if(request.getParameter("modifier")!=null){
        org.hibernate.Transaction tx = session.beginTransaction();
        Pays pays = new Pays(idPays, nomPays);
        int affected = paysDao.update(pays);
       
            if (affected > 0) {
                tx.commit();
            } else {
                tx.rollback();
            }
            
            //Affichage du resultat via la méthode "afficherData"
            afficherData(request);
            message = nomPays + " a bien été modifié";
        }
        request.setAttribute("message", message);

        //Redirection
        ServletContext contexte = getServletContext();
        RequestDispatcher aiguileur = contexte.getRequestDispatcher("/jsp/" + IHM);
        aiguileur.forward(request, response);


    } /// doPost

    private void afficherData(HttpServletRequest request) {
        /*
         Affichage de la table dans un tableau
         */
        //Instanciation de l'objet sessionH et ouverture d'une session Hibernate
        SessionH sessionH = new SessionH();
        Session session = sessionH.getSession();
        //Instanciation de l'objet PaysDao
        PaysDao paysDao = new PaysDao(session);
        //Recupération de la liste des pays
        List<Pays> listePays = paysDao.selectAll();
        //Affichage ds la jsp
        request.setAttribute("listePays", listePays);

        session.close();
    }

} /// class

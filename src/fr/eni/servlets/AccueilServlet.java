package fr.eni.servlets;

import fr.eni.bll.ListeManager;
import fr.eni.bo.Liste;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {

    ListeManager lm = new ListeManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Récupération d'une liste des Listes et passage en paramètre session
        List<Liste> listeDesListes = lm.afficherListesDeCourses();
        HttpSession session = req.getSession();
        session.setAttribute("listeDesListes", listeDesListes);
        req.getRequestDispatcher("WEB-INF/accueil.jsp").forward(req, resp);
    }
}

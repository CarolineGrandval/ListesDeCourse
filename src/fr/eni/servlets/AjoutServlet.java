package fr.eni.servlets;

import fr.eni.bll.ListeManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/new")
public class AjoutServlet extends HttpServlet {

    private ListeManager lm = new ListeManager();
    private List<String> listeArticles = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/ajout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomNouvelleListe = req.getParameter("nomListe");
        String article1 = req.getParameter("nomArticle1");
        if (!article1.equals("")){
            listeArticles.add(article1);
        }

        if (req.getParameter("save")!= null) {
            if (!nomNouvelleListe.equals("")) {
                lm.ajouterListe(nomNouvelleListe, listeArticles);
                listeArticles = new ArrayList<>();
                nomNouvelleListe = "";
            }
        }

        HttpSession session = req.getSession();
        req.setAttribute("nomNouvelleListe", nomNouvelleListe);
        req.setAttribute("listeArticles", listeArticles);
        req.getRequestDispatcher("WEB-INF/ajout.jsp").forward(req, resp);
    }
}

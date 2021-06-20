package fr.eni.servlets;

import fr.eni.bll.ListeManager;
import fr.eni.bo.Article;
import fr.eni.bo.Liste;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/articles")
public class ArticlesServlet extends HttpServlet {

    ListeManager lm = new ListeManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("liste"));

        Liste liste = lm.afficherParId(id);
        List<Article> listeArticles = liste.getListeArticles();

        req.setAttribute("liste", liste);
        req.setAttribute("listeArticles", listeArticles);

        lm.reinitialiser(id);

        req.getRequestDispatcher("WEB-INF/panier.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] tabArticlesCoches = req.getParameterValues("bouton");
        if (tabArticlesCoches!=null){
            for (String a : tabArticlesCoches
            ) {
                int idArticle = Integer.parseInt(a);
                Article articleTrouve = lm.afficherArticleParId(idArticle);
                if (articleTrouve.isCoche()) {
                    lm.modifierDecoche(idArticle);
                } else {
                    lm.modifierCoche(idArticle);
                }
            }
        }

        req.getRequestDispatcher("WEB-INF/accueil.jsp").forward(req, resp);
    }
}

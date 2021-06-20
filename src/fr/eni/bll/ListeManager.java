package fr.eni.bll;

import fr.eni.bo.Article;
import fr.eni.bo.Liste;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.DalException;
import fr.eni.dal.ListeDAO;

import java.util.ArrayList;
import java.util.List;

public class ListeManager {

    private ListeDAO lDAO = DAOFactory.getListeDAO();

    public List<Liste>  afficherListesDeCourses(){
        List<Liste> listeDesListes = null;
        try {
            listeDesListes = lDAO.selectAll();
        } catch (DalException e) {
            e.printStackTrace();
        }
        return listeDesListes;
    }

    public Liste afficherParId(int id){
        Liste liste = null;
        try {
            liste = lDAO.selectById(id);
        } catch (DalException e) {
            e.printStackTrace();
        }
        return liste;
    }

    public Article afficherArticleParId(int id){
        Article a = null;
        try {
            a=lDAO.selectArticleById(id);
        } catch (DalException e) {
            e.printStackTrace();
        }
        return a;
    }

    public void ajouterListe(String nomListe, List<String> articles){
        //Je créé des articles à partir de la liste de String récupérées, et on les ajoute à la liste d'Articles
        List<Article> listeArticles = new ArrayList<>();
        for (String a: articles
             ) {
            Article article = new Article(a);
            listeArticles.add(article);
        }

        //Je créé une liste à partir de son nom et de la liste d'Articles
        Liste nouvelleListe = new Liste(nomListe, listeArticles);
        try {
            lDAO.insert(nouvelleListe);
        } catch (DalException e) {
            e.printStackTrace();
        }
    }

    public void supprimerListe(int id){
        try {
            lDAO.delete(id);
        } catch (DalException e) {
            e.printStackTrace();
        }
    }

    public void modifierCoche(int id){
    lDAO.updateCoche(id);
    }

    public void modifierDecoche(int idArticle) {
        lDAO.updateDecoche(idArticle);
    }

    public void reinitialiser(int idListe){
        lDAO.reinitialize(idListe);
    }
}

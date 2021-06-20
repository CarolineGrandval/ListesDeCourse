package fr.eni.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Liste implements Serializable {
    private int idListe;
    private String nom ;
    private List<Article> listeArticles ; // relation unidirectionnelle Liste->Articles

    public Liste() {
        this.listeArticles = new ArrayList<>();
    }

    public Liste(String nom, List<Article> listeArticles) {
        this.nom = nom;
        this.listeArticles = listeArticles;
    }

    public Liste(int idListe, String nom, List<Article> listeArticles) {
        this.idListe = idListe;
        this.nom = nom;
        this.listeArticles = listeArticles;
    }

    public Liste(int idListe, String nom) {
        this.idListe = idListe;
        this.nom = nom;
    }

    public int getIdListe() {
        return idListe;
    }

    public void setIdListe(int idListe) {
        this.idListe = idListe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Article> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(List<Article> listeArticles) {
        this.listeArticles = listeArticles;
    }
}

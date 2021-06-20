package fr.eni.bo;

import java.io.Serializable;

public class Article implements Serializable {
    private int id;
    private String nom;
    private boolean coche;

    public Article() {
    }

    public Article(String nom) {
        this.nom = nom;
    }

    public Article(String nom, boolean coche) {
        this.nom = nom;
        this.coche = coche;
    }

    public Article(int id, String nom, boolean coche) {
        this.id = id;
        this.nom = nom;
        this.coche = coche;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isCoche() {
        return coche;
    }

    public void setCoche(boolean coche) {
        this.coche = coche;
    }
}

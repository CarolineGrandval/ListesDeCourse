package fr.eni.dal;

import fr.eni.bo.Article;
import fr.eni.bo.Liste;

import java.util.List;

public interface ListeDAO {

    void insert(Liste liste) throws DalException;
    List<Liste> selectAll() throws DalException;
    Liste selectById(int id) throws DalException;
    Article selectArticleById(int id) throws DalException;
    void delete(int idListe) throws DalException;
    void reinitialize(int idListe);
    void updateCoche(int id);
    void updateDecoche(int id);
}

package fr.eni.dal;

import fr.eni.bo.Article;
import fr.eni.bo.Liste;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListeDAOImpl implements ListeDAO {

    private static final String INSERT_LISTES = "INSERT INTO LISTES (nom) VALUES (?);";
    private static final String INSERT_ARTICLES = "INSERT INTO ARTICLES (nom, id_liste) VALUES (?, ?);";
    private static final String SELECT_ALL = "SELECT ARTICLES.id, ARTICLES.nom, id_liste, coche, LISTES.id, LISTES.nom " +
            "FROM ARTICLES INNER JOIN LISTES ON LISTES.id = id_liste " ;
    private static final String SELECT_BY_ID = "SELECT ARTICLES.id, ARTICLES.nom, id_liste, coche, LISTES.id, LISTES.nom " +
            "FROM ARTICLES INNER JOIN LISTES ON LISTES.id = id_liste WHERE LISTES.id=?" ;
    private static final String DELETE = "DELETE FROM LISTES WHERE id = ?";
    private static final String UPDATE_DECOCHER = "UPDATE ARTICLES SET coche=0 WHERE id_liste=?";
    private static final String UPDATE_COCHE = "UPDATE ARTICLES SET coche = 1 WHERE id = ?";
    private static final String REINITIALIZE = "UPDATE ARTICLES SET coche = 0 WHERE id_liste = ?";
    private static final String SELECT_ARTICLE_BY_ID = "SELECT id, nom, id_liste, coche FROM ARTICLES WHERE id=?" ;

    @Override
    public void insert(Liste liste) throws DalException {
        try (
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement psmt = connection.prepareStatement(INSERT_LISTES,
                        PreparedStatement.RETURN_GENERATED_KEYS);
                PreparedStatement psmt2 = connection.prepareStatement(INSERT_ARTICLES,
                        PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            // J'insere la liste en base de données
            psmt.setString(1, liste.getNom());
            psmt.executeUpdate();
            ResultSet rs = psmt.getGeneratedKeys();
            if (rs.next()) {
                liste.setIdListe(rs.getInt(1));
            }
            // J'insère les articles en base de données
            for (Article a : liste.getListeArticles()) {
                psmt2.setString(1, a.getNom());
                psmt2.setInt(2, liste.getIdListe());
                psmt2.executeUpdate();
                ResultSet rs2 = psmt.getGeneratedKeys();
                if (rs.next()) {
                    a.setId(rs2.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DalException("Erreur lors de l'insertion en bdd");
        }
    }

    @Override
    public List<Liste> selectAll() throws DalException {
        List<Liste> listeDesListes = new ArrayList<>();
        try(Connection connection = ConnectionProvider.getConnection();) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            Liste listeEnCours = new Liste();
            while (rs.next()){
                if (rs.getInt(5) != listeEnCours.getIdListe()) {
                    listeEnCours = new Liste();
                    listeEnCours.setIdListe(rs.getInt(5));
                    listeEnCours.setNom(rs.getString(6));
                    listeDesListes.add(listeEnCours);
                }

                boolean coche;
                if(rs.getByte(4) == 0){  coche = false  ;
                }else{  coche = true  ; }

                Article art = new Article(
                        rs.getInt(1),
                        rs.getString(2),
                        coche);

                listeEnCours.getListeArticles().add(art);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DalException("erreur lors de la récupération en bdd");
        }
        return listeDesListes;
    }

    @Override
    public Liste selectById(int id) throws DalException {
        Liste liste = new Liste();
        try (Connection connection = ConnectionProvider.getConnection();) {

            PreparedStatement pstt = connection.prepareStatement(SELECT_BY_ID);
            pstt.setInt(1, id);
            ResultSet rs = pstt.executeQuery();

            while (rs.next()) {
                liste.setIdListe(id);
                liste.setNom(rs.getString(6));

                boolean coche;
                if (rs.getByte(4) == 0) {
                    coche = false;
                } else {
                    coche = true;
                }

                Article art = new Article(
                        rs.getInt(1),
                        rs.getString(2),
                        coche);

                liste.getListeArticles().add(art);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DalException("erreur lors de la récupération par id");
        }
        return liste;
    }

    @Override
    public Article selectArticleById(int id) throws DalException {
        Article art = null;
        try (Connection connection = ConnectionProvider.getConnection();) {
            PreparedStatement pstt = connection.prepareStatement(SELECT_ARTICLE_BY_ID);
            pstt.setInt(1, id);
            ResultSet rs = pstt.executeQuery();

            while (rs.next()) {
                boolean coche;
                if (rs.getByte(4) == 0) {
                    coche = false;
                } else {
                    coche = true;
                }

                art = new Article(
                        rs.getInt(1),
                        rs.getString(2),
                        coche);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DalException("erreur lors de la récupération de l'article par id");
        }
        return art;
    }

    @Override
    public void delete(int id) throws DalException {
        try(Connection connection = ConnectionProvider.getConnection();) {
            PreparedStatement pstt = connection.prepareStatement(DELETE);
            pstt.setInt(1, id);
            pstt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DalException("Erreur lors de la suppression en BDD");
        }
    }

    @Override
    public void reinitialize(int id) {
        try (
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement rqt = connection.prepareStatement(REINITIALIZE);
        ){
            rqt.setInt(1, id);
            rqt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void updateCoche(int id) {
        try (
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement rqt = connection.prepareStatement(UPDATE_COCHE);
        ){
            rqt.setInt(1, id);
            rqt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void updateDecoche(int id) {
        try (
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement rqt = connection.prepareStatement(UPDATE_DECOCHER);
        ){
            rqt.setInt(1, id);
            rqt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}

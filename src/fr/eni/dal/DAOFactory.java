package fr.eni.dal;

public class DAOFactory {
    public static ListeDAO getListeDAO() {
        return new ListeDAOImpl();
    }
}

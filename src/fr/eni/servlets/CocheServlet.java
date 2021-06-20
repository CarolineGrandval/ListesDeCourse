package fr.eni.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/coche")
public class CocheServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;
        System.out.println("passage dans la servlet coche");
        String nomArticle = req.getParameter("article");
        System.out.println(nomArticle);
        req.getRequestDispatcher("articles").forward(req, resp);
    }
}

package OffreEmploi.SERVLET;

import OffreEmploi.DAO.OffreEmploiDAO;
import OffreEmploi.Model.OffreEmploi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jobOffers")
public class OffreEmploiServlet extends HttpServlet {
    private OffreEmploiDAO offreEmploiDAO;

    @Override
    public void init() throws ServletException {
        try {
            offreEmploiDAO = new OffreEmploiDAO();

        } catch (SQLException e) {
            throw new ServletException("Unable to initialize DAO", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        List<OffreEmploi> offres ;
        try {
            offres = offreEmploiDAO.getAllOffres();
            System.out.println(offres.get(0).toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (OffreEmploi offre : offres) {
            System.out.println(offre.toString());
        }
        try {
            if ("list".equals(action)) {
                List<OffreEmploi> offress = offreEmploiDAO.getAllOffres();
                request.setAttribute("offers", offress);
                System.out.println(offres);
                request.getRequestDispatcher("/jobOffersList.jsp").forward(request, response);
            } else if ("view".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                OffreEmploi offre = offreEmploiDAO.getOffreById(id);
                request.setAttribute("offer", offre);
                request.getRequestDispatcher("/OffreEmploi.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("create".equals(action)) {
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                int recruiterId = Integer.parseInt(request.getParameter("recruiter_id"));

                OffreEmploi offre = new OffreEmploi(title, description, recruiterId);
                offreEmploiDAO.createOffre(offre);
                response.sendRedirect("jobOffers?action=list");


            } else if ("update".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                OffreEmploi offre = offreEmploiDAO.getOffreById(id);
                request.setAttribute("offre", offre);
                request.getRequestDispatcher("/updateJobOffer.jsp").forward(request, response);

            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                offreEmploiDAO.deleteOffre(id);
                response.sendRedirect("jobOffers?action=list");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}





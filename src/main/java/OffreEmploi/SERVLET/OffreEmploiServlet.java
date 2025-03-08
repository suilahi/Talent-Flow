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

        try {
            if ("list".equals(action) || action == null) { // Default to list
                List<OffreEmploi> offres = offreEmploiDAO.getAllOffres();
                request.setAttribute("offreEmploi", offres); // Matches offerEmploi.jsp
                request.getRequestDispatcher("/offerEmploi.jsp").forward(request, response);
            } else if ("edit".equals(action)) { // Load offer for editing
                int id = Integer.parseInt(request.getParameter("id"));
                OffreEmploi offre = offreEmploiDAO.getOffreById(id);
                if (offre != null) {
                    request.setAttribute("offre", offre); // Matches updateOffer.jsp
                    request.getRequestDispatcher("/updateOffer.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Offer not found");
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid offer ID");
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

                if (title == null || description == null || title.trim().isEmpty() || description.trim().isEmpty()) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Title and description are required");
                    return;
                }

                OffreEmploi offre = new OffreEmploi(title, description, recruiterId);
                offreEmploiDAO.createOffre(offre);
                response.sendRedirect("jobOffers?action=list");

            } else if ("update".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                int recruiterId = Integer.parseInt(request.getParameter("recruiter_id"));

                if (title == null || description == null || title.trim().isEmpty() || description.trim().isEmpty()) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Title and description are required");
                    return;
                }

                OffreEmploi offre = new OffreEmploi(id, title, description, recruiterId);
                offreEmploiDAO.updateOffre(offre);
                response.sendRedirect("jobOffers?action=list");

            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                offreEmploiDAO.deleteOffre(id);
                response.sendRedirect("jobOffers?action=list");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input");
        }
    }
}


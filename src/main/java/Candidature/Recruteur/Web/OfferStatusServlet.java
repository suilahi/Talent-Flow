package Candidature.Recruteur.Web;

import Candidature.Recruteur.DAO.OfferStatusDAO;
import Candidature.Recruteur.Model.OfferStatusModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/OfferStatusServlet")
public class OfferStatusServlet extends HttpServlet {
    private OfferStatusDAO offerStatusDAO;

    @Override
    public void init() {
        try {
            offerStatusDAO = new OfferStatusDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jobId = Integer.parseInt(request.getParameter("jobId"));
        String filter = request.getParameter("filter");
        String sort = request.getParameter("sort");

        List<OfferStatusModel> candidatures = offerStatusDAO.getCandidaturesByJob(jobId, filter, sort);
        request.setAttribute("candidatures", candidatures);
        request.getRequestDispatcher("liste_candidatures.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int candidatureId = Integer.parseInt(request.getParameter("candidatureId"));
        String newStatus = request.getParameter("status");

        offerStatusDAO.updateStatus(candidatureId, newStatus);
        response.sendRedirect("OfferStatusServlet?jobId=" + request.getParameter("jobId"));
    }
}

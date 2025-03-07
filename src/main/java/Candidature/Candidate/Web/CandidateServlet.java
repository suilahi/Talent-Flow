package Candidature.Candidate.Web;

import Candidature.Candidate.DAO.CandidateDAO;
import Candidature.Candidate.Model.CandidateModel;
import authentification.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CandidateServlet")
public class CandidateServlet extends HttpServlet {

    private CandidateDAO candidateDAO;

    public void init() {
        try {
            candidateDAO = new CandidateDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {






        String phone = request.getParameter("phone");
        String cv = request.getParameter("cv");

        System.out.println("Valeur de phone: " + request.getParameter("phone"));
        System.out.println("Valeur de cv: " + request.getParameter("cv"));



        CandidateModel candidate = new CandidateModel("NomParDefaut", "EmailParDefaut", phone, cv);

        candidateDAO.Postuler(candidate);

        response.sendRedirect("dashbordCondidature.jsp");
    }
}


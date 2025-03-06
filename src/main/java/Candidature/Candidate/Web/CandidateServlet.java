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

@WebServlet("/addCandidate")
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

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String roleStr = request.getParameter("role");
        String cv = request.getParameter("cv");

        User.role role = User.UserRole.valueOf(roleStr.toUpperCase());
        System.out.println(roleStr);

        CandidateModel candidate = new CandidateModel(name, email, password, role, cv);
        candidateDAO.addCandidate(candidate);

        response.sendRedirect("success.jsp");
    }
}


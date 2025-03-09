
package Candidature.Candidate.Web;

import Candidature.Candidate.DAO.CandidateDAO;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/postuler")
public class CandidateServlet extends HttpServlet {

    private CandidateDAO candidateApplicationDAO ;

    public void init()  {
        try {
            candidateApplicationDAO=new CandidateDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        HttpSession session = req.getSession();
        Integer candidateId = (Integer) session.getAttribute("userID");
        int jobId = Integer.parseInt(req.getParameter("jobId"));

        if (candidateId == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        candidateApplicationDAO.postuler(candidateId, jobId);
        resp.sendRedirect("dashbordCondidature.jsp?success=1");
    }}
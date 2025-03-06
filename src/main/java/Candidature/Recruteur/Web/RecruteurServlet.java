package Candidature.Recruteur.Web;

import Candidature.Recruteur.DAO.RecruteurDAO;
import Candidature.Recruteur.Model.RecruteurModel;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/recruteur")
public class RecruteurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RecruteurDAO recruteurDAO = new RecruteurDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            List<RecruteurModel> recruteurs = recruteurDAO.obtenirTousLesRecruteurs();
            request.setAttribute("recruteurs", recruteurs);
            request.getRequestDispatcher("recruteurs.jsp").forward(request, response);
        } else if (action.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            RecruteurModel recruteur = recruteurDAO.obtenirRecruteurParId(id);
            request.setAttribute("recruteur", recruteur);
            request.getRequestDispatcher("editRecruteur.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String company = request.getParameter("company");

            RecruteurModel recruteur = new RecruteurModel(0, name, email, password, company);
            recruteurDAO.ajouterRecruteur(recruteur);
            response.sendRedirect("recruteur");
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String company = request.getParameter("company");

            RecruteurModel recruteur = new RecruteurModel(id, name, email, password, company);
            recruteurDAO.mettreAJourRecruteur(recruteur);
            response.sendRedirect("recruteur");
        }
    }
}

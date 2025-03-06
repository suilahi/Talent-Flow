package authentification.Servlet;

import authentification.Dao.UserDao;
import Utils.DBConnection;
import authentification.Model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("motdepasse");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");

        User users = new User(name,email,password,role);
        UserDao userDAO = null;
        userDAO = new UserDao(DBConnection.getConnection());

        try {
            userDAO.addUser(users);
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        UserDao userDAO = new UserDao(DBConnection.getConnection());
        try {
            userDAO.getAllUsers();
        } catch (SQLException e) {
        }

    }
}

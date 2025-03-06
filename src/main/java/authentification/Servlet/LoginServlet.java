package authentification.Servlet;

import authentification.Dao.UserDao;
import Utils.DBConnection;
import authentification.Model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection connection = DBConnection.getConnection();
        UserDao userDao = new UserDao(connection);

        try {
            User users = UserDao.getUserByEmail(email);

            if (users != null && users.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", users);
                session.setAttribute("role", users.getRole());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

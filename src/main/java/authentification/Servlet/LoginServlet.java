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
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection connection= null;
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        UserDao userDao = new UserDao(connection);

        try {
            User user = userDao.getUserByEmail(email);

            if (user != null && user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
            } else {
                response.sendRedirect("login.jsp");
                System.out.println("error");
            }
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp");
        }
        }


}

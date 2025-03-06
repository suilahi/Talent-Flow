<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="authentification.Model.User"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession sessionObj = request.getSession(false);
    User users = (sessionObj != null) ? (User) sessionObj.getAttribute("user") : null;

    if (users == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>

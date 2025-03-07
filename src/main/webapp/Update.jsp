<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="OffreEmploi.Model.OffreEmploi" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update Job Offer</title>
</head>
<body>
<h1>Update Job Offer</h1>

<%
    // Retrieve the job offer object from the request
    OffreEmploi offre = (OffreEmploi) request.getAttribute("offre");
%>

<form action="jobOffers" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%= offre.getId() %>">

    <label for="title">Title:</label>
    <input type="text" id="title" name="title" value="<%= offre.getTitle() %>" required><br><br>

    <label for="description">Description:</label><br>
    <textarea id="description" name="description" rows="4" cols="50" required><%= offre.getDescription() %></textarea><br><br>

    <label for="recruiter_id">Recruiter ID:</label>
    <input type="number" id="recruiter_id" name="recruiter_id" value="<%= offre.getRecruiter() %>" required><br><br>

    <input type="submit" value="Update Job Offer">
</form>

<a href="jobOffers?action=list">Back to Job Offers List</a>
</body>
</html>
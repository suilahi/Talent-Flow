<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Job Offers</title>
</head>
<body>
<h1>Job Offers</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Recruiter ID</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="offre" items="${offres}">
        <tr>
            <td>${offre.id}</td>
            <td>${offre.title}</td>
            <td>${offre.description}</td>
            <td>${offre.recruiter}</td>
            <td>
                <a href="jobOffers?action=view&id=${offre.id}">View</a>
                <a href="jobOffers?action=update&id=${offre.id}">Edit</a>
                <a href="jobOffers?action=delete&id=${offre.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="jobOfferForm.jsp">Create New Job Offer</a>
</body>
</html>
